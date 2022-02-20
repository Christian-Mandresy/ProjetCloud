package com.cloudproject.backoffice.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.cloudproject.backoffice.dao.RoleDao;
import com.cloudproject.backoffice.dao.UtilisateurDao;
import com.cloudproject.backoffice.model.ERole;
import com.cloudproject.backoffice.model.Role;
import com.cloudproject.backoffice.model.Utilisateur;
import com.cloudproject.backoffice.payload.request.LoginRequest;
import com.cloudproject.backoffice.payload.request.SignupRequest;
import com.cloudproject.backoffice.payload.response.JwtResponse;
import com.cloudproject.backoffice.payload.response.MessageResponse;
import com.cloudproject.backoffice.security.jwt.JwtUtils;
import com.cloudproject.backoffice.security.services.UserDetailsImpl;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UtilisateurDao userRepository;

  @Autowired
  RoleDao roleDao;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;

  @PostMapping("/signin")
  @Transactional
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);
    
    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
    Hibernate.initialize(userDetails.getAuthorities());
    List<String> roles = userDetails.getAuthorities().stream()
        .map(item -> item.getAuthority())
        .collect(Collectors.toList());
      Hibernate.initialize(userDetails.getAuthorities());

    return ResponseEntity.ok(new JwtResponse(jwt,
                         userDetails.getId(),
                         userDetails.getEmail(), 
                         roles));
  }

  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {

    if(userRepository.getUtilisateurByName(signUpRequest.getEmail())!=null)
    {
      return ResponseEntity
              .badRequest()
              .body(new MessageResponse("Error: cet Email est deja utilise "));
    }

    // Create new user's account
    Utilisateur user = new Utilisateur(signUpRequest.getEmail(),
               encoder.encode(signUpRequest.getPassword()));

    Hibernate.initialize(signUpRequest.getRole());
    Set<String> strRoles = signUpRequest.getRole();
    Set<Role> roles = new HashSet<>();

    if (strRoles == null) {
      Role userRole = roleDao.findByName(ERole.ROLE_USER);
              if(userRole==null)
              {
                throw new RuntimeException("Error: Role is not found.");
              }
      roles.add(userRole);
    } else {
      strRoles.forEach(role -> {
        switch (role) {
        case "admin":
          Role adminRole = roleDao.findByName(ERole.ROLE_ADMIN);
          if(adminRole==null)
          {
            throw new RuntimeException("Error: Role is not found.");
          }
          roles.add(adminRole);
        default:
          Role userRole = roleDao.findByName(ERole.ROLE_USER);
          if(userRole==null)
          {
            throw new RuntimeException("Error: Role is not found.");
          }
          roles.add(userRole);
        }
      });
    }

    user.setRoles(roles);
    System.out.print(user);
      System.out.print(" Email : "+user.getEmail());
      System.out.print(" mdp :  "+user.getMotDePasse());
    try {
        userRepository.save(user);
    }catch (Exception e)
    {
        e.printStackTrace();
    }
    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
  }
}

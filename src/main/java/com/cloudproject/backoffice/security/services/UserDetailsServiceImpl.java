package com.cloudproject.backoffice.security.services;

import com.cloudproject.backoffice.dao.UtilisateurDao;
import com.cloudproject.backoffice.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  @Autowired
  UtilisateurDao userRepository;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Utilisateur user = userRepository.getUtilisateurByName(username);
    if(user==null)
    {
      throw new UsernameNotFoundException("User Not Found with username: " + username);
    }
    return UserDetailsImpl.build(user);
  }

}

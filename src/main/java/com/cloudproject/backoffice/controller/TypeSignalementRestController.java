package com.cloudproject.backoffice.controller;

import com.cloudproject.backoffice.model.Type;
import com.cloudproject.backoffice.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RequestMapping("/typeSignalement/*")
public class TypeSignalementRestController {
    private TypeService typeService;

    @Autowired
    public void setTypeService(TypeService typeService) {
        this.typeService = typeService;
    }

    @GetMapping(value = "/typesignalements")
    public ResponseEntity<Collection<Type>> getAllSign() {
        Collection<Type> lestypes = typeService.geType();
        return new ResponseEntity<Collection<Type>>(lestypes, HttpStatus.FOUND);
    }
}

package com.cloudproject.backoffice.service.impl;

import com.cloudproject.backoffice.dao.TypeDao;
import com.cloudproject.backoffice.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    private TypeDao typeDao;

    @Autowired
    public void setTypeDao(TypeDao typeDao) {
        this.typeDao = typeDao;
    }

    @Override
    public List geType()
    {
        return typeDao.getType();
    }
}

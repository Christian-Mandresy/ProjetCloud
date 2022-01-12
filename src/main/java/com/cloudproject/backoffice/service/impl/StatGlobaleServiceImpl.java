package com.cloudproject.backoffice.service.impl;

import com.cloudproject.backoffice.dao.StatGlobaleDao;
import com.cloudproject.backoffice.service.StatGlobaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatGlobaleServiceImpl implements StatGlobaleService {
    private StatGlobaleDao statGlobaleDao;

    @Autowired
    public void setStatGlobaleDao(StatGlobaleDao statGlobaleDao) {
        this.statGlobaleDao = statGlobaleDao;
    }

    @Override
    public List getStatRegion()
    {
        return statGlobaleDao.getStatRegion();
    }

    @Override
    public List getStatType()
    {
        return statGlobaleDao.getStatType();
    }

    @Override
    public List getStatStatus()
    {
        return statGlobaleDao.getStatStatus();
    }

}

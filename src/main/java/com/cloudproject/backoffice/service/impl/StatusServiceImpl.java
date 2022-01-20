package com.cloudproject.backoffice.service.impl;

import com.cloudproject.backoffice.dao.StatusDao;
import com.cloudproject.backoffice.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusServiceImpl implements StatusService {
    private StatusDao statusDao;

    @Autowired
    public void setStatusDao(StatusDao statusDao) {
        this.statusDao = statusDao;
    }

    @Override
    public List getStatus()
    {
        return statusDao.getStatus();
    }
}

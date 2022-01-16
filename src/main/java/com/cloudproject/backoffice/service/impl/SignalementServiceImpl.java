package com.cloudproject.backoffice.service.impl;

import com.cloudproject.backoffice.dao.SignalementDao;
import com.cloudproject.backoffice.model.Signalement;
import com.cloudproject.backoffice.service.SignalementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignalementServiceImpl implements SignalementService {
    private SignalementDao signalementDao;

    @Autowired
    public void setSignalementDao(SignalementDao signalementDao) {
        this.signalementDao = signalementDao;
    }

    @Override
    public List getAllSign()
    {
        return signalementDao.getAllSign();
    }

    @Override
    public List getNonAssigner()
    {
        return signalementDao.getNonAssigner();
    }

    @Override
    public Signalement getSign(int id)
    {
        return signalementDao.getSign(id);
    }
}

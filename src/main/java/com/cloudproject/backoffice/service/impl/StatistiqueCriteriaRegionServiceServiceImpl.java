package com.cloudproject.backoffice.service.impl;

import com.cloudproject.backoffice.dao.StatistiqueCriteriaRegionDao;
import com.cloudproject.backoffice.service.StatistiqueCriteriaRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("SignalEtRegionService")
public class StatistiqueCriteriaRegionServiceServiceImpl implements StatistiqueCriteriaRegionService {
    private StatistiqueCriteriaRegionDao statistiqueCriteriaRegionDao;

    @Autowired
    public void setStatistiqueCriteriaRegionDao(StatistiqueCriteriaRegionDao statistiqueCriteriaRegionDao) {
        this.statistiqueCriteriaRegionDao = statistiqueCriteriaRegionDao;
    }

    @Override
    public List getStat(int type, int etat, String region, Date dateDeb, Date dateFin)
    {
        return statistiqueCriteriaRegionDao.rechercher(type,etat,region,dateDeb,dateFin);
    }

    @Override
    public List find(int type, int etat, String region, Date dateDeb, Date dateFin)
    {
        return statistiqueCriteriaRegionDao.rechercherCritere(type,etat,region,dateDeb,dateFin);
    }
}

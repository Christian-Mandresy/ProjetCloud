package com.cloudproject.backoffice.service.impl;

import com.cloudproject.backoffice.dao.RegionDao;
import com.cloudproject.backoffice.model.Region;
import com.cloudproject.backoffice.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("RegionService")
public class RegionServiceImpl implements RegionService {
    private RegionDao regionDao;

    @Autowired
    public void setRegionDao(RegionDao regionDao) {
        this.regionDao = regionDao;
    }

    @Override
    public List<Region> getRegion(){
        List<Region> valiny=new ArrayList<Region>();
        valiny=(List<Region>)regionDao.getRegion();
        return valiny;
    }
}

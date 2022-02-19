package com.cloudproject.backoffice.service;

import com.cloudproject.backoffice.dao.RegionDao;
import com.cloudproject.backoffice.model.Region;

import java.util.List;

public interface RegionService {
    List<Region> getRegion();

    List<Region> getRegionNom(String nom);
}

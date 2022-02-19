package com.cloudproject.backoffice.dao;

import com.cloudproject.backoffice.model.Region;

import java.util.List;

public interface RegionDao {

    List<Region> getRegion();

    List<Region> getRegionNom(String nomRegion);
}

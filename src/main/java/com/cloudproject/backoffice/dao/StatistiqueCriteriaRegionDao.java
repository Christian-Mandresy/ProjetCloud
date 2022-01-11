package com.cloudproject.backoffice.dao;

import java.util.Date;
import java.util.List;

public interface StatistiqueCriteriaRegionDao {
    List rechercher(int type, int etat, String region, Date dateDeb, Date dateFin);
}

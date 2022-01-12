package com.cloudproject.backoffice.service;

import java.util.Date;
import java.util.List;

public interface StatistiqueCriteriaRegionService {
    List getStat(int type, int etat, String region, Date dateDeb, Date dateFin);

    List find(int type, int etat, String region, Date dateDeb, Date dateFin);
}

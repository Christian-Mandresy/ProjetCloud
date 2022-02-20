package com.cloudproject.backoffice.dao;

import com.cloudproject.backoffice.model.Signalement;

import java.util.List;

public interface SignalementDao {
    List getAllSign();

    List getNonAssigner();

    Signalement getSign(int id);

    List getSignRegion(int IdRegion);

    List getSignUser(int idUser);
}

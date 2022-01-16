package com.cloudproject.backoffice.dao;

import com.cloudproject.backoffice.model.Signalement;

import java.util.List;

public interface SignalementDao {
    List getAllSign();

    List getNonAssigner();

    Signalement getSign(int id);
}

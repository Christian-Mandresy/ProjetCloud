package com.cloudproject.backoffice.service;

import com.cloudproject.backoffice.model.Signalement;

import java.util.List;

public interface SignalementService {
    List getAllSign();

    List getNonAssigner();

    Signalement getSign(int id);
}

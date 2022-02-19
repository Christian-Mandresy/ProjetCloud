package com.cloudproject.backoffice.dao;

import com.cloudproject.backoffice.model.Signalement;
import java.util.Date;

import java.util.List;

public interface SignalementDao {
    List getNonAssigner();

    Signalement getSign(int id);

    List getSignRegion(int IdRegion);

    void UpdateSignalement(int IdSignalement, Integer IdUtilisateur, int IdType, int IdStatus, String DescriptionSignalement, float Longitude, float Latitude, Date DateHeureSignalement);

    List<Signalement> getAllSign();
}

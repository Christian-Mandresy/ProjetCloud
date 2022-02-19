package com.cloudproject.backoffice.service;

import com.cloudproject.backoffice.model.Signalement;
import java.util.Date;

import java.util.List;

public interface SignalementService {
    public List<Signalement> getAllSign();

    public List getNonAssigner();

    public Signalement getSign(int id);

    public List getSignRegion(int Id);

    public void updateSignalement(int IdSignalement, Integer IdUtilisateur, int IdType, int IdStatus, String DescriptionSignalement, float Longitude, float Latitude, Date DateHeureSignalement);
}

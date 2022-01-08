package com.cloudproject.backoffice.mapper;
import com.cloudproject.backoffice.model.ResponsableRegion;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class ResponsableRegionMapper implements RowMapper<ResponsableRegion> {
    public static final String BASE_SQL //
            = "Select RR.IdResponsable, RR.IdRegion, RR.Nom, RR.Prenom, RR.Email, RR.MotDePasse From ResponsableRegion RR ";

    @Override
    public ResponsableRegion mapRow(ResultSet rs, int rowNum) throws SQLException {
        int IdResponsable=rs.getInt("IdResponsableRegion");
        int IdRegion=rs.getInt("IdRegion");
        String Nom=rs.getString("Nom");
        String Prenom=rs.getString("Prenom");
        String Email=rs.getString("Email");
        String MotDePasse=rs.getString("MotDePasse");
        return new ResponsableRegion(IdResponsable,IdRegion,Nom,Prenom,Email,MotDePasse);
    }
}

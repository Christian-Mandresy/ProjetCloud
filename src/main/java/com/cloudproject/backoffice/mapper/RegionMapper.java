package com.cloudproject.backoffice.mapper;

import com.cloudproject.backoffice.model.Region;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RegionMapper implements RowMapper<Region> {
    @Override
    public Region mapRow(ResultSet rs, int rowNum) throws SQLException {
        int id=rs.getInt("IdRegion");
        String nomRegion=rs.getString("NomRegion");
        return new Region(id,nomRegion);
    }
}

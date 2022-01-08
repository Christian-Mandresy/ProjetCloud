package com.cloudproject.backoffice.dao.impl;

import com.cloudproject.backoffice.dao.RegionDao;
import com.cloudproject.backoffice.mapper.RegionMapper;
import com.cloudproject.backoffice.model.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("regionDao")
public class RegionDaoImpl extends JdbcDaoSupport implements RegionDao {
    @Autowired
    public RegionDaoImpl(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    @Override
    public List<Region> getRegion() {
        // Select ba.Id, ba.Full_Name, ba.Balance From Bank_Account ba
        String sql ="select region.IdRegion,region.NomRegion from region";

        RowMapper<Region> rowMapper = new RowMapper<Region>() {
            public Region mapRow(ResultSet rs, int rowNum) throws SQLException {
                Region region = new Region();
                region.setIdRegion(rs.getInt("IdRegion"));
                region.setNomRegion(rs.getString("NomRegion"));
                return region;
            }
        };

        List<Region> liste = this.getJdbcTemplate().query(sql,rowMapper);

        int tsisy=0;
        return liste;
    }
}

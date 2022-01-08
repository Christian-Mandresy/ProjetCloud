package com.cloudproject.backoffice.dao.impl;

import com.cloudproject.backoffice.dao.ResponsableRegionDao;
import com.cloudproject.backoffice.mapper.ResponsableRegionMapper;
import com.cloudproject.backoffice.model.ResponsableRegion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

@Repository("responsableRegionDao")
public class ResponsableRegionDaoImpl extends JdbcDaoSupport implements ResponsableRegionDao {

    @Autowired
    public ResponsableRegionDaoImpl(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    @Override
    public List<ResponsableRegion> getRespRegion() {
        // Select ba.Id, ba.Full_Name, ba.Balance From Bank_Account ba
        String sql = ResponsableRegionMapper.BASE_SQL;

        Object[] params = new Object[] {};
        ResponsableRegionMapper mapper = new ResponsableRegionMapper();
        List<ResponsableRegion> list = this.getJdbcTemplate().query(sql, params, mapper);

        return list;
    }

    @Override
    public void InsertRespRegion(int idRegion, String nom, String prenom, String email, String motDePasse){
        String sql="insert into ResponsableRegion(IdRegion, Nom, Prenom, Email, MotDePasse) values (?,?,?,?,?,?,?)";
        this.getJdbcTemplate().update(sql,idRegion,nom,prenom,email,motDePasse);
    }


}

package com.cloudproject.backoffice.dao.impl;

import com.cloudproject.backoffice.dao.StatistiqueCriteriaRegionDao;
import com.cloudproject.backoffice.model.StatistiqueCriteriaRegion;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository("SignalEtRegionDao")
public class StatistiqueCriteriaRegionDaoDaoImpl implements StatistiqueCriteriaRegionDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List rechercher(int type, int etat, String region, Date dateDeb, Date dateFin) {
        Session session = this.sessionFactory.openSession();
        // test si dans la clause where il faut mettre where ou and
        Boolean test=true;
        Boolean testOrder=true;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        StringBuilder sql=new StringBuilder("select *,count(IdSignalement)as Nombre from SignalEtRegion ");
        StringBuilder order=new StringBuilder(" group by ");
        if (dateDeb != null) {
            sql.append(test ? "where " : " and ");
            sql.append("DateHeureSignalement between "+"'"+dateFormat.format(dateDeb)+"'"+" and "+"'"+dateFormat.format(dateFin)+"'");
            test=false;
        }
        if (type != 0) {
            sql.append(test ? "where " : " and ");
            sql.append("IdType = "+type);
            test=false;
        }
        else if(type == 0)
        {
            order.append(testOrder ? "" : ",");
            order.append(" IdType ");
            testOrder=false;
        }
        if (etat != 0) {
            sql.append(test ? "where " : " and ");
            sql.append("IdStatus = "+etat);
            test=false;
        }
        else if(etat == 0)
        {
            order.append(testOrder ? "" : ",");
            order.append(" IdStatus ");
            testOrder=false;
        }
        if (region.equals("")==false) {
            sql.append(test ? "where " : " and ");
            sql.append("NomRegion = "+"'"+region+"'");
            test=false;
        }
        else if(region.equals("")==true)
        {
            order.append(testOrder ? "" : ",");
            order.append(" IdRegion ");
            testOrder=false;
        }
        int t=0;
        if(testOrder == false)
        {
            sql.append(order.toString());
        }
        String queryFinal=sql.toString();
        SQLQuery query= session.createSQLQuery(queryFinal)
                .addEntity(StatistiqueCriteriaRegion.class);
        List resultat = query.list();

        return resultat;
    }
}

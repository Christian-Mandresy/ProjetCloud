package com.cloudproject.backoffice.dao.impl;

import com.cloudproject.backoffice.dao.RoleDao;
import com.cloudproject.backoffice.model.ERole;
import com.cloudproject.backoffice.model.Role;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("RoleDao")
public class RoleDaoImpl implements RoleDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Role findByName(ERole name)
    {
        Session session=sessionFactory.openSession();
        Criteria criteria=session.createCriteria(Role.class);
        criteria.add(Restrictions.eq("name",name));
        List val=criteria.list();
        if(val==null)
        {
            session.close();
            return null;
        }
        else
        {
            session.close();
            return (Role)val.get(0);
        }
    }
}

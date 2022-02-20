package com.cloudproject.backoffice.dao;

import com.cloudproject.backoffice.model.ERole;
import com.cloudproject.backoffice.model.Role;

public interface RoleDao {
    Role findByName(ERole name);
}

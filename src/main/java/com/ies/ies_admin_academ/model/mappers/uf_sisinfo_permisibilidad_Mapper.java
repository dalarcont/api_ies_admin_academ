package com.ies.ies_admin_academ.model.mappers;

import com.ies.ies_admin_academ.model.entities.uf_sisinfo_permisibilidad;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class uf_sisinfo_permisibilidad_Mapper implements RowMapper<uf_sisinfo_permisibilidad> {
    @Override
    public uf_sisinfo_permisibilidad mapRow(ResultSet rs, int rowNum) throws SQLException{
        uf_sisinfo_permisibilidad userApps_permissions = new uf_sisinfo_permisibilidad();
        userApps_permissions.setUsername(rs.getString("nickname"));
        userApps_permissions.setApp_name(rs.getString("app_name"));
        userApps_permissions.setPermission(rs.getBoolean("permission"));
        return userApps_permissions;
    }

}

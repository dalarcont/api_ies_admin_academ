package com.ies.ies_admin_academ.model.mappers;

import com.ies.ies_admin_academ.model.entities.uf_sisinfo_userapps;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class uf_sisinfo_userapps_Mapper implements RowMapper<uf_sisinfo_userapps> {
    @Override
    public uf_sisinfo_userapps mapRow(ResultSet rs, int rowNum) throws SQLException{
        uf_sisinfo_userapps userApps = new uf_sisinfo_userapps();
        //Get value from query and set it
        userApps.setUser(rs.getString("nickname"));
        userApps.setAppcode(rs.getString("appcode"));
        userApps.setPermission(rs.getBoolean("permission"));
        userApps.setAppname(rs.getString("appname"));
        userApps.setAppdescr(rs.getString("appdescription"));
        userApps.setTreelevel(rs.getInt("treelevel"));
        return userApps;
    }

}

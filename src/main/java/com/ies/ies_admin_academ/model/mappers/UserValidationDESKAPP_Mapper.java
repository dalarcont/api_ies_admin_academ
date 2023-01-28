package com.ies.ies_admin_academ.model.mappers;

import com.ies.ies_admin_academ.model.entities.uf_portallaboral;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


    public class UserValidationDESKAPP_Mapper implements RowMapper<uf_portallaboral> {
        @Override
        public uf_portallaboral mapRow(ResultSet rs, int rowNum) throws SQLException {
            uf_portallaboral uservalidate = new uf_portallaboral();
            uservalidate.setUsername(rs.getString("nickname_usuario"));
            uservalidate.setPassword(rs.getString("pkeyusuario"));
            uservalidate.setDeskapp_access(rs.getInt("deskapp"));
            return uservalidate;
        }
    }

package com.ies.ies_admin_academ.model.mappers;

import com.ies.ies_admin_academ.model.entities.uf_userprofile;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class userProfile_Mapper implements RowMapper<uf_userprofile> {
    @Override
    public uf_userprofile mapRow(ResultSet rs, int rowNum) throws SQLException{
        uf_userprofile userProfile = new uf_userprofile();
        userProfile.setFechaRegistro(rs.getString("fecharegistro"));
        userProfile.setIdPersona(rs.getString("idpersona"));
        userProfile.setNombres(rs.getString("nombres"));
        userProfile.setApellidos(rs.getString("apellidos"));
        userProfile.setUsername(rs.getString("username"));
        userProfile.setGenero(rs.getString("genero"));
        userProfile.setEmailLaboral(rs.getString("email_laboral"));
        userProfile.setOrigenPais(rs.getString("origen_pais"));
        userProfile.setOrigenCiudad(rs.getString("origen_ciudad"));
        userProfile.setResidePais(rs.getString("reside_pais"));
        userProfile.setResideCiudad(rs.getString("reside_ciudad"));
        userProfile.setEscolaridad(rs.getString("escolaridad"));
        userProfile.setNivelCargo(rs.getString("nivelcargo"));
        userProfile.setNombreCargo(rs.getString("nombredelcargo"));
        userProfile.setNombreUnidad(rs.getString("nombreunidad"));
        userProfile.setPkeyUsuario(rs.getString("pkeyusuario"));
        userProfile.setRecuperarPregunta(rs.getString("recuperar_pregunta"));
        userProfile.setRecuperarRespuesta(rs.getString("recuperar_respuesta"));
        userProfile.setUltimoAcceso(rs.getString("ultimoingreso"));

        return userProfile;
    }


}

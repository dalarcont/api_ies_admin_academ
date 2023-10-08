package com.ies.ies_admin_academ.repositories;

import com.ies.ies_admin_academ.config.ErrorCodes;
import com.ies.ies_admin_academ.exceptions.BusinessException;
import com.ies.ies_admin_academ.model.entities.uf_appstates;
import com.ies.ies_admin_academ.model.entities.uf_registro_ejecutivo;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GeneralRepository {
    private final JdbcTemplate daoGeneral;

    public GeneralRepository(JdbcTemplate daoGeneral) {
        this.daoGeneral = daoGeneral;
    }

    /**
     * Get name of an app convention code
     * @param codConv Convention code
     * @param srcTable Source table of convention code
     * @return String convention name
     */
    public String getConventionName(String codConv,String srcTable){
        return daoGeneral.queryForObject(dbQueries.GENERAL.GET_NAME_APP_CONVENTION_CODE_QUERY,
                                            String.class,
                                            srcTable,
                                            srcTable,
                                            codConv);
    }

    /**
     * Get the operation availability of an application by its appcode
     * @param appcode
     * @return
     */
    public uf_appstates getAppStatus(String appcode){
        List<uf_appstates> rs = daoGeneral.query(dbQueries.GENERAL.GET_APP_STATE_QUERY,
                                                    new BeanPropertyRowMapper<>(uf_appstates.class),
                                                    appcode);
        return rs.size() >= 1 ? rs.get(0) : null;
    }


}

package com.ies.ies_admin_academ.POST.USERS;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.ies.ies_admin_academ.config.Routes;
import com.ies.ies_admin_academ.model.entities.uf_personas;
import com.ies.ies_admin_academ.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class PostUserTest {

    @Autowired
    UserRepository uRepo;
    @Autowired
    private MockMvc mmvc;
    @Autowired
    private ObjectMapper objMapper;

    @Test
    void ADD_USER_WORKS() throws Exception{
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post(Routes.ROOT.USERS)
                .content("{\n" +
                        "\"PRSN_ID\":\"12345678901\",\n" +
                        "\"PRSN_NOM\":\"Jesus Javier\",\n" +
                        "\"PRSN_APE\":\"Alarcon Tabima\",\n" +
                        "\"PRSN_USUARIO\":\"jalarcont\",\n" +
                        "\"PRSN_GEN\":\"M\",\n" +
                        "\"PRSN_EMAIL_PERSONAL\":\"jalarcont@gmail.com\",\n" +
                        "\"PRSN_EMAIL_LABORAL\":\"jalarcont@unifalsa.com\",\n" +
                        "\"PRSN_ORIGEN_PAIS\":\"COL\",\n" +
                        "\"PRSN_ORIGEN_CIUDAD\":\"Pacora\",\n" +
                        "\"PRSN_RESIDE_PAIS\":\"COL\",\n" +
                        "\"PRSN_RESIDE_CIUDAD\":\"Pereira\",\n" +
                        "\"PRSN_ESCOLARIDAD\":\"BASC\"\n" +
                        "}")
                .contentType(MediaType.APPLICATION_JSON);

        MockHttpServletResponse response = mmvc.perform(request).andReturn().getResponse();
        Assertions.assertEquals(200,response.getStatus());

        List<uf_personas> user = uRepo.getUserBasicData("jalarcont");
        Assertions.assertEquals(1, user.size());
        //Validation of password for new additions due to the business rule (See UserServiceGeneral method addUser notes)
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        boolean pkeyMatch = encoder.matches(user.get(0).getPRSN_USUARIO()+user.get(0).getPRSN_ID()+"#",user.get(0).getPRSN_PKEY());
        Assertions.assertTrue(pkeyMatch);


    }

    @Test
    void ADD_USER_FAILS() throws Exception{
        //Just need to check if sending a username that already exists we expect a failure
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post(Routes.ROOT.USERS)
                .content("{\n" +
                        "\"PRSN_ID\":\"12345678901\",\n" +
                        "\"PRSN_NOM\":\"Jesus Javier\",\n" +
                        "\"PRSN_APE\":\"Alarcon Tabima\",\n" +
                        "\"PRSN_USUARIO\":\"janistabaress\",\n" +
                        "\"PRSN_GEN\":\"MS\",\n" +
                        "\"PRSN_EMAIL_PERSONAL\":\"jalarcont@gmail.com\",\n" +
                        "\"PRSN_EMAIL_LABORAL\":\"jalarcont@unifalsa.com\",\n" +
                        "\"PRSN_ORIGEN_PAIS\":\"COL\",\n" +
                        "\"PRSN_ORIGEN_CIUDAD\":\"Pacora\",\n" +
                        "\"PRSN_RESIDE_PAIS\":\"COL\",\n" +
                        "\"PRSN_RESIDE_CIUDAD\":\"Pereira\",\n" +
                        "\"PRSN_ESCOLARIDAD\":\"BASC\"\n" +
                        "}")
                .contentType(MediaType.APPLICATION_JSON);

        MockHttpServletResponse response = mmvc.perform(request).andReturn().getResponse();
        Assertions.assertEquals(412,response.getStatus());


    }
}

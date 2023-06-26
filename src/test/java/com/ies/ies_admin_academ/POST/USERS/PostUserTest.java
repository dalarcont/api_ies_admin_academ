package com.ies.ies_admin_academ.POST.USERS;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.ies.ies_admin_academ.config.Routes;
import com.ies.ies_admin_academ.model.entities.uf_user_profile;
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
                        "\"idPersona\":\"12345678901\",\n" +
                        "\"nombres\":\"Jesus Javier\",\n" +
                        "\"apellidos\":\"Alarcon Tabima\",\n" +
                        "\"username\":\"jalarcont\",\n" +
                        "\"genero\":\"M\",\n" +
                        "\"email_personal\":\"jalarcont@gmail.com\",\n" +
                        "\"email_laboral\":\"jalarcont@unifalsa.com\",\n" +
                        "\"origen_pais\":\"COL\",\n" +
                        "\"origen_ciudad\":\"Pacora\",\n" +
                        "\"reside_pais\":\"COL\",\n" +
                        "\"reside_ciudad\":\"Pereira\",\n" +
                        "\"escolaridad\":\"1\"\n" +
                        "}")
                .contentType(MediaType.APPLICATION_JSON);

        MockHttpServletResponse response = mmvc.perform(request).andReturn().getResponse();
        Assertions.assertEquals(200,response.getStatus());

        List<uf_user_profile> user = uRepo.getUserBasicData("jalarcont");
        Assertions.assertEquals(1, user.size());
        //Validation of password for new additions due to the business rule (See UserServiceGeneral method addUser notes)
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        boolean pkeyMatch = encoder.matches(user.get(0).getUsername()+user.get(0).getIdPersona()+"#",user.get(0).getPkeyusuario());
        Assertions.assertTrue(pkeyMatch);


    }

    @Test
    void ADD_USER_FAILS() throws Exception{
        //Just need to check if sending a username that already exists we expect a failure
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post(Routes.ROOT.USERS)
                .content("{\n" +
                        "\"idPersona\":\"12345678901\",\n" +
                        "\"nombres\":\"Jesus Javier\",\n" +
                        "\"apellidos\":\"Alarcon Tabima\",\n" +
                        "\"username\":\"janistabaress\",\n" +
                        "\"genero\":\"M\",\n" +
                        "\"email_personal\":\"jalarcont@gmail.com\",\n" +
                        "\"email_laboral\":\"jalarcont@unifalsa.com\",\n" +
                        "\"origen_pais\":\"COL\",\n" +
                        "\"origen_ciudad\":\"Pacora\",\n" +
                        "\"reside_pais\":\"COL\",\n" +
                        "\"reside_ciudad\":\"Pereira\",\n" +
                        "\"escolaridad\":\"1\"\n" +
                        "}")
                .contentType(MediaType.APPLICATION_JSON);

        MockHttpServletResponse response = mmvc.perform(request).andReturn().getResponse();
        Assertions.assertEquals(412,response.getStatus());


    }
}

package com.ies.ies_admin_academ.PUT.USERS;

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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class PutUserTest {

    @Autowired
    UserRepository uRepo;
    @Autowired
    private MockMvc mmvc;

    @Test
    void PUT_USER_WORKS() throws Exception{
        String toPut = "CHANGED";
        //In this test we sent another signup date and password, to validate if endpoint service ignore it.
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .put(Routes.ROOT.USERS+Routes.ROOT.BODY,"janistabaress")
                .content("{\n" +
                        "\"fechaRegistro\":\"8374692873924\",\n" +
                        "\"pkeyusuario\":\"contrasena\",\n" +
                        "\"idPersona\":\"42119715\",\n" +
                        "\"nombres\":\"Maria Janis\",\n" +
                        "\"apellidos\":\"Tabares Salgado"+toPut+"\",\n" +
                        "\"username\":\"janistabaress\",\n" +
                        "\"genero\":\"F\",\n" +
                        "\"email_personal\":\"janistabaress@gmail.com\",\n" +
                        "\"email_laboral\":\"janistabaress@unifalsa.com\",\n" +
                        "\"origen_pais\":\"COL\",\n" +
                        "\"origen_ciudad\":\""+toPut+"Pacora\",\n" +
                        "\"reside_pais\":\"COL\",\n" +
                        "\"reside_ciudad\":\""+toPut+"Pereira\",\n" +
                        "\"escolaridad\":\"ESC2\"\n" +
                        "}")
                .contentType(MediaType.APPLICATION_JSON);

        MockHttpServletResponse response = mmvc.perform(request).andReturn().getResponse();
        Assertions.assertEquals(200,response.getStatus());

        List<uf_user_profile> user = uRepo.getUserBasicData("janistabaress");
        Assertions.assertEquals(user.get(0).getApellidos(),"Tabares SalgadoCHANGED");
        Assertions.assertEquals(user.get(0).getOrigen_ciudad(),"CHANGEDPacora".toUpperCase());
        Assertions.assertEquals(user.get(0).getReside_ciudad(),"CHANGEDPereira".toUpperCase());
        //Testing business rule related to signup date and password
        Assertions.assertEquals("2016-08-01 18:30:00",user.get(0).getFechaRegistro());
        Assertions.assertNotEquals("anotherpassword",user.get(0).getPkeyusuario());
    }

    @Test
    void PUT_USER_FAILS() throws Exception{
        //Just send any username that doesn't exists
        String toPut = "meh";
        //In this test we sent another signup date and password, to validate if endpoint service ignore it.
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .put(Routes.ROOT.USERS+Routes.ROOT.BODY,"empanada")
                .content("{\n" +
                        "\"fechaRegistro\":\"8374692873924\",\n" +
                        "\"pkeyusuario\":\"contrasena\",\n" +
                        "\"idPersona\":\"42119715\",\n" +
                        "\"nombres\":\"Maria Janis\",\n" +
                        "\"apellidos\":\"Tabares Salgado"+toPut+"\",\n" +
                        "\"username\":\"janistabaress\",\n" +
                        "\"genero\":\"F\",\n" +
                        "\"email_personal\":\"janistabaress@gmail.com\",\n" +
                        "\"email_laboral\":\"janistabaress@unifalsa.com\",\n" +
                        "\"origen_pais\":\"COL\",\n" +
                        "\"origen_ciudad\":\""+toPut+"Pacora\",\n" +
                        "\"reside_pais\":\"COL\",\n" +
                        "\"reside_ciudad\":\""+toPut+"Pereira\",\n" +
                        "\"escolaridad\":\"ESC2\"\n" +
                        "}")
                .contentType(MediaType.APPLICATION_JSON);

        MockHttpServletResponse response = mmvc.perform(request).andReturn().getResponse();
        Assertions.assertEquals(412,response.getStatus());
    }
}

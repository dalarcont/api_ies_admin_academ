package com.ies.ies_admin_academ.PATCH;

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

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class PatchUserTest {
    @Autowired
    UserRepository uRepo;
    @Autowired
    private MockMvc mmvc;

    @Test
    void PARTIAL_UPDATE_WORKS() throws Exception{
        //User defined to do this test
        String userTest = "dalarcont";
        String toPatch = "new york";

        //In this test we sent another signup date and password, to validate if endpoint service ignore it.

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .patch(Routes.ROOT.USERS+Routes.ROOT.BODY,userTest)
                .content("[\n" +
                        "    {\"op\": \"replace\", \"path\":\"/fechaRegistro\", \"value\":\"2023-06-09 01:03:12\"},\n" +
                        "    {\"op\": \"replace\", \"path\":\"/reside_ciudad\", \"value\":\""+toPatch+"\"},\n" +
                        "    {\"op\": \"replace\", \"path\":\"/pkeyusuario\", \"value\":\"anotherpassword\"}\n" +
                        "]")
                .contentType(MediaType.APPLICATION_JSON);

        MockHttpServletResponse response = mmvc.perform(request).andReturn().getResponse();
        Assertions.assertEquals(200,response.getStatus());

        uf_user_profile user = uRepo.getUserBasicData(userTest).get(0);
        Assertions.assertEquals(toPatch.toUpperCase(), user.getReside_ciudad());
        //If endpoint service ignores successfully the signup date update request, we have to get the same signup date
        Assertions.assertEquals("2016-08-01 18:30:00",user.getFechaRegistro());
        Assertions.assertNotEquals("anotherpassword",user.getPkeyusuario());
    }

    @Test
    void PARTIAL_UPDATE_FAILS() throws Exception{
        //User defined to do this test
        //Just send any username that doesn't exists
        String userTest = "empanada";
        String toPatch = "new york";

        //In this test we sent another signup date and password, to validate if endpoint service ignore it.

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .patch(Routes.ROOT.USERS+Routes.ROOT.BODY,userTest)
                .content("[\n" +
                        "    {\"op\": \"replace\", \"path\":\"/fechaRegistro\", \"value\":\"2023-06-09 01:03:12\"},\n" +
                        "    {\"op\": \"replace\", \"path\":\"/reside_ciudad\", \"value\":\""+toPatch+"\"},\n" +
                        "    {\"op\": \"replace\", \"path\":\"/pkeyusuario\", \"value\":\"anotherpassword\"}\n" +
                        "]")
                .contentType(MediaType.APPLICATION_JSON);

        MockHttpServletResponse response = mmvc.perform(request).andReturn().getResponse();
        Assertions.assertEquals(412,response.getStatus());
    }

}

package com.ies.ies_admin_academ.PATCH;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ies.ies_admin_academ.config.Routes;
import com.ies.ies_admin_academ.model.entities.CustomErrorCodes;
import com.ies.ies_admin_academ.model.entities.uf_personas;
import com.ies.ies_admin_academ.repositories.UserRepository;
import com.ies.ies_admin_academ.services.UserService;
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
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class PatchUserTest {
    @Autowired
    UserRepository uRepo;
    @Autowired
    private MockMvc mmvc;

    @Autowired
    UserService userSrvc;
    @Autowired
    private ObjectMapper objMapper;

    @Test
    void SYSTEM_RECORDACCESS() throws Exception {
        String param = "ZGFsYXJjb250!RDRsYXJjb250";
        String param_decoded0 = "dalarcont";
        //Build request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .patch(Routes.ROOT.USERS+Routes.PATCH.USERS.SYSTEM_DESKAPP_RECORDACCESS,param).contentType(MediaType.APPLICATION_JSON);
        //Perform request and check asserts
        Date da = new Date();
        MockHttpServletResponse response = mmvc.perform(request).andReturn().getResponse();
        Assertions.assertEquals(200,response.getStatus());
        //Object for asserts
        boolean validation = objMapper.readValue(response.getContentAsString(),boolean.class);

        if(validation){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateCompare = sdf.format(da);

            Assertions.assertEquals(dateCompare,userSrvc.userGetEmployeeProfile(param_decoded0).get(0).getFEC_ULTIMO_ACCESO());
        }
    }

    @Test
    void SYSTEM_RECORDACCESS_FAILS() throws Exception {
        String param = "bm9leGlzdHM=!bm9leGlzdHM=";
        //Build request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .patch(Routes.ROOT.USERS+Routes.PATCH.USERS.SYSTEM_DESKAPP_RECORDACCESS,param).contentType(MediaType.APPLICATION_JSON);
        //Perform request and check asserts
        Date da = new Date();
        //Perform request and check asserts
        MockHttpServletResponse response = mmvc.perform(request).andReturn().getResponse();
        Assertions.assertEquals(412,response.getStatus());
        //Object for asserts
        CustomErrorCodes validation = objMapper.readValue(response.getContentAsString(),CustomErrorCodes.class);
        Assertions.assertEquals(4370001,validation.getCode());

    }

    @Test
    void STUDENT_RECORDACCESS() throws Exception {
        String param = "ZGFsYXJjb250!RDRsYXJjb250";
        String param_decoded0 = "dalarcont";
        //Build request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .patch(Routes.ROOT.USERS+Routes.PATCH.USERS.SYSTEM_STD_RECORDACCESS,param).contentType(MediaType.APPLICATION_JSON);
        //Perform request and check asserts
        Date da = new Date();
        MockHttpServletResponse response = mmvc.perform(request).andReturn().getResponse();
        Assertions.assertEquals(200,response.getStatus());
        //Object for asserts
        boolean validation = objMapper.readValue(response.getContentAsString(),boolean.class);

        if(validation){
            Assertions.assertEquals("2024-02-15 04:19:44",userSrvc.userGetEmployeeProfile(param_decoded0).get(0).getFEC_ULTIMO_ACCESO());
        }
    }

    @Test
    void STUDENT_RECORDACCESS_FAILS() throws Exception {
        String param = "bm9leGlzdHM=!bm9leGlzdHM=";
        //Build request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .patch(Routes.ROOT.USERS+Routes.PATCH.USERS.SYSTEM_STD_RECORDACCESS,param).contentType(MediaType.APPLICATION_JSON);
        //Perform request and check asserts
        Date da = new Date();
        //Perform request and check asserts
        MockHttpServletResponse response = mmvc.perform(request).andReturn().getResponse();
        Assertions.assertEquals(412,response.getStatus());
        //Object for asserts
        CustomErrorCodes validation = objMapper.readValue(response.getContentAsString(),CustomErrorCodes.class);
        Assertions.assertEquals(4370001,validation.getCode());

    }

    @Test
    void PARTIAL_UPDATE_WORKS() throws Exception{
        //User defined to do this test
        String userTest = "dalarcont";
        String toPatch = "new york";

        //In this test we sent another signup date and password, to validate if endpoint service ignore it.

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .patch(Routes.ROOT.USERS+Routes.ROOT.BODY,userTest)
                .content("[\n" +
                        "    {\"op\": \"replace\", \"path\":\"/prsn_FEC_REG\", \"value\":\"2023-06-09 01:03:12\"},\n" +
                        "    {\"op\": \"replace\", \"path\":\"/prsn_RESIDE_CIUDAD\", \"value\":\""+toPatch+"\"},\n" +
                        "    {\"op\": \"replace\", \"path\":\"/prsn_PKEY\", \"value\":\"anotherpassword\"}\n" +
                        "]")
                .contentType(MediaType.APPLICATION_JSON);

        MockHttpServletResponse response = mmvc.perform(request).andReturn().getResponse();
        Assertions.assertEquals(200,response.getStatus());

        uf_personas user = uRepo.getUserProfile(userTest).get(0);
        Assertions.assertEquals(toPatch.toUpperCase(), user.getPRSN_RESIDE_CIUDAD());
        //If endpoint service ignores successfully the signup date update request, we have to get the same signup date
        Assertions.assertEquals("2016-08-01 18:30:00",user.getPRSN_FEC_REG());
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        boolean pkeyMatch = encoder.matches("anotherpassword",user.getPRSN_PKEY());
        Assertions.assertNotEquals("anotherpassword",user.getPRSN_PKEY());
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

package com.ies.ies_admin_academ.GET.USERS;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ies.ies_admin_academ.config.Routes;
import com.ies.ies_admin_academ.model.entities.*;
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
import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public
class GetUserTest {

    @Autowired
    UserRepository userRepo;

    @Autowired
    UserService userSrvc;

    @Autowired
    private MockMvc mmvc;

    @Autowired
    private ObjectMapper objMapper;

    @Test
    void EXISTENCEPROOF_WORKS() throws Exception {
        String param = "dalarcont";
        //Build request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get(Routes.ROOT.USERS+Routes.GET.USERS.EXISTENCEPROOF,param).contentType(MediaType.APPLICATION_JSON);
        //Perform request and check asserts
        MockHttpServletResponse response = mmvc.perform(request).andReturn().getResponse();
        Assertions.assertEquals(200,response.getStatus());
        //Object for asserts
        boolean validation = objMapper.readValue(response.getContentAsString(),boolean.class);
        Assertions.assertTrue(validation);
    }

    @Test
    void EXISTENCEPROOF_FAILS() throws Exception {
        String param = "empanada";
        //Build request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get(Routes.ROOT.USERS+Routes.GET.USERS.EXISTENCEPROOF,param).contentType(MediaType.APPLICATION_JSON);
        //Perform request and check asserts
        MockHttpServletResponse response = mmvc.perform(request).andReturn().getResponse();
        Assertions.assertEquals(200,response.getStatus());
        boolean validation = objMapper.readValue(response.getContentAsString(),boolean.class);
        Assertions.assertFalse(validation);
    }

    @Test
    void GET_USER_PROFILE_OLDERS_WORKS() throws Exception {
        String param = "dalarcont";
        //Build request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get(Routes.ROOT.USERS+Routes.GET.USERS.GET_USER_PROFILE,param).contentType(MediaType.APPLICATION_JSON);
        //Perform request and check asserts
        MockHttpServletResponse response = mmvc.perform(request).andReturn().getResponse();
        Assertions.assertEquals(200,response.getStatus());
        //Object for asserts
        uf_personas validation = objMapper.readValue(response.getContentAsString(), uf_personas.class);
        //Object attributes/data assertions
        Assertions.assertEquals("2016-08-01 18:30:00",validation.getPRSN_FEC_REG());
        Assertions.assertEquals("1088333702",validation.getPRSN_ID());
        Assertions.assertEquals("DANIEL FERNANDO",validation.getPRSN_NOM().toUpperCase());
        Assertions.assertEquals("ALARCON TABARES",validation.getPRSN_APE().toUpperCase());
        Assertions.assertEquals("dalarcont",validation.getPRSN_USUARIO());
        Assertions.assertEquals("MS",validation.getPRSN_GEN());
        Assertions.assertEquals("daniel.alarcon@unifalsa.com",validation.getPRSN_EMAIL_LABORAL());
        Assertions.assertEquals("dfalarcont@gmail.com",validation.getPRSN_EMAIL_PERSONAL());
        Assertions.assertEquals("COL",validation.getPRSN_ORIGEN_PAIS());
        Assertions.assertEquals("PEREIRA",validation.getPRSN_ORIGEN_CIUDAD());
        Assertions.assertEquals("COL",validation.getPRSN_RESIDE_PAIS());
        Assertions.assertEquals("PEREIRA",validation.getPRSN_RESIDE_CIUDAD());
        Assertions.assertEquals("PROF",validation.getPRSN_ESCOLARIDAD());
        //Validation of password for older or password updated users...
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        boolean pkeyMatch = encoder.matches("contrasena",validation.getPRSN_PKEY());
        Assertions.assertTrue(pkeyMatch);
        //
        Assertions.assertEquals("4digit gato(1) and 4digit gato(2)",validation.getPRSN_RECOVERY_QUEST());
        Assertions.assertEquals("21032910",validation.getPRSN_RECOVERY_ANS());

    }

    @Test
    void GET_USER_PROFILE_OLDERS_FAILS() throws Exception {
        String param = "empanada";
        //Build request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get(Routes.ROOT.USERS+Routes.GET.USERS.GET_USER_PROFILE,param).contentType(MediaType.APPLICATION_JSON);
        //Perform request and check asserts
        MockHttpServletResponse response = mmvc.perform(request).andReturn().getResponse();
        Assertions.assertEquals(412,response.getStatus());
    }


    @Test
    /**
     * ATTENTION: In the following test, you should indicate in 'param' the same content as in the previous test
     * cuz' that test handle the father class of the following class used in the test, and isn't necessary to do asserts on father class attributes
     * just do the asserts on the child class attributes
     */
    void GET_EMPLOYEE_PROFILE_WORKS() throws Exception {
        String param = "dalarcont";
        //Build request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get(Routes.ROOT.USERS+Routes.GET.USERS.GET_EMPLOYEE_PROFILE,param).contentType(MediaType.APPLICATION_JSON);
        //Perform request and check asserts
        MockHttpServletResponse response = mmvc.perform(request).andReturn().getResponse();
        Assertions.assertEquals(200,response.getStatus());
        //Object for asserts
        uf_personas_empleado validation = objMapper.readValue(response.getContentAsString(), uf_personas_empleado.class);
        //Object attributes/data assertions
        // *** If you want to perform father class attributes you can copy the asserts of the previous test. ***
        Assertions.assertTrue(validation.isPERMISO_ACCESO());
        Assertions.assertEquals("POTUS",validation.getCOD_UNIDAD());
        Assertions.assertNull(null,validation.getCOD_AREA());
        Assertions.assertEquals("JEFE00",validation.getCOD_CARGO());
        Assertions.assertEquals("SNN",validation.getESTADO_DISCIPLINARIO());
        Assertions.assertEquals("AMT",validation.getCOD_TIPO_PERSONAL());

    }

    @Test
    void GET_EMPLOYEE_PROFILE_FAILS() throws Exception {
        //Send another user that doesn't have employee profile
        String param = "aalabone3h";
        //Build request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get(Routes.ROOT.USERS+Routes.GET.USERS.GET_EMPLOYEE_PROFILE,param).contentType(MediaType.APPLICATION_JSON);
        //Perform request and check asserts
        MockHttpServletResponse response = mmvc.perform(request).andReturn().getResponse();
        Assertions.assertEquals(412,response.getStatus());
        //Object for asserts
        CustomErrorCodes validation = (objMapper.readValue(response.getContentAsString(), CustomErrorCodes.class));
        Assertions.assertEquals(4370007,validation.getCode());

    }

    @Test
    /**
     * ATTENTION: In the following test, you should indicate in 'param' the same content as in the previous test
     * cuz' that test handle the father class of the following class used in the test, and isn't necessary to do asserts on father class attributes
     * just do the asserts on the child class attributes
     */
    void GET_STUDENT_PROFILE_WORKS() throws Exception {
        String param = "dalarcont";
        //Build request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get(Routes.ROOT.USERS+Routes.GET.USERS.GET_STUDENT_PROFILE,param).contentType(MediaType.APPLICATION_JSON);
        //Perform request and check asserts
        MockHttpServletResponse response = mmvc.perform(request).andReturn().getResponse();
        Assertions.assertEquals(200,response.getStatus());
        //Object for asserts
        uf_personas_estudiante validation = objMapper.readValue(response.getContentAsString(), uf_personas_estudiante.class);
        //Object attributes/data assertions
        // *** If you want to perform father class attributes you can copy the asserts of the previous test. ***
        Assertions.assertEquals("2016-08-01 18:30:00",validation.getPRSN_FEC_REG()); //User profile general attribute
        Assertions.assertEquals("2016-08-01 00:00:00",validation.getFEC_PRIMER_MATRICULA()); //Student profile attribute
        Assertions.assertEquals("NOR",validation.getESTADO_ACADEMICO_GENERAL());
        Assertions.assertEquals(8311,validation.getCOD_ULTIMO_PROGRAMA_MATRICULADO());
        Assertions.assertTrue(validation.isPERMISO_ACCESO());
        Assertions.assertEquals("2022-09-23 04:20:38",validation.getFEC_ULTIMO_ACCESO());

    }

    @Test
    /**
     * ATTENTION: In the following test, you should indicate in 'param' the same content as in the previous test
     * cuz' that test handle the father class of the following class used in the test, and isn't necessary to do asserts on father class attributes
     * just do the asserts on the child class attributes
     */
    void GET_STUDENT_PROFILE_FAILS() throws Exception {
        //Send another user that doesn't have employee profile
        String param = "aalabone3h";
        //Build request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get(Routes.ROOT.USERS+Routes.GET.USERS.GET_STUDENT_PROFILE,param).contentType(MediaType.APPLICATION_JSON);
        //Perform request and check asserts
        MockHttpServletResponse response = mmvc.perform(request).andReturn().getResponse();
        Assertions.assertEquals(412,response.getStatus());
        //Object for asserts
        CustomErrorCodes validation = (objMapper.readValue(response.getContentAsString(),CustomErrorCodes.class));
        Assertions.assertEquals(4370012,validation.getCode());
    }

    @Test
    void MATCH_LOGIN_WORKS() throws Exception {
        String param = "ZGFsYXJjb250!Y29udHJhc2VuYQ==";
        //Build request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get(Routes.ROOT.USERS+Routes.GET.USERS.MATCH_LOGIN,param).contentType(MediaType.APPLICATION_JSON);
        //Perform request and check asserts
        MockHttpServletResponse response = mmvc.perform(request).andReturn().getResponse();
        Assertions.assertEquals(200,response.getStatus());
        //Object for asserts
        boolean validation = objMapper.readValue(response.getContentAsString(),boolean.class);
        Assertions.assertTrue(validation);
    }

    @Test
    void MATCH_LOGIN_FAILS() throws Exception {
        String param = "ZGFsYXJjb250!RVJST1I=";
        //Build request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get(Routes.ROOT.USERS+Routes.GET.USERS.MATCH_LOGIN,param).contentType(MediaType.APPLICATION_JSON);
        //Perform request and check asserts
        MockHttpServletResponse response = mmvc.perform(request).andReturn().getResponse();
        Assertions.assertEquals(412,response.getStatus());
        //Object for asserts
        CustomErrorCodes validation = objMapper.readValue(response.getContentAsString(),CustomErrorCodes.class);
        Assertions.assertEquals(4370003,validation.getCode());
    }

    @Test
    void DESKAPP_ACCESS_WORKS() throws Exception {
        String param = "dalarcont";
        //Build request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get(Routes.ROOT.USERS+Routes.GET.USERS.DESKAPP_ACCESS,param).contentType(MediaType.APPLICATION_JSON);
        //Perform request and check asserts
        MockHttpServletResponse response = mmvc.perform(request).andReturn().getResponse();
        Assertions.assertEquals(200,response.getStatus());
        //Object for asserts
        boolean validation = objMapper.readValue(response.getContentAsString(),boolean.class);
        Assertions.assertTrue(validation);
    }

    @Test
    void DESKAPP_ACCESS_FAILS() throws Exception {
        String param = "aalabone3h";
        //Build request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get(Routes.ROOT.USERS+Routes.GET.USERS.DESKAPP_ACCESS,param).contentType(MediaType.APPLICATION_JSON);
        //Perform request and check asserts
        MockHttpServletResponse response = mmvc.perform(request).andReturn().getResponse();
        Assertions.assertEquals(412,response.getStatus());
        //Object for asserts
        CustomErrorCodes validation = objMapper.readValue(response.getContentAsString(),CustomErrorCodes.class);
        Assertions.assertEquals(4370005,validation.getCode());
    }

    @Test
    void STUDENT_ACCESS_WORKS() throws Exception {
        String param = "dalarcont";
        //Build request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get(Routes.ROOT.USERS+Routes.GET.USERS.STUDENT_ACCESS,param).contentType(MediaType.APPLICATION_JSON);
        //Perform request and check asserts
        MockHttpServletResponse response = mmvc.perform(request).andReturn().getResponse();
        Assertions.assertEquals(200,response.getStatus());
        //Object for asserts
        boolean validation = objMapper.readValue(response.getContentAsString(),boolean.class);
        Assertions.assertTrue(validation);
    }

    @Test
    void STUDENT_ACCESS_FAILS() throws Exception {
        String param = "aalabone3h";
        //Build request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get(Routes.ROOT.USERS+Routes.GET.USERS.STUDENT_ACCESS,param).contentType(MediaType.APPLICATION_JSON);
        //Perform request and check asserts
        MockHttpServletResponse response = mmvc.perform(request).andReturn().getResponse();
        Assertions.assertEquals(412,response.getStatus());
        //Object for asserts
        CustomErrorCodes validation = objMapper.readValue(response.getContentAsString(),CustomErrorCodes.class);
        Assertions.assertEquals(4370005,validation.getCode());
    }

    @Test
    void SYSINFO_PERMISSIONS_WORKS() throws Exception {
        String param = "ZGFsYXJjb250!RDRsYXJjb250";
        //Build request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get(Routes.ROOT.USERS+Routes.GET.USERS.SYSINFO_PERMISSIONS,param).contentType(MediaType.APPLICATION_JSON);
        //Perform request and check asserts
        MockHttpServletResponse response = mmvc.perform(request).andReturn().getResponse();
        //Encoding answer
        response.setCharacterEncoding("UTF-8");
        Assertions.assertEquals(200,response.getStatus());
        //Object for asserts app 1
        String app1_code = "DK_AKA/EST/HST";
        uf_sisinfo_AppsAndPermissions app1 = Arrays.stream((objMapper.readValue(response.getContentAsString(), uf_sisinfo_AppsAndPermissions[].class))).filter(x -> x.getAPP_CODE().equals(app1_code)).collect(Collectors.toList()).get(0);
        //Object for asserts app2
        String app2_code = "DK_AKA/MAT/EST";
        uf_sisinfo_AppsAndPermissions app2 = Arrays.stream((objMapper.readValue(response.getContentAsString(), uf_sisinfo_AppsAndPermissions[].class))).filter(x -> x.getAPP_CODE().equals(app2_code)).collect(Collectors.toList()).get(0);
        //Object attributes/data assertions
        Assertions.assertEquals("ajuste de matrícula estudiante",app2.getAPP_NAME().toLowerCase());
        Assertions.assertEquals("historial académico estudiante",app1.getAPP_NAME().toLowerCase());
        Assertions.assertEquals(2,app1.getAPP_TREE_LEVEL());
        Assertions.assertEquals(2,app2.getAPP_TREE_LEVEL());

    }

    @Test
    void SYSINFO_PERMISSIONS_FAILS() throws Exception {
        String param = "YWFsYWJvbmUzaA==!Y29udHJhc2VuYQ==";
        //Build request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get(Routes.ROOT.USERS+Routes.GET.USERS.SYSINFO_PERMISSIONS,param).contentType(MediaType.APPLICATION_JSON);
        //Perform request and check asserts
        MockHttpServletResponse response = mmvc.perform(request).andReturn().getResponse();
        Assertions.assertEquals(412,response.getStatus());
        //Object for asserts
        CustomErrorCodes validation = objMapper.readValue(response.getContentAsString(),CustomErrorCodes.class);
        Assertions.assertEquals(4370006,validation.getCode());

    }



}

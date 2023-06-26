package com.ies.ies_admin_academ.DELETE.USERS;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ies.ies_admin_academ.config.Routes;
import com.ies.ies_admin_academ.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.RouteMatcher;

import javax.transaction.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class DeleteUserTest {
    @Autowired
    UserRepository uRepo;
    @Autowired
    private MockMvc mmvc;

    @Autowired
    private ObjectMapper objMapper;

    @Test
    void DELETE_USER_WORKS() throws Exception{
        String usrDelete = "aalabone3h";

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .delete(Routes.ROOT.USERS+ Routes.ROOT.BODY,usrDelete);
        MockHttpServletResponse response = mmvc.perform(request).andReturn().getResponse();

        Assertions.assertEquals(200,response.getStatus());
        Assertions.assertTrue(objMapper.readValue(response.getContentAsString(),boolean.class));
    }

    @Test
    void DELETE_USER_FAILS() throws Exception{
        //Just send any username that doesn't exists
        String usrDelete = "empanada";

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .delete(Routes.ROOT.USERS+ Routes.ROOT.BODY,usrDelete);
        MockHttpServletResponse response = mmvc.perform(request).andReturn().getResponse();

        Assertions.assertEquals(412,response.getStatus());
    }
}

package com.ecastillo.taxi24.Controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest()
@AutoConfigureMockMvc
class PasajerosControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void RegistradosTest() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/pasajeros/near/77F");
        MvcResult mvcResult = mvc.perform(requestBuilder).andReturn();
        assertEquals(200,mvcResult.getResponse().getStatus());

    }

    @Test
    void PorID() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/pasajeros/77F");
        MvcResult mvcResult = mvc.perform(requestBuilder).andReturn();
        assertEquals(4096,mvcResult.getResponse().getBufferSize());

    }

}
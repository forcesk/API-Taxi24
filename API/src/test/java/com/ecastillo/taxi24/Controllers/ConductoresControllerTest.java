package com.ecastillo.taxi24.Controllers;

import com.ecastillo.taxi24.Services.ConductoresService;
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
class ConductoresControllerTest {

    @Autowired
    private MockMvc mvc;
    @Autowired
    ConductoresService conductoresService;

    @Test
    void RegistradosTest() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/conductores");
        MvcResult mvcResult = mvc.perform(requestBuilder).andReturn();
        assertEquals("application/json",mvcResult.getResponse().getContentType());
    }

    @Test
    void getDisponiblesTest() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/conductores/disponibles");
        MvcResult mvcResult = mvc.perform(requestBuilder).andReturn();
        assertNotEquals(null,mvcResult.getResponse().getContentType());
    }

}
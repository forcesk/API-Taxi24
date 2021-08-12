package com.ecastillo.taxi24.Controllers;

import com.ecastillo.taxi24.Services.FacturasService;
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
class FacturasControllerTest {

    @Autowired
    private MockMvc mvc;
    @Autowired
    FacturasService facturasService;

    @Test
    void getAllFacturasTest()  throws  Exception{
            RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/facturas");
            MvcResult mvcResult = mvc.perform(requestBuilder).andReturn();
            assertEquals("application/json",mvcResult.getResponse().getContentType());
        }
    }

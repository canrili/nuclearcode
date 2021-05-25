package com.dddinjava.portal.controller;

import com.dddinjava.portal.entity.Account;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.java.Log;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.HashMap;
import java.util.Map;

@Log
@SpringBootTest
@AutoConfigureMockMvc
class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    void list() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/account"))
                .andDo(MockMvcResultHandlers.log())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void save() throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        Account account = new Account("zhagnsan", "132", "zhagnsan");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/account")
                .contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(account)))
                .andDo(MockMvcResultHandlers.log())
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }
}
package ru.company.apiBilling.FNS.controllers;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.company.apiBilling.FNS.services.FnsService;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class FnsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Value("${accept.key}")
    private String acceptKey;


    @Test
    @DisplayName("Get company to INN")
    public void getCompanyByINNTest() throws Exception{

        mockMvc.perform(get("/api/fns/checkInn?key=" + acceptKey + "&inn=5405331680"))
                .andExpect(status().isOk())
                .andExpect(content().contentType( MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("Запрос по данному ИНН уже выполнен."))
                ;

    }

    @Test
    @DisplayName("Get Company INN error key")
    public void getCompanyByINNTestErrorKey() throws Exception{


        mockMvc.perform(get("/api/fns/checkInn?key=hf384923482rh8gfa84gr0w8rg3890gr29837rt7ryg287gr3y2gr9&inn=5405331680"))
                .andExpect(status().isOk())
                .andExpect(content().contentType( MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("Отказано в доступе!"));

    }


    @Test
    @DisplayName("Get Company INN error INN")
    public void getCompanyByINNTestErrorINN() throws Exception{


        mockMvc.perform(get("/api/fns/checkInn?key=" + acceptKey + "&inn=00000000003"))
                .andExpect(status().isOk())
                .andExpect(content().contentType( MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("Не верный ИНН."));

    }



    @Test
    @DisplayName("Get statistic")
    public void getStatTest() throws Exception{

        mockMvc.perform(get("/api/fns/stat?key=" + acceptKey ))
                .andExpect(status().isOk())
                .andExpect(content().contentType( MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.dateBegin").isNotEmpty());

    }

    @Test
    @DisplayName("Get statistic error key")
    public void getStatTestErrorKey() throws Exception{


        mockMvc.perform(get("/api/fns/stat?key=c982yrv9238uy3459023yhr89732ghr823gr832g"))
                .andExpect(status().isOk())
                .andExpect(content().contentType( MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("Отказано в доступе!"));

    }




}

package challenge.itau.me.controller;

import challenge.itau.me.dto.TransactionRequestDto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;
import java.time.OffsetDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
//@WebMvcTest({StatisticsController.class})
class StatisticsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TransactionController transactionController;

    @BeforeEach
    void setUp() {
        transactionController.clearTransactions();
        // transactionController.createTransaction(new TransactionRequestDto(132.0, OffsetDateTime.now())); Teste
        transactionController.createTransaction(new TransactionRequestDto(200.0, OffsetDateTime.now()));
        transactionController.createTransaction(new TransactionRequestDto(250.0, OffsetDateTime.now()));

    }

    @Test
    void GetCorrectStatistics01() throws Exception {
        mockMvc.perform(get("/estatistica")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.count").value(2))
                .andExpect(jsonPath("$.sum").value(450.0))
                .andExpect(jsonPath("$.avg").value(225.0))
                .andExpect(jsonPath("$.min").value(200.0))
                .andExpect(jsonPath("$.max").value(250.0));
    }

    @Test
    void GetCorrectStatisticsWithThreeTransactions() throws Exception {
        transactionController.clearTransactions();
        transactionController.createTransaction(new TransactionRequestDto(50.0, OffsetDateTime.now()));
        transactionController.createTransaction(new TransactionRequestDto(150.0, OffsetDateTime.now()));
        transactionController.createTransaction(new TransactionRequestDto(300.0, OffsetDateTime.now()));

        mockMvc.perform(get("/estatistica")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.count").value(3))
                .andExpect(jsonPath("$.sum").value(500.0))
                .andExpect(jsonPath("$.avg").value(166.66666666666666))
                .andExpect(jsonPath("$.min").value(50.0))
                .andExpect(jsonPath("$.max").value(300.0));
    }

    @Test
    void GetCorrectStatisticsWithTransactionsExceedingOneMinute() throws Exception {
        transactionController.clearTransactions();
        transactionController.createTransaction(new TransactionRequestDto(250.0, OffsetDateTime.now()));
        transactionController.createTransaction(new TransactionRequestDto(200.0, OffsetDateTime.now().minusSeconds(180)));

        mockMvc.perform(get("/estatistica")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.count").value(1))
                .andExpect(jsonPath("$.sum").value(250.0))
                .andExpect(jsonPath("$.avg").value(250.0))
                .andExpect(jsonPath("$.min").value(250.0))
                .andExpect(jsonPath("$.max").value(250.0));
    }
}
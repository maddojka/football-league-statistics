package com.soroko.footballleaguestatistics.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.soroko.footballleaguestatistics.dto.PlayerDTO;
import com.soroko.footballleaguestatistics.entity.PlayerStatistics;
import com.soroko.footballleaguestatistics.service.PlayerStatisticsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.UUID;


import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class PlayerStatisticsControllerTest {

    @Mock
    private PlayerStatisticsController controller;

    @InjectMocks
    private PlayerStatisticsService playerStatisticsService;

    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void CanGetAllPlayersStatisticsByPlayer() throws Exception {
        mockMvc.perform(get("/api/playerstat/all")).andExpect(status().isOk());
    }

    @Test
    void CanAddPlayerStatistics() throws Exception {
        PlayerDTO playerDTO = new PlayerDTO("Ivan", "Ivanov", "DEFENDER");
        PlayerStatistics playerStatistics =
                new PlayerStatistics(UUID.randomUUID(), 10, 5, 2,
                        1, 3, playerDTO);
        String playerStatJson = objectMapper.writeValueAsString(playerStatistics);
        mockMvc.perform(post("/api/playerstat/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(playerStatJson))
                .andExpect(status().isOk());
    }

}
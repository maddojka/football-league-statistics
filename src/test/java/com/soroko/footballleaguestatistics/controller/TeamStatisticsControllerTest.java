package com.soroko.footballleaguestatistics.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.soroko.footballleaguestatistics.dto.TeamDTO;
import com.soroko.footballleaguestatistics.entity.PlayerStatistics;
import com.soroko.footballleaguestatistics.entity.TeamStatistics;
import com.soroko.footballleaguestatistics.service.TeamStatisticsService;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class TeamStatisticsControllerTest {

    @Mock
    private TeamStatisticsController controller;

    @InjectMocks
    private TeamStatisticsService playerStatisticsService;

    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void CanGetAllTeamsStatisticsByPlayer() throws Exception {
        mockMvc.perform(get("/api/teamstat/all")).andExpect(status().isOk());
    }

    @Test
    void CanAddTeamStatistics() throws Exception {
        TeamDTO teamDTO = new TeamDTO("Zenit", "Saint-Petersburg", "Zenit Arena");
        TeamStatistics teamStatistics =
                new TeamStatistics(UUID.randomUUID(), "4", 5, 2,
                        1, 2, 10, 6, 4, 7, teamDTO);
        String teamStatJson = objectMapper.writeValueAsString(teamStatistics);
        mockMvc.perform(post("/api/teamstat/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(teamStatJson))
                .andExpect(status().isOk());
    }
}
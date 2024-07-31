package com.soroko.footballleaguestatistics.controller;


import com.soroko.footballleaguestatistics.service.PlayerStatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class PlayerStatisticsController {
    PlayerStatisticsService playerStatisticsService;

    public PlayerStatisticsController(PlayerStatisticsService playerStatisticsService) {
        this.playerStatisticsService = playerStatisticsService;
    }

    @GetMapping("/playerstat")
    public String teamstat(Model model) {
        return null;
    }
}

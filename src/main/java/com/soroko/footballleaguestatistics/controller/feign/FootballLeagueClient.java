package com.soroko.footballleaguestatistics.controller.feign;

import com.soroko.footballleaguestatistics.dto.PlayerDTO;
import com.soroko.footballleaguestatistics.dto.TeamDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "football-league", url = "http://localhost:8080/")
public interface FootballLeagueClient {

    @GetMapping("teamstats/{id}")
    TeamDTO getTeamDtoById(@RequestParam long id);

    @GetMapping("playerstats/{id}")
    PlayerDTO getPlayerDtoById(@RequestParam long id);

}

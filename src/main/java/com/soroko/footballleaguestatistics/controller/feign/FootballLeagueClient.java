package com.soroko.footballleaguestatistics.controller.feign;

import com.soroko.footballleaguestatistics.dto.PlayerDto;
import com.soroko.footballleaguestatistics.dto.TeamDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "football-league", url = "http://localhost:8080/")
public interface FootballLeagueClient {

    @GetMapping("teamstats/{id}")
    TeamDto getTeamDtoById(@RequestParam long id);

    @GetMapping("playerstats/{id}")
    PlayerDto getPlayerDtoById(@RequestParam long id);

}

package com.soroko.footballleaguestatistics.controller.feign;

import com.soroko.footballleaguestatistics.entity.PlayerDTO;
import com.soroko.footballleaguestatistics.entity.TeamDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "football-league", url = "http://localhost:8080/")
public interface FootballLeagueClient {

    @GetMapping
    TeamDTO getTeamById(@RequestParam("id") Integer id);

    @GetMapping
    PlayerDTO getPlayerById(@RequestParam("id") Integer id);

}

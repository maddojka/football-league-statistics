package com.soroko.footballleaguestatistics.controller.feign;

import com.soroko.footballleaguestatistics.entity.PlayerDTO;
import com.soroko.footballleaguestatistics.entity.TeamDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "football-league", url = "http://localhost:8080/")
public interface FootballLeagueClient {

    @GetMapping("teamDto/{id}")
    TeamDTO getTeamById(@PathVariable int id);

    @GetMapping("/playerDTO/{id}")
    PlayerDTO getPlayerById(@PathVariable int id);

}

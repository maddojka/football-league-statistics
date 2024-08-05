package com.soroko.footballleaguestatistics.repository;


import com.soroko.footballleaguestatistics.entity.TeamDTO;
import com.soroko.footballleaguestatistics.entity.TeamStatistics;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TeamStatisticsRepository extends MongoRepository<TeamStatistics, UUID> {

    TeamStatistics findByTeamDTO(TeamDTO teamDTO);
}

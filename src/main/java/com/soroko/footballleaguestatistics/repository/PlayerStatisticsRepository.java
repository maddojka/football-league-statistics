package com.soroko.footballleaguestatistics.repository;


import com.soroko.footballleaguestatistics.dto.PlayerDto;
import com.soroko.footballleaguestatistics.entity.PlayerStatistics;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PlayerStatisticsRepository extends MongoRepository<PlayerStatistics, UUID> {

    PlayerStatistics findByPlayer(PlayerDto playerDTO);
}

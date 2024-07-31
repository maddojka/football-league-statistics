package com.soroko.footballleaguestatistics.repository;


import com.soroko.footballleaguestatistics.entity.PlayerStatistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerStatisticsRepository extends JpaRepository<PlayerStatistics, Integer> {
}

package com.soroko.footballleaguestatistics.repository;


import com.soroko.footballleaguestatistics.entity.TeamStatistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamStatisticsRepository extends JpaRepository<TeamStatistics, Integer> {
}

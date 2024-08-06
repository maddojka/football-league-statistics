package com.soroko.footballleaguestatistics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EnableFeignClients
@EnableMongoRepositories
public class FootballLeagueStatisticsApplication {

    public static void main(String[] args) {
        SpringApplication.run(FootballLeagueStatisticsApplication.class, args);
    }

}

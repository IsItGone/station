package com.ddd.station.repository;

import com.ddd.station.Station;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface StationRepository extends ReactiveMongoRepository<Station, String>,
        StationTemplate {

}

package com.ddd.station.service;

import com.ddd.station.Station;
import com.ddd.station.model.StationCreate;
import com.ddd.station.model.StationUpdate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StationService {

	Mono<Station> getStationById(String id);

	Flux<Station> getStations();

	Mono<String> createStation(StationCreate stationCreate);

	Mono<Void> updateStation(StationUpdate stationUpdate);

	Mono<Void> deleteStationById(String id);
}

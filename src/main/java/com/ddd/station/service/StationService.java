package com.ddd.station.service;

import com.ddd.station.model.request.StationCreate;
import com.ddd.station.model.request.StationUpdate;
import com.ddd.station.model.response.StationResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StationService {

	Mono<StationResponse> getStationById(String id);

	Flux<StationResponse> getStations();

	Mono<String> createStation(StationCreate stationCreate);

	Mono<Void> updateStation(StationUpdate stationUpdate);

	Mono<Void> deleteStationById(String id);
}

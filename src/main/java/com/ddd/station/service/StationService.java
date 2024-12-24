package com.ddd.station.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StationService {

	Mono<Station> getStationById(String id);

	Flux<Station> getStations();

	Mono<Void> upsertStation(Station station);

	Mono<Void> deleteStationById(String id);
}

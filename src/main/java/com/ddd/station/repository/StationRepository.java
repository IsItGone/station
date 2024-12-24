package com.ddd.station.repository;

import com.ddd.station.service.Station;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StationRepository {

	Mono<Station> findById(String id);

	Flux<Station> findAll();

	Mono<Station> save(Station station);

	Mono<Void> deleteById(String id);
}

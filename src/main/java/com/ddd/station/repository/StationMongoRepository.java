package com.ddd.station.repository;

import com.ddd.station.model.StationMapper;
import com.ddd.station.service.Station;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Repository
public class StationMongoRepository implements StationRepository {

	private final StationReactiveMongoRepository reactiveMongoRepository;
	private final StationMapper stationMapper;

	@Override
	public Mono<Station> findById(String id) {
		return reactiveMongoRepository.findById(id).map(stationMapper::toStation);
	}

	@Override
	public Flux<Station> findAll() {
		return reactiveMongoRepository.findAll().map(stationMapper::toStation);
	}

	@Override
	public Mono<Station> save(Station station) {
		return reactiveMongoRepository.save(stationMapper.toStationDocument(station))
				.map(stationMapper::toStation);
	}

	@Override
	public Mono<Void> deleteById(String id) {
		return reactiveMongoRepository.deleteById(id);
	}

}

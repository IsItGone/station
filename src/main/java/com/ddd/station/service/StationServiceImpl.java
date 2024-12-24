package com.ddd.station.service;

import com.ddd.station.repository.StationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
@Slf4j
public class StationServiceImpl implements StationService {

	private final StationRepository stationRepository;

	@Override
	public Mono<Station> getStationById(String id) {
		return stationRepository.findById(id);
	}

	@Override
	public Flux<Station> getStations() {
		return stationRepository.findAll();
	}

	@Override
	public Mono<Void> upsertStation(Station station) {
		return stationRepository.save(station).then();
	}

	@Override
	public Mono<Void> deleteStationById(String id) {
		return stationRepository.deleteById(id);
	}
}

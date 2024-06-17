package com.ddd.station.service;

import com.ddd.station.Station;
import com.ddd.station.exception.StationNotFoundException;
import com.ddd.station.model.StationConverter;
import com.ddd.station.model.request.StationCreate;
import com.ddd.station.model.request.StationUpdate;
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
		return stationRepository.findById(id)
				.switchIfEmpty(Mono.error(StationNotFoundException::new));
	}

	@Override
	public Flux<Station> getStations() {
		return stationRepository.findAll();
	}

	@Override
	public Mono<String> createStation(StationCreate stationCreate) {
		return stationRepository.insert(StationConverter.toEntity(stationCreate))
				.flatMap(station -> Mono.just(station.getId()));
	}

	@Override
	public Mono<Void> updateStation(StationUpdate stationUpdate) {
		return stationRepository.findById(stationUpdate.id())
				.switchIfEmpty(Mono.error(StationNotFoundException::new))
				.flatMap(
						station -> stationRepository.save(StationConverter.toEntity(stationUpdate)))
				.then();
	}

	@Override
	public Mono<Void> deleteStationById(String id) {
		return stationRepository.deleteById(id);
	}
}

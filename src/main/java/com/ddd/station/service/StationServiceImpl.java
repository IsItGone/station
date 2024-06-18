package com.ddd.station.service;

import com.ddd.station.exception.StationNotFoundException;
import com.ddd.station.model.StationMapper;
import com.ddd.station.model.request.StationCreate;
import com.ddd.station.model.request.StationUpdate;
import com.ddd.station.model.response.StationResponse;
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
	private final StationMapper stationMapper;

	@Override
	public Mono<StationResponse> getStationById(String id) {
		return stationRepository.findById(id)
				.switchIfEmpty(Mono.error(StationNotFoundException::new))
				.map(stationMapper::toResponse);
	}

	@Override
	public Flux<StationResponse> getStations() {
		return stationRepository.findAll().map(stationMapper::toResponse);
	}

	@Override
	public Mono<String> createStation(StationCreate stationCreate) {
		return stationRepository.insert(stationMapper.toEntity(stationCreate))
				.flatMap(station -> Mono.just(station.getId()));
	}

	@Override
	public Mono<Void> updateStation(StationUpdate stationUpdate) {
		return stationRepository.findById(stationUpdate.id())
				.switchIfEmpty(Mono.error(StationNotFoundException::new)).flatMap(
						station -> stationRepository.save(stationMapper.toEntity(stationUpdate))
								.then());
	}

	@Override
	public Mono<Void> deleteStationById(String id) {
		return stationRepository.deleteById(id);
	}
}

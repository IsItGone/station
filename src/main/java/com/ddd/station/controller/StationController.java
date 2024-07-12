package com.ddd.station.controller;

import com.ddd.station.exception.StationNotFoundException;
import com.ddd.station.model.request.StationCreate;
import com.ddd.station.model.request.StationUpdate;
import com.ddd.station.model.response.StationResponse;
import com.ddd.station.service.StationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@Slf4j
public class StationController {

	private final StationService stationService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Mono<String> healthCheck() {
		return Mono.just("OK");
	}

	@GetMapping("/error")
	@ResponseStatus(HttpStatus.OK)
	public Mono<String> errorCheck() {
		return Mono.error(StationNotFoundException::new);
	}


	@GetMapping("/stations/{stationId}")
	@ResponseStatus(HttpStatus.OK)
	public Mono<StationResponse> getStation(@PathVariable String stationId) {
		return stationService.getStationById(stationId);
	}

	@GetMapping("/stations")
	@ResponseStatus(HttpStatus.OK)
	public Flux<StationResponse> getStations() {
		return stationService.getStations();
	}

	@PostMapping("/stations")
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<Void> createStation(@RequestBody StationCreate stationCreate) {
		return stationService.createStation(stationCreate).then();
	}

	@PutMapping("/stations")
	@ResponseStatus(HttpStatus.OK)
	public Mono<Void> updateStation(@RequestBody StationUpdate stationUpdate) {
		return stationService.updateStation(stationUpdate).then();
	}

	@DeleteMapping("/stations/{stationId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Mono<Void> deleteStation(@PathVariable String stationId) {
		return stationService.deleteStationById(stationId).then();
	}
}

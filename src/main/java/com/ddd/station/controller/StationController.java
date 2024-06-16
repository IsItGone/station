package com.ddd.station.controller;

import com.ddd.station.model.StationCreate;
import com.ddd.station.model.StationResponse;
import com.ddd.station.model.StationUpdate;
import com.ddd.station.service.StationService;
import com.ddd.station.util.Util;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@Slf4j
public class StationController {

    private final StationService stationService;

    @GetMapping
    public Mono<String> healthCheck() {
        return Mono.just("OK");
    }

    @GetMapping("/station/{stationId}")
    public Mono<StationResponse> getStation(@PathVariable String stationId) {
        return stationService.getStationById(stationId)
                .map(StationResponse::convert);
    }

    @GetMapping("/stations")
    public Flux<StationResponse> getStations() {
        return stationService.getStations()
                .map(StationResponse::convert);
    }

    @PostMapping("/station")
    public Mono<ResponseEntity<Void>> createStation(@RequestBody StationCreate stationCreate) {
        return stationService.createStation(stationCreate)
                .map(id -> ResponseEntity.created(Util.createURI(id)).build());
    }

    @PutMapping("/station")
    public Mono<ResponseEntity<Void>> updateStation(@RequestBody StationUpdate stationUpdate) {
        return stationService.updateStation(stationUpdate)
                .then(Mono.just(ResponseEntity.noContent().build()));
    }

    @DeleteMapping("/station/{stationId}")
    public Mono<ResponseEntity<Void>> deleteStation(@PathVariable String stationId) {
        return stationService.deleteStationById(stationId)
                .then(Mono.just(ResponseEntity.status(HttpStatus.NO_CONTENT).build()));
    }
}

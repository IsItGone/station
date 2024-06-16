package com.ddd.station.model;

import com.ddd.station.Station;

public record StationUpdate(String id, String name, String address, Double latitude,
                            Double longitude) {

    public Station convert() {
        return Station.builder()
                .id(id)
                .name(name)
                .address(address)
                .latitude(latitude)
                .longitude(longitude)
                .build();
    }
}

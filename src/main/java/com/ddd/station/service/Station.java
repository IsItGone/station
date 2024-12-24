package com.ddd.station.service;

import java.util.List;

public record Station(String id, String name, String description, String address, Double latitude,
					  Double longitude, Boolean isDeparture, List<String> routes) {

}

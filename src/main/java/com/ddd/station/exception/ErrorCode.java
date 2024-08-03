package com.ddd.station.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {
	STATION_NOT_FOUND("Station not found"),
	UNKNOWN_ERROR("Unknown error");

	private final String message;

}

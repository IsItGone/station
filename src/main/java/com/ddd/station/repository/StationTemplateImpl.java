package com.ddd.station.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class StationTemplateImpl implements StationTemplate {

    private final ReactiveMongoTemplate mongoTemplate;

}

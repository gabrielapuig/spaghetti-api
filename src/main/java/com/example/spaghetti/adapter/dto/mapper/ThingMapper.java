package com.example.spaghetti.adapter.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.example.spaghetti.domain.model.Thing;
import com.example.spaghetti.adapter.dto.request.ThingRequest;
import com.example.spaghetti.adapter.dto.response.ThingResponse;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ThingMapper {

    ThingMapper INSTANCE = Mappers.getMapper(ThingMapper.class);

    Thing toEntity(ThingRequest request);

    ThingResponse toResponse(Thing thing);

    List<ThingResponse> toResponseList(List<Thing> things);
}

package com.example.spaghetti.adapter.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.example.spaghetti.domain.model.Item;
import com.example.spaghetti.adapter.dto.request.ItemRequest;
import com.example.spaghetti.adapter.dto.response.ItemResponse;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    ItemMapper INSTANCE = Mappers.getMapper(ItemMapper.class);

    Item toEntity(ItemRequest request);

    ItemResponse toResponse(Item item);

    List<ItemResponse> toResponseList(List<Item> things);
}

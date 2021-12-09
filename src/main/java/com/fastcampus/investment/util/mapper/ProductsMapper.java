package com.fastcampus.investment.util.mapper;

import com.fastcampus.investment.component.dto.ProductsDTO;
import com.fastcampus.investment.component.entity.ProductsEntity;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public interface ProductsMapper {

    ProductsMapper INSTANCE = Mappers.getMapper(ProductsMapper.class);

    ProductsDTO toDto(ProductsEntity entity);

    ProductsEntity toEntity(ProductsDTO dto);

    List<ProductsDTO> toDtoList(List<ProductsEntity> entityList);

    List<ProductsEntity> toEntityList(List<ProductsDTO> dtoList);
}

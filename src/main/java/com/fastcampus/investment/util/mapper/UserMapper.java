package com.fastcampus.investment.util.mapper;

import com.fastcampus.investment.component.dto.UserDTO;
import com.fastcampus.investment.component.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO toDto(UserEntity entity);

    UserEntity toEntity(UserDTO dto);

    List<UserDTO> toDtoList(List<UserEntity> entityList);

    List<UserEntity> toEntityList(List<UserDTO> dtoList);
}

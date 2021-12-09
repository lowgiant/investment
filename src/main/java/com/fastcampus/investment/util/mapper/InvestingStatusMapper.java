package com.fastcampus.investment.util.mapper;

import com.fastcampus.investment.component.dto.InvestingStatusDTO;
import com.fastcampus.investment.component.entity.InvestingStatusEntity;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public interface InvestingStatusMapper {

    InvestingStatusMapper INSTANCE = Mappers.getMapper(InvestingStatusMapper.class);

    default InvestingStatusDTO toDto(InvestingStatusEntity entity){
        InvestingStatusDTO dto = new InvestingStatusDTO();
        dto.setId(entity.getUser().getId());
        InvestingStatusDTO.Product product = new InvestingStatusDTO.Product(
                entity.getProducts().getId()
               ,entity.getProducts().getTitle()
               ,entity.getProducts().getTotalInvestAmount()
        );
        dto.setProduct(product);
        dto.setInvestedAmount(entity.getUser().getInvestedAmount());
        dto.setStatus(entity.getUser().getStatus().name());
        dto.setInvestedAt(entity.getInvestedAt());
        return dto;
    }

    default List<InvestingStatusDTO> toDtoList(List<InvestingStatusEntity> entityList){
        List<InvestingStatusDTO> dtos = new ArrayList<>();
        for (InvestingStatusEntity entity : entityList){
            dtos.add(toDto(entity));
        }
        return dtos;
    }

}

package com.example.paysvc.mapper;

import com.example.paysvc.dto.Response.DebtResponse;
import com.example.paysvc.entity.DebtEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel  ="spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DebtMapper {

    DebtResponse modelToDTO(DebtEntity debtEntity);
    List<DebtResponse> modelsToDTOs(List<DebtEntity> debtEntities);
}

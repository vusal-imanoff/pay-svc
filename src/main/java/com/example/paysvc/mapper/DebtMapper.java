package com.example.paysvc.mapper;

import com.example.paysvc.dto.Response.DebtResponse;
import com.example.paysvc.entity.DebtEntity;
import org.mapstruct.Mapper;

import java.util.List;

import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(componentModel = "spring", unmappedTargetPolicy = IGNORE)
public interface DebtMapper {

    DebtResponse modelToDTO(DebtEntity debtEntity);

    List<DebtResponse> modelsToDTOs(List<DebtEntity> debtEntities);
}

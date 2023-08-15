package com.example.paysvc.mapper;

import com.example.paysvc.dto.Request.CreatePaymentRequest;
import com.example.paysvc.dto.Response.PaymentResponse;
import com.example.paysvc.entity.PaymentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel  ="spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PaymentMapper {

    PaymentResponse modelToDTO(PaymentEntity paymentEntity);
    List<PaymentResponse> modelsToDTOs(List<PaymentEntity> paymentEntities);
    PaymentEntity dtoToModel(CreatePaymentRequest paymentRequest);
}

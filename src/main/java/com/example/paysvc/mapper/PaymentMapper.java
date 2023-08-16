package com.example.paysvc.mapper;

import com.example.paysvc.model.request.CreatePaymentRequest;
import com.example.paysvc.model.response.PaymentResponse;
import com.example.paysvc.entity.PaymentEntity;
import org.mapstruct.Mapper;

import java.util.List;

import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(componentModel = "spring", unmappedTargetPolicy = IGNORE)
public interface PaymentMapper {

    PaymentResponse modelToDTO(PaymentEntity paymentEntity);

    List<PaymentResponse> modelsToDTOs(List<PaymentEntity> paymentEntities);

    PaymentEntity dtoToModel(CreatePaymentRequest paymentRequest);
}

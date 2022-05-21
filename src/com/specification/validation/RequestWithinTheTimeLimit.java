package com.specification.validation;

import com.specification.Shipment;
import com.specification.structure.CompositeSpecification;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class RequestWithinTheTimeLimit extends CompositeSpecification<Shipment> {

    private static final Integer TWO_WEEKS = 14;

    @Override
    public Boolean isSatisfiedBy(Shipment shipmentEntity) {
        return ChronoUnit.DAYS.between(shipmentEntity.getRequest(), LocalDateTime.now()) <= TWO_WEEKS;
    }
}

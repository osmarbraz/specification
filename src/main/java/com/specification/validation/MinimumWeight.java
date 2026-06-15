package com.specification.validation;

import com.specification.Shipment;
import com.specification.structure.CompositeSpecification;

public class MinimumWeight extends CompositeSpecification<Shipment> {

    private static final Long MINIMUM_WEIGHT = 10L;

    @Override
    public Boolean isSatisfiedBy(Shipment shipment) {
        return shipment.getWeight() >= MINIMUM_WEIGHT;
    }

}

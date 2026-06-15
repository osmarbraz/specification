package com.specification.validation;

import com.specification.Shipment;
import com.specification.structure.CompositeSpecification;

public class PackageMustHaveAtLeastItems extends CompositeSpecification<Shipment> {

    private Long total;

    public PackageMustHaveAtLeastItems(Long total) {
        this.total = total;
    }

    @Override
    public Boolean isSatisfiedBy(Shipment shipmentEntity) {
        return shipmentEntity.getQuantity() >= total;
    }
}

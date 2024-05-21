package com.mycompany.group234.function;

import com.mycompany.group234.model.ShipmentItem;
import com.mycompany.group234.model.OrderItem;
import com.mycompany.group234.model.Product;
import com.mycompany.group234.model.ProductType;
import com.mycompany.group234.model.Document;
import com.mycompany.group234.model.ProductOnBoarding;
import com.mycompany.group234.model.ProductPrice;
import com.mycompany.group234.model.OtherDetails;




import com.mycompany.group234.enums.Size;
import com.mycompany.group234.enums.OnBoardingStatus;
import com.mycompany.group234.enums.AvailabilityStatus;
import com.mycompany.group234.enums.Weight;
import com.mycompany.group234.converter.OnBoardingStatusConverter;
import com.mycompany.group234.converter.SizeConverter;
import com.mycompany.group234.converter.WeightConverter;
import com.mycompany.group234.converter.AvailabilityStatusConverter;
import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmAction;
import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmParameter;
import com.sap.olingo.jpa.metadata.core.edm.mapper.extension.ODataAction;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;

@Component
public class JavaActions implements ODataAction {
    private final EntityManager entityManager;

    public JavaActions(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

	
	
}
  
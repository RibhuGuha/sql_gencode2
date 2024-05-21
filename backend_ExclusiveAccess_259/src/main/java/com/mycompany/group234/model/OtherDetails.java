package com.mycompany.group234.model;


import lombok.Data;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


 
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
import com.mycompany.group234.converter.DurationConverter;
import com.mycompany.group234.converter.UUIDToByteConverter;
import com.mycompany.group234.converter.UUIDToStringConverter;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmFunction;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.time.Duration;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Lob;
import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmMediaStream;

@Entity(name = "OtherDetails")
@Table(name = "OtherDetails", schema =  "exclusiveaccess")
@Data
                        
public class OtherDetails {
	public OtherDetails () {   
  }
	  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "OtherDetailsId", nullable = true )
  private Integer otherDetailsId;
	  
  @Column(name = "ManufacturingDate", nullable = true )
  @Temporal(value = TemporalType.TIMESTAMP)
  private Date manufacturingDate;  
  
	  
  @Column(name = "AvailabilityStatus", nullable = true)
  @Enumerated(value = EnumType.ORDINAL)
  @Convert(converter = AvailabilityStatusConverter.class)
  private AvailabilityStatus availabilityStatus;
  
	  
  @Column(name = "Size", nullable = true )
  private Float size;
  
	  
  @Column(name = "UnitOfMeasurement", nullable = true)
  @Enumerated(value = EnumType.ORDINAL)
  @Convert(converter = SizeConverter.class)
  private Size unitOfMeasurement;
  
  
  
  
   
  
  
  
  
  
  
  
  
  
  @Override
  public String toString() {
	return "OtherDetails [" 
  + "OtherDetailsId= " + otherDetailsId  + ", " 
  + "ManufacturingDate= " + manufacturingDate  + ", " 
  + "AvailabilityStatus= " + availabilityStatus  + ", " 
  + "Size= " + size  + ", " 
  + "UnitOfMeasurement= " + unitOfMeasurement 
 + "]";
	}
	
}
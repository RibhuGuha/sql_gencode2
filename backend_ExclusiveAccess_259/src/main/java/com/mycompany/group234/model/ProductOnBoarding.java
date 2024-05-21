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

@Entity(name = "ProductOnBoarding")
@Table(name = "ProductOnBoarding", schema =  "exclusiveaccess")
@Data
                        
public class ProductOnBoarding {
	public ProductOnBoarding () {   
  }
	  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "PbId", nullable = true )
  private Integer pbId;
	  
  @Column(name = "Username", nullable = true )
  private String username;
  
	  
  @Column(name = "Name", nullable = true )
  private String name;
  
	  
  @Column(name = "Description", nullable = true )
  private String description;
  
	  
  @Column(name = "Status", nullable = true)
  @Enumerated(value = EnumType.ORDINAL)
  @Convert(converter = OnBoardingStatusConverter.class)
  private OnBoardingStatus status;
  
	  
  @Column(name = "LastStep", nullable = true )
  private Integer lastStep;
  
  
  
  
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ProductOnBoardingProduct", referencedColumnName = "Product_id", insertable = false, updatable = false)
	private Product product;
	
	@Column(name = "ProductOnBoardingProduct")
	private Integer productOnBoardingProduct;
   
  
  
  
  
  
  
  
  
  
  @Override
  public String toString() {
	return "ProductOnBoarding [" 
  + "PbId= " + pbId  + ", " 
  + "Username= " + username  + ", " 
  + "Name= " + name  + ", " 
  + "Description= " + description  + ", " 
  + "Status= " + status  + ", " 
  + "LastStep= " + lastStep 
 + "]";
	}
	
}
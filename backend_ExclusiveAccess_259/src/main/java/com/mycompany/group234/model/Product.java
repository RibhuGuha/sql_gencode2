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

@Entity(name = "Product")
@Table(name = "Product", schema =  "exclusiveaccess")
@Data
                        
public class Product {
	public Product () {   
  }
	  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "Product_id", nullable = true )
  private Integer product_id;
	  
  @Column(name = "Return_merchandise_authorization_nr", nullable = true )
  private String return_merchandise_authorization_nr;
  
	  
  @Column(name = "Name", nullable = true )
  private String name;
  
	  
  @Column(name = "Color", nullable = true )
  private String color;
  
	  
  @Column(name = "Size", nullable = true )
  private Integer size;
  
	  
  @Column(name = "Product_description", nullable = true )
  private String product_description;
  
	  
  @Column(name = "Manufacturer", nullable = true )
  private String manufacturer;
  
	  
  @Column(name = "Weight", nullable = true )
  private Float weight;
  
	  
  @Column(name = "UnitOfMeasurement", nullable = true)
  @Enumerated(value = EnumType.ORDINAL)
  @Convert(converter = WeightConverter.class)
  private Weight unitOfMeasurement;
  
  
  
  
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ProductProductType", referencedColumnName = "PtId", insertable = false, updatable = false)
	private ProductType productType;
	
	@Column(name = "ProductProductType")
	private Integer productProductType;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ProductOtherDetails", referencedColumnName = "OtherDetailsId", insertable = false, updatable = false)
	private OtherDetails otherDetails;
	
	@Column(name = "ProductOtherDetails")
	private Integer productOtherDetails;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ProductProductPrice", referencedColumnName = "PpId", insertable = false, updatable = false)
	private ProductPrice productPrice;
	
	@Column(name = "ProductProductPrice")
	private Integer productProductPrice;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ProductMainImage", referencedColumnName = "DocId", insertable = false, updatable = false)
	private Document mainImage;
	
	@Column(name = "ProductMainImage")
	private Integer productMainImage;
   
	
@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
@JoinTable(
            name="ProductOtherImages",
            joinColumns = @JoinColumn( name="Product_id"),
            inverseJoinColumns = @JoinColumn( name="DocId"), schema = "exclusiveaccess")
private List<Document> otherImages = new ArrayList<>();
  
  
  
  
  
  
  
  
  
  @Override
  public String toString() {
	return "Product [" 
  + "Product_id= " + product_id  + ", " 
  + "Return_merchandise_authorization_nr= " + return_merchandise_authorization_nr  + ", " 
  + "Name= " + name  + ", " 
  + "Color= " + color  + ", " 
  + "Size= " + size  + ", " 
  + "Product_description= " + product_description  + ", " 
  + "Manufacturer= " + manufacturer  + ", " 
  + "Weight= " + weight  + ", " 
  + "UnitOfMeasurement= " + unitOfMeasurement 
 + "]";
	}
	
}
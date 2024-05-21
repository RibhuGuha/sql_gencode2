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

@Entity(name = "OrderItem")
@Table(name = "OrderItem", schema =  "exclusiveaccess")
@Data
                        
public class OrderItem {
	public OrderItem () {   
  }
	  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "Order_item_id", nullable = true )
  private Integer order_item_id;
	  
  @Column(name = "Order_item_quantity", nullable = true )
  private Integer order_item_quantity;
  
	  
  @Column(name = "Order_item_price", nullable = true )
  private Double order_item_price;
  
	  
  @Column(name = "RMA_number", nullable = true )
  private Integer rMA_number;
  
	  
  @Column(name = "RMA_issued_by", nullable = true )
  private String rMA_issued_by;
  
	  
  @Column(name = "RMA_issued_date", nullable = true )
  @Temporal(value = TemporalType.TIMESTAMP)
  private Date rMA_issued_date;  
  
	  
  @Column(name = "Other_order_item_details", nullable = true )
  private String other_order_item_details;
  
	  
  @Column(name = "Order_item_status", nullable = true )
  private String order_item_status;
  
  
  
  
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "OrderItemProductOrder", referencedColumnName = "Product_id", insertable = false, updatable = false)
	private Product productOrder;
	
	@Column(name = "OrderItemProductOrder")
	private Integer orderItemProductOrder;
   
  
  
  
  
  
  
  
  
  
  @Override
  public String toString() {
	return "OrderItem [" 
  + "Order_item_id= " + order_item_id  + ", " 
  + "Order_item_quantity= " + order_item_quantity  + ", " 
  + "Order_item_price= " + order_item_price  + ", " 
  + "RMA_number= " + rMA_number  + ", " 
  + "RMA_issued_by= " + rMA_issued_by  + ", " 
  + "RMA_issued_date= " + rMA_issued_date  + ", " 
  + "Other_order_item_details= " + other_order_item_details  + ", " 
  + "Order_item_status= " + order_item_status 
 + "]";
	}
	
}
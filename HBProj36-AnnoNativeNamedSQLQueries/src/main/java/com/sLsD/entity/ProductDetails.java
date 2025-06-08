package com.sLsD.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NamedNativeQuery;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="tbl_product_details")
@NamedNativeQuery(name = "GET_PRODS_BY_PRICE_RANGE",query="SELECT * FROM TBL_PRODUCT_DETAILS WHERE PRICE BETWEEN ?1 AND ?2 ORDER BY PID")
@NamedNativeQuery(name = "HIKE_PRICE_BY_PROD_NAME",query="UPDATE TBL_PRODUCT_DETAILS SET PRICE=:p1 WHERE PNAME=:p2")
@NamedNativeQuery(name = "MAX_PRICE_PROD",query="SELECT MAX(PRICE) AS higest_price FROM TBL_PRODUCT_DETAILS")
@NamedNativeQuery(name = "AVG_PROD_PRICE",query="SELECT AVG(PRICE) AS average_price FROM TBL_PRODUCT_DETAILS")
public class ProductDetails {
	
	@GenericGenerator(name = "incr", strategy = "increment")
	@GeneratedValue(generator = "incr")
	@Column(name="PID")
	@NonNull
	@Id
	private Long pid;

	@NonNull
	@Column(name="PNAME")
	private String pname;
	
	@NonNull
	@Column(name="PRICE")
	private Double price;
	
	@NonNull
	@Column(name="QTY")
	private Double qty;
}

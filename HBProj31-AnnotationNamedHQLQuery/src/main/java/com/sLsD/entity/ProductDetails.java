package com.sLsD.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

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
//Place HQL/JPQL Queries as Named Query
@NamedQuery(name = "GET_PRODUCT_DETAILS_RECORDS",query = "FROM ProductDetails ORDER BY pname")
@NamedQuery(name = "UPDATE_PRODUCT_BY_ID",query = "UPDATE ProductDetails SET price = ?1 WHERE pid = ?2")
public class ProductDetails {
	
	@Id
	@GenericGenerator(name = "tbl_prod_details_seq",parameters = {@Parameter(name="initial_value",value = "3001"),
	                                                              @Parameter(name="increment_by",value="3")},
	                                                strategy = "sequence")
	@GeneratedValue(generator = "tbl_prod_details_seq")
	@Column(name="PID")
	@NonNull
	private Long pid;
	
	@Column(name="PNAME")
	@NonNull
	private String pname;
	
	@Column(name="PRICE")
	@NonNull
	private Double price;
	
	@Column(name="QTY")
	@NonNull
	private Double qty;
}

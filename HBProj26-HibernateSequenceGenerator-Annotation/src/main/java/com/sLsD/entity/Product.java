package com.sLsD.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//Entity/Model/Persistence/Domain Class
//Generator#1:: Hibernate Sequence Generator Configuration Using Annotation
@Setter
@Getter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name="PRODUCT")
public class Product implements Serializable {
	
	private static final long serialVersionUID = -3580554353916264518L;
	
	@Id
	/*@GenericGenerator(name = "hibernate_sequence",strategy = "sequence")//Case#1:: Using default sequence generator hibernate_sequence to generated Id Value.
	@GeneratedValue(generator = "hibernate_sequence")*/
	
	/*@GenericGenerator(name="seq",strategy="sequence",
	                  parameters ={@Parameter(name="sequence_name",value="hb_prod_sequence")})//Case#2:: Uses the Configured Sequence to generated Id Value.
	@GeneratedValue(generator = "seq")*/
	
	@GenericGenerator(name="seq",strategy="sequence",
    parameters ={@Parameter(name="sequence_name",value="anno_hb_prod_sequence"),
    		     @Parameter(name="initial_value",value="7001"),
    		     @Parameter(name="increment_size",value="2")})//Case#3:: Create a new Sequence based on the Sequence Related Input Values.
    @GeneratedValue(generator = "seq")
	@Column(name="PID",nullable = false)
	private Long pid;
	
	@NonNull
	@Column(name="PNAME",nullable = false)
	private String pname;
	
	@NonNull
	@Column(name="PRICE",nullable = false)
	private Double price;
	
	@NonNull
	@Column(name="QTY",nullable = false)
	private Double qty;
	
	public Product() {
		System.out.println("Zero Param Constructor:: "+this.hashCode());
	}

}

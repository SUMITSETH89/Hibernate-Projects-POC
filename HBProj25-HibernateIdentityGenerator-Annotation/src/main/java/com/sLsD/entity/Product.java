package com.sLsD.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//Entity/Model/Persistence/Domain Class
//Generator#1:: Hibernate increment Generator Configuration Using Annotation
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
	@GenericGenerator(name = "idty",strategy = "identity")
	@GeneratedValue(generator = "idty")
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

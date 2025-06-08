package com.sLsD.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;
import org.hibernate.annotations.Parameter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@SuppressWarnings("serial")
@Setter
@Getter
@AllArgsConstructor
@Entity
@Table(name="HB_ANNO_O2O_LIBRARY")
@DynamicInsert(value=true)
@DynamicUpdate(value=true)
public class LibraryMembership implements Serializable {
	
	@Id
	@GenericGenerator(name = "cg",strategy = "foreign",parameters = @Parameter(name="property",value = "studentDetails"))
	@GeneratedValue(generator = "cg")
	@Column(name="MID")
	@NonNull
	private Long membershipId;
	@Column(name="COLLEGE",length = 15,nullable = false)
	@NonNull
	private String college;
	@Column(name="VALIDITY",precision = 2,scale = 0,nullable = false)
	@NonNull
	private Integer validFor;
	@Column(name="DOJ",nullable = false)
	@NonNull
	private Date joiningDate;
	@OneToOne(targetEntity = Student.class,cascade = CascadeType.ALL,fetch=FetchType.EAGER,mappedBy = "libraryDetails")
	@LazyToOne(LazyToOneOption.PROXY)
	private Student studentDetails;
	
	public LibraryMembership() {
		System.out.println("Zero Param Constructor:: LibraryMembership");
	}
	
	@Override
	public String toString() {
		return String.format("MembershipId:: %d,College:: %s,Validity:: %d, JoiningDate:: %s",membershipId,college,validFor,joiningDate);
	}

}

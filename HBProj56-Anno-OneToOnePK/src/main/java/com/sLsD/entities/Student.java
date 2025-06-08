/**
 * 
 */
package com.sLsD.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@SuppressWarnings("serial")
@Setter
@Getter
@AllArgsConstructor
@Entity
@Table(name = "HB_ANNO_O2O_STUDENT")
@DynamicInsert(value=true)
@DynamicUpdate(value=true)
public class Student implements Serializable {
	
	@Id
	@SequenceGenerator(name="ps",sequenceName="HB_OTO_PK_SEQ",initialValue=100,allocationSize=2)
	@GeneratedValue(generator="ps",strategy=GenerationType.SEQUENCE)
	@Column(name="SNO")
	@NonNull
	private Long sno;
	
	@Column(name="SNAME",length = 15,nullable = false)
	@NonNull
	private String sname;
	
	@Column(name="COURSE",length = 20,nullable = false)
	@NonNull
	private String course;
	
	@Column(name="ADDRESS",length = 30,nullable = false)
	@NonNull
	private String saddr;
	
	@OneToOne(targetEntity = LibraryMembership.class,cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	@PrimaryKeyJoinColumn(name="MID",referencedColumnName = "SNO")//Here MID Refers to the Primary Key Column of LibraryMembership
	//@LazyToOne(LazyToOneOption.PROXY)Not Working				 //Which is also acting a Foreign Key Column.
	private LibraryMembership libraryDetails;
	
	public Student() {
		System.out.println("No Arg Constructor:: Student");
	}
	
	@Override
	public String toString() {
		return String.format("Sno:: %d,Sname:: %s,Course:: %s,Address:: %s",sno,sname,course,saddr);
	}

}

package com.sLsD.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Setter
@Getter
@AllArgsConstructor
@Entity
@Table(name = "OTM_UNI_ANNO_PERSON")
public class Person implements Serializable {
	
	@Id
	@SequenceGenerator(name = "my_seq",sequenceName = "HB_OTM_UNI_ANNO_PERSON_SEQ", allocationSize = 3,initialValue = 1000)
	@GeneratedValue(generator = "my_seq",strategy = GenerationType.SEQUENCE)
	@Column(name="PID")
	private Long pid;
	@Column(name="PNAME",length = 15,nullable = false)
	private String pname;
	@Column(name = "ADDRESS",length = 30,nullable = false)
	private String address;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,targetEntity = PhoneNumber.class,
			   orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.EXTRA)
	@JoinColumn(name = "PERSON_ID",referencedColumnName = "PID",foreignKey = @ForeignKey(name="FK_PERSONID_PHONE_NO"))
	private List<PhoneNumber> numList;
	
	
	public Person() {
		System.out.println("No Arg Constructor:: Person");
	}
	
	@Override
	public String toString() {
		return String.format("PID:: %d,PNAME:: %s,ADDRESS:: %s",pid,pname,address);
	}
	

}

package com.sLsD.entities;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ListIndexBase;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString
@Entity
@Table(name = "HB_ANNO_PER_DETAILS_COLLECTION")
public class Person {
	
	
	@Id
	@GenericGenerator(name="incr",strategy="increment")
	@GeneratedValue(generator="incr")
	@Column(name="PID")
	private Long pid;
	@NonNull
	@Column(name="PNAME",length = 30,nullable = false)
	private String pname;
	@NonNull
	@Column(name="ADDRESS",length = 50,nullable = false)
	private String address;
	
	@NonNull
	@ElementCollection
	@CollectionTable(name = "ANNO_HB_PER_NN_COLLECTION",
	                 joinColumns = @JoinColumn(name="PERSON_ID",referencedColumnName = "PID"))
	@OrderColumn(name = "IDX",updatable = false)
	@ListIndexBase(value = 1)
	@Column(name="NICK_NAME")
	private List<String> nickNames;
	
	@NonNull
	@ElementCollection
	@CollectionTable(name = "ANNO_HB_PER_FRIENDS_COLLECTION",
	                 joinColumns = @JoinColumn(name="PERSON_ID",referencedColumnName = "PID"))
	@Column(name="FRIEND",length = 20)
	private List<String> friends;
	@NonNull
	@ElementCollection
	@CollectionTable(name = "ANNO_HB_PER_CONTACT_COLLECTION",
	                 joinColumns = @JoinColumn(name="PERSON_ID",referencedColumnName = "PID"))
	@OrderColumn(name = "IDX",updatable = false)
	@Column(name="CONTACT")
	private Set<Long> contacts;
	@NonNull
	@ElementCollection
	@CollectionTable(name = "ANNO_HB_PER_ID_COLLECTION",
	                 joinColumns = @JoinColumn(name="PERSON_ID",referencedColumnName = "PID"))
	@MapKeyColumn(name="ID_TYPE",length = 10)
	@Column(name="ID_NO",length = 15 )
	private Map<String,Long>idDetails;
	
	public Person() {
		System.out.println("Zero Param Constructor:: Person");
	}

}

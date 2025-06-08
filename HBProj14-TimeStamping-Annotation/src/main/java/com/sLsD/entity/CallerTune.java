package com.sLsD.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

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
@Table(name = "caller_tune")
public class CallerTune {
	
	@Id
	@GenericGenerator(name="incr",strategy = "increment")
	@GeneratedValue(generator = "incr")
	@Column(name="tId")
	@NonNull
	private Long tuneId;
	
	@NonNull
	@Column(name="tName",length = 30,nullable = false)
	private String tuneName;
	
	@NonNull
	@Column(name="mName",length = 30,nullable = false)
	private String movieName;
	
	@NonNull
	@Column(name="count")
	@Version
	private Integer updationCount;
	
	@NonNull
	@Column(name="created_on")
	@CreationTimestamp()
	private Date createdOn;
	
	@NonNull
	@Column(name="updated_on")
	@UpdateTimestamp()
	private Date updatedOn;
	
	public CallerTune() {
		System.out.println("Zero Param Constructor::Caller Tune");
	}
	
	

}

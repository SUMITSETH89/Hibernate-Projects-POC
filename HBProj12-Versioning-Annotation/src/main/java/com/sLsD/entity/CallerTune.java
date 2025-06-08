package com.sLsD.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString
@Entity
@Table(name="caller_tune")
@DynamicInsert(value = true)
@DynamicUpdate(value = true)
public class CallerTune {
	
	@Id()
	@Column(name="tId")
	private Long tuneId;
	@Column(name="tName")
	private String tuneName;
	@Column(name = "mName")
	private String movieName;
	@Version
    @Column(name="count")
	private Integer updationCount;
	
	public CallerTune() {
		System.out.println("Zero Param Constructor::Caller Tune");
	}
	
	

}

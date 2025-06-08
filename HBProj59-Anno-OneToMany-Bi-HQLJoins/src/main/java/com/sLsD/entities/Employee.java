package com.sLsD.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString(exclude = "dept")
@Entity
@Table(name="ANNO_BI_EMPLOYEE")
public class Employee {
	
	@Id
	@SequenceGenerator(name="sc",sequenceName="BI_ANNO_EMP_SEQ",initialValue=200,allocationSize=2)
	@GeneratedValue(generator = "sc",strategy = GenerationType.SEQUENCE)
	@Column(name="EMP_ID")
	@NonNull
	private Long empId;
	@Column(name="ENAME",length = 30,nullable = false)
	@NonNull
	private String ename;
	@Column(name="DESIGNATION",length = 15,nullable = false)
	@NonNull
	private String designation;
	@Column(name="SAL",precision = 10,scale = 2)
	@NonNull
	private Double salary;
	@ManyToOne(targetEntity = Department.class,cascade = CascadeType.ALL,fetch=FetchType.EAGER)//For ManyToOne Association
	@JoinColumn(name="DEPT_ID",referencedColumnName = "DEPT_NO",foreignKey = @ForeignKey(name="FK_DEPT_EMP"))
	@LazyToOne(LazyToOneOption.PROXY)
	@NonNull
	private Department dept;
	
	public Employee() {
		System.out.println("No Args Constructor:: Employee");
	}

}

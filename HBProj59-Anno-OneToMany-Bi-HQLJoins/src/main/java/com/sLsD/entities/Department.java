package com.sLsD.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString(exclude = "employees")
@Entity
@Table(name = "ANNO_BI_DEPARTMENT")
@DynamicInsert(value = true)
@DynamicUpdate(value = true)
public final class Department{
	
	@Id
	@SequenceGenerator(name="sp",sequenceName="DEPT_BI_ANNO_SEQ",initialValue = 100,allocationSize = 1)
	@GeneratedValue(generator="sp",strategy=GenerationType.SEQUENCE)
	@Column(name="DEPT_NO")
	@NonNull
	private Long deptNo;
	@Column(name="DEPT_NAME",length = 15,nullable = false)
	@NonNull
	private String deptName;
	@Column(name="DEPT_HEAD",length = 15,nullable = false)
	@NonNull
	private String deptHead;
	@OneToMany(targetEntity = Employee.class,cascade = CascadeType.ALL,
			  fetch=FetchType.EAGER,mappedBy = "dept",orphanRemoval = true)//For OneToMany Association
	@LazyCollection(LazyCollectionOption.EXTRA)
	@NonNull
	private Set<Employee> employees;
	
	public Department() {
		System.out.println("No Arg Constructor:: Department");
	}

}

package com.sLsD.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.sLsD.entities.Doctor;
import com.sLsD.entities.Patient;
import com.sLsD.util.HibernateUtil;

public class HospitalDAOImpl implements IHospitalDAO {

	@Override
	public void saveDataByParent() {
		
		Transaction tx = null;
		try(Session sess = HibernateUtil.getSession()){
			
			//Doctor Object
			Doctor doctor1 = new Doctor();
			doctor1.setDocName("DR Major AK");
			doctor1.setSpecialization("General");
			doctor1.setHospital("Army");
			
			
			Doctor d2 = new Doctor();
			d2.setDocName("Dr Naresh");
			d2.setSpecialization("Othopaedics");
			d2.setHospital("SKMCH");
			
			Doctor d3 = new Doctor();
			d3.setDocName("Dr Mahendra");
			d3.setSpecialization("General");
			d3.setHospital("Kathi");
			
			//Patient Object
			Patient p1 = new Patient();
			p1.setPatientName("Sumit");
			p1.setAge(36);
			p1.setAilment("Stone");
			
			Patient p2 = new Patient();
			p2.setPatientName("Amit");
			p2.setAge(40);
			p2.setAilment("Heart");
			
			Patient p3 = new Patient();
			p3.setPatientName("Vivek");
			p3.setAge(35);
			p3.setAilment("Brain");
			
			//Assign Childs to Parents
			doctor1.setPatients(Set.of(p1,p3));//One Doctor Many Patients
			d2.setPatients(Set.of(p2,p3));
			d3.setPatients(Set.of(p1,p2,p3));
			//Assign Parent to Childs
			p1.setDoctors(Set.of(doctor1,d2));//One Patient is being treated by Many doctors
			p2.setDoctors(Set.of(d2,d3));
			p3.setDoctors(Set.of(doctor1,d3));
			
			//Begin Transaction
			tx = sess.beginTransaction();
			//Save Using Parent
			sess.save(doctor1);sess.save(d2);sess.save(d3);
			//Commit Transaction
			tx.commit();
			System.out.println("Object Saved Successfully");
			
		}catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) {
				System.out.println("Problem In Persisting Records By Parent");
				tx.rollback();
			}
		}
		
	}

	@Override
	public void saveDataByChild() {
		Transaction tx = null;
		try(Session sess = HibernateUtil.getSession()){
			//Doctor Object
			Doctor d1 = new Doctor();
			d1.setDocName("DR ABC");
			d1.setSpecialization("General");
			d1.setHospital("Applo");
			
			
			Doctor d2 = new Doctor();
			d2.setDocName("Dr Alok");
			d2.setSpecialization("Heart");
			d2.setHospital("Max");
			
			Doctor d3 = new Doctor();
			d3.setDocName("Dr Arun");
			d3.setSpecialization("Brain");
			d3.setHospital("Fortis");
			
			//Patient Object
			Patient p1 = new Patient();
			p1.setPatientName("Sumit");
			p1.setAge(36);
			p1.setAilment("Stone");
			
			Patient p2 = new Patient();
			p2.setPatientName("Amit");
			p2.setAge(40);
			p2.setAilment("Heart");
			
			//Assign Childs to Parents
			d1.setPatients(Set.of(p2));
			d2.setPatients(Set.of(p1,p2));
			d3.setPatients(Set.of(p1));
			//Assign Parent to Childs
			p1.setDoctors(Set.of(d1,d2,d3));
			p2.setDoctors(Set.of(d2,d3));
			
			//Begin Transaction
			tx = sess.beginTransaction();
			//Save Using Child
			sess.save(p1);sess.save(p1);
			//Commit Transaction
			tx.commit();
			System.out.println("Object Saved Successfully");
			
		}catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) {
				System.out.println("Problem In Persisting Records By Parent");
				tx.rollback();
			}
		}
		
		
	}

	@Override
	public void loadDataByParent() {
		try(Session sess = HibernateUtil.getSession()){
			
			//Create HQL Query Object
			Query<Doctor> query = sess.createQuery("FROM Doctor WHERE docId=:did ORDER BY docId",Doctor.class);
			//Set Parameter
			query.setParameter("did",118l);
			List<Doctor> docList = query.list();
			if(!docList.isEmpty()) {
				docList.forEach(doc->{
					System.out.println(doc);
				});
			}
			
		}catch(HibernateException he) {
			he.printStackTrace();
		}
		
	}

}

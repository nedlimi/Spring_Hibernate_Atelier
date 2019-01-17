/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.app.entitie.Etudiant;
import org.hibernate.HibernateException;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author nuguru
 */
@Transactional
@Repository("EtudiantDao")
public class EtudiantDaoImpl implements EtudiantDao {

    @Autowired
	private SessionFactory SessionFactory;
       
	Session session;
        
        @Transactional
	@Override
	public void add(Etudiant student) {
            session = SessionFactory.openSession();
            Transaction tx = null;
            String employeeID = null;
            try {
                tx = session.beginTransaction();
                employeeID = (String)session.save(student);
                tx.commit();
             } catch (HibernateException e) {
                if (tx!=null) tx.rollback();
                e.printStackTrace(); 
             } finally {
                session.close(); 
             }
	}

        @Transactional
	@Override
	public void edit(Etudiant student) {
           session = SessionFactory.openSession();
           Transaction tx = null;
           
        try {
         tx = session.beginTransaction();
         session.update(student);
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
	}

        @Transactional
	@Override
	public void delete(String studentId) {     
             session = SessionFactory.openSession();
             Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
         Etudiant employee = (Etudiant)session.get(Etudiant.class, studentId);
         session.delete(employee); 
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close();            
        }
        }

        @Transactional
	@Override
	public Etudiant getStudent(String studentId) {
            try {
            session = SessionFactory.getCurrentSession();
            return (Etudiant)session.get(Etudiant.class, studentId);
            } catch (HibernateException e) {
            session = SessionFactory.openSession();
            return (Etudiant)session.get(Etudiant.class, studentId);
            }
	}
        
        @Transactional
        @Override
	public Etudiant getStudentbyEmail(String email) {
            try {
            session = SessionFactory.openSession();
            session = SessionFactory.getCurrentSession();
           return (Etudiant) session.createQuery("select * from Etudiant where Email= "+email).list();
             
            } catch (HibernateException e) {
            
            return null;
            }
	}
        
        @Transactional
	@Override
	public List<Etudiant> getAllStudent() { 
            try {
            session = SessionFactory.getCurrentSession();
            return session.createQuery("from Etudiant").list();
            } catch (HibernateException e) {
            session = SessionFactory.openSession();
            return session.createQuery("from Etudiant").list();
            }
            
      } 
        public void init(){
		System.out.println("hibernate framework !! ");
	}

    public SessionFactory getFactory() {
        return SessionFactory;
    }
     
}

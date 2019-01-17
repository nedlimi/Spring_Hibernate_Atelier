/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.app.dao.EtudiantDao;
import com.app.entitie.Etudiant;

/**
 *
 * @author nuguru
 */
@Service("EtudiantService")
public class EtudiantServiceImp implements EtudiantService {
    
        @Autowired
	private EtudiantDao studentDao;
	
	@Transactional
        @Override
	public void add(Etudiant student) {
		studentDao.add(student);
	}

	@Transactional
        @Override
	public void edit(Etudiant student) {
		studentDao.edit(student);
	}
        
         @Transactional
        @Override
	public void delete(String studentId) {
		studentDao.delete(studentId);
	}

	@Transactional
        @Override
	public Etudiant getStudent(String studentId) {
		return studentDao.getStudent(studentId);
	}

    /**
     *
     * @return
     */
        @Transactional
        @Override
	public List<Etudiant> getAllStudent() {
		return studentDao.getAllStudent();
	}

        public void setStudentDao(EtudiantDao studentDao) {
            this.studentDao = studentDao;
        }
        
        public Etudiant getStudentbyEmail(String email){
           return this.studentDao.getStudentbyEmail(email);
        }

    
}

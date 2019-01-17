/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.service;
import java.util.List;
import com.app.entitie.Etudiant;

/**
 *
 * @author nuguru
 */
public interface EtudiantService {
    public void add(Etudiant student);
    public void edit(Etudiant student);
    public void delete(String studentId);
    public Etudiant getStudent(String studentId);
    public List<Etudiant> getAllStudent();
    public Etudiant getStudentbyEmail(String email);
}

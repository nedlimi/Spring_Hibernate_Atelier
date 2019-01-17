/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.entitie.Etudiant;
import com.app.service.EtudiantService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class EtudiantController {
    @Autowired
    public EtudiantService StudentRepository ;

    @RequestMapping("/")
    public String index() {
        return "Congratulations from BlogController.java";
    }

    
    @RequestMapping(value="/Etudiants", method=RequestMethod.GET, headers="Accept=application/json")
    public List<Etudiant> getEtudiants(){
        List<Etudiant> Books = StudentRepository.getAllStudent();
        return Books;
    }

    
    @RequestMapping(value = "/Etudiants/{id}",method = RequestMethod.GET,headers="Accept=application/json")
   public Etudiant getEtudiant(@PathVariable String id){
        Etudiant Books = StudentRepository.getStudent(id);
        return Books;
    }
   
   @RequestMapping(value = "/FindByEmail",method = RequestMethod.POST,headers="Accept=application/json")
   public Etudiant getEtudiantbyEmail(){
       //newStudent.getEmail()
        Etudiant Books = StudentRepository.getStudentbyEmail("testeu");
        return Books;
    }
   
   @RequestMapping(value = "/Etudiants",method = RequestMethod.PUT)
    public Etudiant newStudent(@RequestBody Etudiant newStudent)
    {
      
        StudentRepository.add(newStudent);
        return newStudent;
    }


    @RequestMapping(value = "/Etudiants/{id}",method = RequestMethod.PUT)
    public Etudiant updateEtudiant(@PathVariable String id){
        Etudiant newStudent = new Etudiant();
        newStudent.setId(id);
        newStudent.setEmail("testeu");
        newStudent.setFamilyName("ed");
        newStudent.setName("nada");
        Etudiant old = StudentRepository.getStudent(id);
        old.setEmail(newStudent.getEmail());
        old.setFamilyName(newStudent.getFamilyName());
        old.setName(newStudent.getName());
        StudentRepository.edit(old);
        return old;
    }

    
    @RequestMapping(value = "/Etudiants/{id}",method = RequestMethod.DELETE)
    public boolean deleteStudent(@PathVariable String id) {
        StudentRepository.delete(id);
        return true;
    }

}

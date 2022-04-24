package com.example.studentsystem.service;


import com.example.studentsystem.model.Student;
import com.example.studentsystem.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public Student getStudent(int id) {
        return studentRepository.findById(id).orElse(null);
    }
    public Student addStudent(Student newStudent){
        try{
            return studentRepository.save(newStudent);
        }
        catch(Exception ex){
            return null;
        }
    }

    public Boolean deleteStudent(int id){
        try{
            var student= getStudent(id);
            studentRepository.delete(student);
            return true;
        }
        catch(Exception ex){
            return null;
        }
    }
    
    public Student updateStudent(Student newStudent, int id){
        try{
            var studentToUpdated=getStudent(id);
            studentToUpdated.setFullName(newStudent.getFullName());
            studentToUpdated.setEmail(newStudent.getEmail());
            studentToUpdated.setLectures(newStudent.getLectures());
            return studentRepository.save(studentToUpdated);

        }
        catch(Exception ex){
            return null;
        }
    }

    public List<Student> getStudentList(){
        var list=studentRepository.findAll();
        List<Student> studentList= new ArrayList<>();
        for(var ob:list){
            studentList.add(ob);
        }
        if(studentList.size()>0){
            return studentList;
        }
        else
            return null;
    }


}

package com.example.studentsystem.REST;

import com.example.studentsystem.model.Answer;
import com.example.studentsystem.model.Student;
import com.example.studentsystem.service.StudentLectureImplService;
import com.example.studentsystem.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@CrossOrigin
public class StudentREST {
    private StudentService studentService;
    private StudentLectureImplService studentLectureImplService;

    public StudentREST(StudentService studentService, StudentLectureImplService studentLectureImplService) {
        this.studentService = studentService;
        this.studentLectureImplService = studentLectureImplService;
    }
    @GetMapping("/")
    Answer<List<Student>> getStudentList(){
        List<Student> answer=studentService.getStudentList();
        if(answer!=null)
            return new Answer<>(true,"",answer);
        else
            return new Answer<>(false,"can't get student list",answer);
    }

    @GetMapping("/{id}")
    Answer<Student> getStudent(@PathVariable int id){
        Student answer= studentService.getStudent(id);
        if(answer!=null)
            return new Answer<>(true,"",answer);
        else
            return new Answer<>(false,"can't get student by id ",null);
    }

    @PostMapping("/")
    Answer<Student> addStudent(@RequestBody Student newStudent){
        Student answer= studentService.addStudent(newStudent);
        if(answer!=null)
            return new Answer<>(true,"",answer);
        else
            return new Answer<>(false,"can't add student ",answer);
    }

    @PutMapping("/{id}")
    Answer<Student> updateStudent(@PathVariable int id, @RequestBody Student newStudent){
        Student answer=studentService.updateStudent(newStudent,id);
        if(answer!=null)
            return new Answer<>(true,"",answer);
        else
            return new Answer<>(false,"can't update student ",answer);
    }

    @DeleteMapping("/{id}")
    Answer<Boolean> deleteStudent(@PathVariable int id){
        Boolean answer=studentService.deleteStudent(id);
        if(answer)
            return new Answer<>(true,"",answer);
        else
            return new Answer<>(false,"can't delete student ",answer);
    }


    @PostMapping("/{studentId}/lectures/{lectureId}")
    Answer<Student> addLectureToStudent(@PathVariable int studentId,@PathVariable int lectureId){
       var answer=studentLectureImplService.addLectureToStudent(studentId,lectureId);
        if(answer!=null)
            return new Answer<>(true,"",answer);
        else
            return new Answer<>(false,"can't add lecture to student ",answer);
    }




}

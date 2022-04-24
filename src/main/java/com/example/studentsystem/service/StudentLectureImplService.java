package com.example.studentsystem.service;

import com.example.studentsystem.model.Student;
import com.example.studentsystem.repository.LectureRepository;
import com.example.studentsystem.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentLectureImplService {
    private StudentRepository studentRepository;
    private LectureRepository lectureRepository;

    public StudentLectureImplService(StudentRepository studentRepository, LectureRepository lectureRepository) {
        this.studentRepository = studentRepository;
        this.lectureRepository = lectureRepository;
    }

    public Student addLectureToStudent(int studentId, int lectureId){
        var student=studentRepository.findById(studentId).orElse(null);
        if(student!=null) {
            var lecture = lectureRepository.findById(lectureId).orElse(null);
            if (lecture != null) {
                if (student.getLectures() == null)
                    student.setLectures(new ArrayList<>());
                student.addLecture(lecture);
                var ans = studentRepository.save(student);
                return ans;
            }
            return null;
        }
        return null;
    }
}

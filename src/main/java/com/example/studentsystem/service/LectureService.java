package com.example.studentsystem.service;

import com.example.studentsystem.model.Lecture;
import com.example.studentsystem.repository.LectureRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LectureService {
    private LectureRepository lectureRepository;

    public LectureService(LectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }
    public Lecture getLecture(int id) {
        return lectureRepository.findById(id).orElse(null);
    }
    public Lecture addLecture(Lecture newLecture){
        try{
            return lectureRepository.save(newLecture);
        }
        catch(Exception ex){
            return null;
        }
    }

    public Boolean deleteLecture(int id){
        try{
            var lecture= getLecture(id);
            lectureRepository.delete(lecture);
            return true;
        }
        catch(Exception ex){
            return null;
        }
    }

    public Lecture updateLecture(Lecture newLecture, int id){
        try{
            var lectureToUpdated=getLecture(id);
            lectureToUpdated.setLectureName(newLecture.getLectureName());
            lectureToUpdated.setStudents(newLecture.getStudents());
            return lectureRepository.save(lectureToUpdated);

        }
        catch(Exception ex){
            return null;
        }
    }

    public List<Lecture> getLectureList(){
        var list=lectureRepository.findAll();
        List<Lecture> lectureList= new ArrayList<>();
        for(var ob:list){
            lectureList.add(ob);
        }
        if(lectureList.size()>0){
            return lectureList;
        }
        else
            return null;
    }


}

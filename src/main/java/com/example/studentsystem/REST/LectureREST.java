package com.example.studentsystem.REST;


import com.example.studentsystem.model.Answer;
import com.example.studentsystem.model.Lecture;
import com.example.studentsystem.service.LectureService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lectures")
public class LectureREST {
    public LectureService lectureService;

    @GetMapping("/")
    Answer<List<Lecture>> getLectureList(){
        List<Lecture> answer=lectureService.getLectureList();
        if(answer!=null)
            return new Answer<>(true,"",answer);
        else
            return new Answer<>(false,"can't get lecture list",answer);
    }

    @GetMapping("/{id}")
    Answer<Lecture> getLecturebyId(@PathVariable int id){
        Lecture answer=lectureService.getLecture(id);
        if(answer!=null)
            return new Answer<>(true,"",answer);
        else
            return new Answer<>(false,"can't get lecture by id",answer);
    }

    @PostMapping("/")
    Answer<Lecture> addLecture(@RequestBody Lecture newLecture){
        Lecture answer=lectureService.addLecture(newLecture);
        if(answer!=null)
            return new Answer<>(true,"",answer);
        else
            return new Answer<>(false,"can't add lecture",answer);
    }

    @DeleteMapping("/{id}")
    Answer<Boolean> deleteLecture(@PathVariable int id){
        Boolean answer=lectureService.deleteLecture(id);
        if(answer!=false)
            return new Answer<>(true,"",answer);
        else
            return new Answer<>(false,"can't delete lecture",answer);
    }

    @PutMapping("/{id}")
    Answer<Lecture> updateLecture(@RequestBody Lecture newLecture,@PathVariable int id){
        Lecture answer=lectureService.updateLecture(newLecture,id);
        if(answer!=null)
            return new Answer<>(true,"",answer);
        else
            return new Answer<>(false,"can't update lecture",answer);
    }
}

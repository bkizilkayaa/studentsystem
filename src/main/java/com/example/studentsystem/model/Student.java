package com.example.studentsystem.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="student")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="fullname")
    private String fullName;
    @Column(name = "email")
    private String email;

    @ManyToMany
    @JsonManagedReference
    /*@JoinTable(name="lecture_students",joinColumns = @JoinColumn(name="lectures_id"),
            inverseJoinColumns = @JoinColumn(name="students_id"))*/
    List<Lecture> lectures;

    public void addLecture(Lecture lecture) {
        lectures.add(lecture);
    }
}

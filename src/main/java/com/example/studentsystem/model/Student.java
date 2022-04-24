package com.example.studentsystem.model;

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

    @ManyToMany(mappedBy = "students")
    List<Lecture> lectures;

    public void addLecture(Lecture lecture) {
        lectures.add(lecture);
    }
}

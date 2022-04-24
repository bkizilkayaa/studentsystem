package com.example.studentsystem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="lecture")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="lecture_name")
    private String lectureName;

    @ManyToMany
    List<Student> students;
}

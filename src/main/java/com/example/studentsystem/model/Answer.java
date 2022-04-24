package com.example.studentsystem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Answer <E>{
    private Boolean isItsuccessfull;
    private String errorMsg;
    E answer;

}

package com.mkappworks.springreactivedemojavaapp.student;

import lombok.Data;

@Data
public class StudentRequest {
    private String firstname;
    private String lastname;
    private int age;
}
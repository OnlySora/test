package com.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String name;
    private String qq;
    private String type;
    private Date adminTime;
    private String school;
    private int sno;
    private String dayLink;
    private String willing;
    private String senior;
    private String source;
}

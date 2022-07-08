package com.example.demo.starwars.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class HomeworldDto {

    private String name;
    private String rotation_period;
    private String orbital_period;
    private String diameter;
    private String climate;
    private String gravity;
    private String terrain;
    private String surface_water;
    private String population;
    private List<String> residents;
    private List<String> films;
    private Timestamp created;
    private Timestamp edited;
    private String url;
}

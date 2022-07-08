package com.example.demo.starwars.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Homeworld {

    private String name;
    private String diameter;
    private String population;
}

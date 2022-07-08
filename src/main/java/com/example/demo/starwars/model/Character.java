package com.example.demo.starwars.model;

import lombok.Builder;
import lombok.Data;
import java.util.List;


@Data
@Builder
public class Character {

    private long id;
    private String name;
    private String height;
    private String hairColor;
    private Homeworld homeworld;
    private List<Starship> starships;


}

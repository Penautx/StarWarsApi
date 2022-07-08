package com.example.demo.starwars.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Starship {

    private String name;
    private String model;
    private String costInCredits;
    private String length;
    private String maxAtmosphericSpeed;
    private String crew;
    private String starshipClass;
}

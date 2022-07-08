package com.example.demo.starwars.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
public class Characters {

    private int count;
    private int pages;
    private List<Character> elements;
}

package com.example.demo.starwars.dto;

import lombok.Data;

import java.util.List;

@Data
public class CharactersDto {
    private int count;
    private String next;
    private String previous;
    private List<CharacterDto> results;

}

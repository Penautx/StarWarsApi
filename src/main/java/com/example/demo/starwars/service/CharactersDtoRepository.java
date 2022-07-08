package com.example.demo.starwars.service;
import com.example.demo.starwars.dto.CharacterDto;
import com.example.demo.starwars.dto.CharactersDto;

public interface CharactersDtoRepository {

    CharactersDto findByPage(Integer page);

    CharacterDto findById(long id);

}

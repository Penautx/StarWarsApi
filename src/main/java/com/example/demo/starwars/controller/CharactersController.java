package com.example.demo.starwars.controller;
import com.example.demo.starwars.model.Character;
import com.example.demo.starwars.model.Characters;
import com.example.demo.starwars.service.CharactersMapService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/characters")
public class CharactersController {

    private CharactersMapService charactersMapService;

    public CharactersController(CharactersMapService charactersMapService) {
        this.charactersMapService = charactersMapService;
    }

    @GetMapping
    public Characters getCharacters(@RequestParam(required = false) Integer page) {
        return charactersMapService.mapCharactersFromDto(page);
    }
    @GetMapping("/{id}")
    public Character getCharacter(@PathVariable long id){
    return charactersMapService.mapCharacterFromDto(id);
    }
}
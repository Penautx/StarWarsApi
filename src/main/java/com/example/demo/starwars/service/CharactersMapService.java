package com.example.demo.starwars.service;
import com.example.demo.starwars.dto.CharacterDto;
import com.example.demo.starwars.dto.CharactersDto;
import com.example.demo.starwars.dto.HomeworldDto;
import com.example.demo.starwars.dto.StarshipDto;
import com.example.demo.starwars.model.Character;
import com.example.demo.starwars.model.Characters;
import com.example.demo.starwars.model.Homeworld;
import com.example.demo.starwars.model.Starship;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class CharactersMapService {
    private final CharactersDtoDataRepository dataRepository;
    private final PagingService characterPagingService;

    public CharactersMapService(CharactersDtoDataRepository swapiDataRepository,
                                PagingService charactersPagingService ) {
        this.dataRepository = swapiDataRepository;
        this.characterPagingService = charactersPagingService;
    }

    public Characters mapCharactersFromDto(Integer page) {

        CharactersDto charactersDto = dataRepository.findByPage(page);
            return Characters.builder()
                    .count(charactersDto.getCount())
                    .pages(characterPagingService.calculateAmountOfPages(charactersDto.getCount()))
                    .elements(mapListOfCharacterFromDto(charactersDto.getResults()))
                    .build();
    }


    public Character mapCharacterFromDto(long id) {

        CharacterDto characterDto = dataRepository.findById(id);
        return Character.builder()
               .id(id)
               .name(characterDto.getName())
               .height(characterDto.getHeight())
               .hairColor(characterDto.getHair_color())
               .homeworld(mapHomeworldFromDto(characterDto.getHomeworld()))
               .starships(mapStarshipsFromDto(characterDto.getStarships()))
               .build();
    }
    private List<Character> mapListOfCharacterFromDto (List<CharacterDto> characterDtos){

        List<Character> characterList = new ArrayList<>();
        for (CharacterDto c: characterDtos) {
            Character character = Character.builder()
                    .id(characterDtos.indexOf(c) + 1)
                    .name(c.getName())
                    .height(c.getHeight())
                    .hairColor(c.getHair_color())
                    .homeworld(mapHomeworldFromDto(c.getHomeworld()))
                    .starships(mapStarshipsFromDto(c.getStarships()))
                    .build();
            characterList.add(character);

        }
        return characterList;
    }

    private Homeworld mapHomeworldFromDto (String homeworldDtoUrl) {

        HomeworldDto homeworldDto = dataRepository.getHomeworldDto(homeworldDtoUrl);
        return Homeworld.builder()
                .name(homeworldDto.getName())
                .diameter(homeworldDto.getDiameter())
                .population(homeworldDto.getPopulation())
                .build();
    }
    private List<Starship> mapStarshipsFromDto (List<String> starshipDtoUrls) {

        List<Starship> starships = new ArrayList<>();
        List<StarshipDto> starshipDtos = dataRepository.getStarshipDtos(starshipDtoUrls);

        for (StarshipDto s: starshipDtos) {
           Starship starship = Starship.builder()
                   .name(s.getName())
                   .model(s.getModel())
                   .costInCredits(s.getCost_in_credits())
                   .length(s.getLength())
                   .maxAtmosphericSpeed(s.getMax_atmosphering_speed())
                   .crew(s.getCrew())
                   .starshipClass(s.getStarship_class())
                   .build();
           starships.add(starship);
        }
        return starships;
    }
}

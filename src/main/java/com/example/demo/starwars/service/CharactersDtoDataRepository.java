package com.example.demo.starwars.service;
import com.example.demo.starwars.dto.CharacterDto;
import com.example.demo.starwars.dto.CharactersDto;
import com.example.demo.starwars.dto.HomeworldDto;
import com.example.demo.starwars.dto.StarshipDto;
import lombok.extern.java.Log;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Repository
@Log
public class CharactersDtoDataRepository implements CharactersDtoRepository {

    public static final String SWAPI_PEOPLE_URL = "https://swapi.dev/api/people";

    @Override
    @Cacheable(cacheNames = "Character")
    public CharacterDto findById(long id) {

        RestTemplate restTemplate = new RestTemplate();
        URI uri = UriComponentsBuilder.fromHttpUrl(SWAPI_PEOPLE_URL)
                .path("/" + id)
                .build().toUri();
        log.info("Character retrieve URL: " + uri);
        try {
            return restTemplate.getForObject(uri, CharacterDto.class);
        } catch (RestClientException e) {
            e.printStackTrace();
            log.info("Nie znaleziono zasobu");
        }
        throw new ResponseStatusException(NOT_FOUND, "Unable to find resource");
    }

    @Override
    @Cacheable(cacheNames = "Characters")
    public CharactersDto findByPage(Integer page) {

        if ( page == null ) {page = 1;}

        RestTemplate restTemplate = new RestTemplate();
        URI uri = UriComponentsBuilder.fromHttpUrl(SWAPI_PEOPLE_URL)
                .queryParam("page" , page)
                .build().toUri();
        log.info("Characters retrieve URL: " + uri);

        try {
            return restTemplate.getForObject(uri, CharactersDto.class);
        } catch (RestClientException e) {
            e.printStackTrace();
            log.info("Nie znaleziono zasobu");
        }
        throw new ResponseStatusException(NOT_FOUND, "Unable to find resource");
    }
    @Cacheable(cacheNames = "Homeworld")
    public HomeworldDto getHomeworldDto (String homeworldUrl) {

        RestTemplate restTemplate = new RestTemplate();

        try {
            return restTemplate.getForObject(homeworldUrl, HomeworldDto.class);
        } catch (RestClientException e){
            e.printStackTrace();
        }
    return null;
    }
    @Cacheable(cacheNames = "Starships")
    public List<StarshipDto> getStarshipDtos (List<String> starshipsUrl){
        RestTemplate restTemplate = new RestTemplate();
        List<StarshipDto> starshipDtos = new ArrayList<>();

        try {
            for (String starshipUrl : starshipsUrl) {
                starshipDtos.add(restTemplate.getForObject(starshipUrl, StarshipDto.class));
            }
            return starshipDtos;
        } catch (RestClientException e){
            e.printStackTrace();
        }
    return null;
    }

}

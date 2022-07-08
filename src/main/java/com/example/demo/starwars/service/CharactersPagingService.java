package com.example.demo.starwars.service;
import org.springframework.stereotype.Service;

@Service
public class CharactersPagingService implements  PagingService {


    @Override
    public int calculateAmountOfPages(int count) {

        int defaultLimit = 10;
        return (count % defaultLimit == 0) ? count / defaultLimit : count / defaultLimit + 1;
    }
}
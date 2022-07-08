package com.example.demo.starwars.starwars.service;

import com.example.demo.starwars.service.CharactersPagingService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharactersPagingServiceTest {

    @Test
    public void isCalculatedAmountCorrect(){
        CharactersPagingService service = new CharactersPagingService();


        assertEquals(9, service.calculateAmountOfPages(82));
        assertEquals(10, service.calculateAmountOfPages(100));
        assertEquals(10, service.calculateAmountOfPages(99));
        assertEquals(0, service.calculateAmountOfPages(0));
        assertEquals(1, service.calculateAmountOfPages(9));

    }


}
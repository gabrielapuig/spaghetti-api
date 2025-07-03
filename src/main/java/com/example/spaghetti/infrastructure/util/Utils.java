package com.example.spaghetti.infrastructure.util;

public class Utils {

    public int countLetters(String input) {
        if (input == null) return 0;
        return (int) input.chars()
                .filter(Character::isLetter)
                .count();
    }
}
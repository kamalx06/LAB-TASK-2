package com.example.lab_task_2;

public class WordCounter {

    public int countWords(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        String[] words = text.trim().split("\\s+|,|\\.");
        return words.length;
    }

    public int countCharacters(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        return text.length();
    }
}

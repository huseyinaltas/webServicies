package com.servicies.chapter2;

/**
 * Created by vlados on 6/14/2017.
 */
public class Adage {
    private String words;
    private int wordCount;
    private int id;

    public Adage() {
    }

    @Override
    public String toString() {
        return String.format("%2d: ", id) + words + " -- " + wordCount + " words";
    }

    public void setWords(String words) {
        this.words = words;
        this.wordCount = words.trim().split("\\s+").length;
    }

    public String getWords() {
        return this.words;
    }

    public void setWordCount(int wordCount) {
    }

    public int getWordCount() {
        return this.wordCount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
}
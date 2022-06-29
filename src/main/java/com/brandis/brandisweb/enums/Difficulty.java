package com.brandis.brandisweb.enums;

public enum Difficulty {
    EASY("easy"),
    NORMAL("normal"),
    HARD("hard"),
    VERY_HARD("very-hard"),
    DEV_TEST("dev-test");
    private String difficulty;
     Difficulty(String difficulty){
        this.difficulty = difficulty;
    }

    public String getDifficulty() {
        return difficulty;
    }
}

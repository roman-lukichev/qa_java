package com.example;

import java.util.List;

public class Alex extends Lion{

    public Alex(Feline feline) throws Exception {
        super("Самец", feline);
    }

    @Override
    public int getKittens() {
        return feline.getKittens(0);
    }

    public List<String> getFriends(){
        return List.of("Марти", "Глория", "Мелман");
    }

    public String getPlaceOfLiving(){
        return "Нью-Йоркский зоопарк";
    }
}

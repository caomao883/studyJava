package com.uestc.factory.pattern;

public class FoodFactory {
    public static void main(String[] args) {
        Food egges = getFood("egges");
        Food chips = getFood("chips");
        Food chilcken = getFood("chilcken");
        if(egges != null) {
            egges.get();
        }
        if(chips != null) {
            chips.get();
        }
        if(chilcken != null) {
            chilcken.get();
        }
    }
    public static Food getFood(String type) {
        if(type.equals("chips")) {
            return Chips.getInstance();
        } else if(type.equals("egges")) {
            return Egges.getInstance();
        } else {
            System.out.println(type + " is not exist!");
        }
        return null;


    }
}

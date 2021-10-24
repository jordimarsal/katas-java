package net.jordimp.katas.katas;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import net.jordimp.katas.katas.fighter.Fighter;

public class Fighters {

    private Fighters(){}
    
    public static String declareWinner(final Fighter fighter1, final Fighter fighter2, final String firstAttacker) {
        String winner = "";
        List<FighterKata> arena = setArena(new FighterKata(fighter1), new FighterKata(fighter2), firstAttacker);

        while (winner.isEmpty()){
            round(arena);
            winner = checkWinner(arena);
        }
        return winner;
    }

    static List<FighterKata> setArena(FighterKata fighter1, FighterKata fighter2, String firstAttacker){
        List<FighterKata> arena = new ArrayList<>();
        if (fighter1.getName().equals(firstAttacker)){
            arena.add(fighter1);
            arena.add(fighter2);
            return arena;
        }
        arena.add(fighter2);
        arena.add(fighter1);
        return arena;
    }

    static void round(List<FighterKata> arena){
        arena.get(1).decreaseHealth(arena.get(0).getDamagePerAttack());
        if (arena.get(1).isAlive()){
            arena.get(0).decreaseHealth(arena.get(1).getDamagePerAttack());
        }
    }

    static String checkWinner(List<FighterKata> arena){
        List<String> living = arena.stream()
                .filter(FighterKata::isAlive)
                .map(FighterKata::getName)
                .collect(Collectors.toList());
        return living.size()==1 ? living.get(0) : "";
    }
}

class FighterKata {

    private final String name;
    private int health;
    private final int damagePerAttack;

    public FighterKata(final Fighter fighter) {
        this.name = fighter.name;
        this.health = fighter.health;
        this.damagePerAttack = fighter.damagePerAttack;
    }

    public void decreaseHealth(int strike) {
        this.health -= strike;
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    public String getName() {
        return this.name;
    }

    public int getDamagePerAttack() {
        return this.damagePerAttack;
    }
}


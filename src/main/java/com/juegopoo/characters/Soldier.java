package com.juegopoo.characters;

import java.util.Random;
public class Soldier extends Character {
    int i=0;
    public Soldier(){
        setHealth(100);
        setClasses("melee");
        setItem("Daga");
    }
    @Override
    public double attack(){
        Random rand = new Random();
        int randomNum = rand.nextInt(5)+1;
        setAttackLvl(rand.nextInt(10)+1);
        return getAttackLvl() + randomNum;
    }
}

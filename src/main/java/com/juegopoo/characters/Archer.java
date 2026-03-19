package com.juegopoo.characters;

import java.util.Random;

public class Archer extends Character{
       public Archer (){
        setHealth(110);
        setClasses("long");
        setItem("Arco");
    }
    @Override
    public double bowAttack(){
        Random rand = new Random();
        setAttackLvl(rand.nextInt(10)+1);
        int randomNum = rand.nextInt(8)+1;
                return getAttackLvl() + randomNum ;

    }
    @Override
    public double swordAttack(){
        Random rand = new Random();
        setAttackLvl(rand.nextInt(10)+1);
                return getAttackLvl() + 5 ;

    }
}


package com.juegopoo.characters;

import java.util.Random;


public class Curandeer extends Character{
    public Curandeer(){
        setName("Curandeer");
        setHealth(100);
        setClasses("long");
        setItem("LLamas de Salud");
    }
    @Override
    public double heal(){
        Random rand = new Random();
        int randomNum = rand.nextInt(5)+1;
        setAttackLvl(rand.nextInt(10)+1);
        return getAttackLvl() + randomNum;
    }
}

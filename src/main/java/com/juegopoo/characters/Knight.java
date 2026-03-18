package com.juegopoo.characters;

import java.util.Random;

public class Knight extends Character{
    int i =0;
    public Knight (){   
        setHealth(120);
        setClasses("melee");
        setItem("Espada");
    }
        @Override
        public double attack(){
        Random rand = new Random();
        setAttackLvl(rand.nextInt(10)+1);
        int randomNum = rand.nextInt(100)+1;
            if (randomNum <= 25) { 
                return (getAttackLvl() *2) + 5 ;
            }else{
                return getAttackLvl() + 3 ;
            }

    }
}

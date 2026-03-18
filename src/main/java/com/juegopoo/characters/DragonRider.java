package com.juegopoo.characters;

import java.util.Random;

public class DragonRider extends Character {
        public DragonRider (){
        super();
        setHealth(150);
        setClasses("mid");
        setName("Odin");
        setItem("LLamas de dragon");
    }
        @Override
        public double attack(){
        Random rand = new Random();
        setAttackLvl(rand.nextInt(10)+1);
        int randomNum = rand.nextInt(100)+1;
            if (randomNum > 30) { 
                return getAttackLvl() * 3 ;
            }else{
                return 0 ;
            }

    }
}

package com.juegopoo;
import java.util.ArrayList;

import com.juegopoo.characters.Character;
import com.juegopoo.homes.Home;
public class Main {
    public static void main(String[] args) {
            ArrayList<Character> characterList1 = new ArrayList<>();
            ArrayList<Character> deadCharacterList1 = new ArrayList<>();
            Home casa1 = new Home(characterList1,deadCharacterList1,"Casa 1");
            ArrayList<Character> characterList2 = new ArrayList<>();
            ArrayList<Character> deadCharacterList2 = new ArrayList<>();
            Home casa2 = new Home(characterList2,deadCharacterList2,"Casa 2");
            while(characterList1.size() !=5){
                casa1.selectCharacter(characterList1);
            }
            while(characterList2.size() !=5){
                casa2.selectCharacter(characterList2);
            }

            casa1.showStats(characterList1, casa1);
            casa2.showStats(characterList2, casa2);
            Character attacker;
            Character attacked;
            double damage;
            boolean isDead;
            while(!Home.finishedGame(casa1,casa2)){
                //Turno Casa 1
                attacker = casa1.selectCharacterToAttack();
                attacked = casa1.selectRivalToAttack();
                if (casa1.isArcherARival(attacker, attacked)) {
                    damage = casa1.acherIsAttacked(attacker, attacked);
                }else{
                    damage = casa1.attackCharacter(attacker, attacked);
                }
                isDead = casa1.isCharacterDead(attacked);
                if (isDead) {
                    casa1.setCharacterDeadHealth(attacked);
                    casa1.CharacterDied(attacked,characterList1,deadCharacterList1);
                }
                
                casa1.showAttack(attacker, attacked, casa1, casa2, damage);
                //Turno Casa 2
                attacker = casa2.selectCharacterToAttack();
                attacked = casa2.selectRivalToAttack();
                if (casa2.isArcherARival(attacker, attacked)) {
                    damage = casa2.acherIsAttacked(attacker, attacked);
                }else{
                    damage = casa2.attackCharacter(attacker, attacked);
                }
                isDead = casa2.isCharacterDead(attacked);
                if (isDead) {
                    casa2.setCharacterDeadHealth(attacked);
                    casa2.CharacterDied(attacked,characterList2,deadCharacterList2);
                }
                casa2.showAttack(attacker, attacked, casa1, casa2, damage);
            }
    }
}
    
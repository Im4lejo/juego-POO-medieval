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

            double damage;
            boolean isDead;

            while(!Home.finishedGame(casa1,casa2)){
                //Turno Casa 1
                Character attacker1 = casa1.selectCharacterToAttack(characterList1);
                Character attacked1 = casa2.selectRivalToAttack(characterList2);
                if (casa1.isAttackerArcher(attacker1) && casa2.isAttackerArcher(attacked1)) {
                    damage = casa1.acherIsAttacked(attacker1, attacked1);
                }else{
                    if (casa1.isAttackerArcher(attacker1)) {
                        damage = casa1.archerAttack(attacker1,attacked1);
                    }else{
                        damage = casa1.attackCharacter(attacker1, attacked1);
                    }
                }
                isDead = casa2.isCharacterDead(attacked1);
                if (isDead) {
                    casa2.setCharacterDeadHealth(attacked1);
                    casa2.CharacterDied(attacked1,characterList2,deadCharacterList2);
                }
                
                casa1.showAttack(attacker1, attacked1, casa1, casa2, damage);
                //Turno Casa 2
                Character attacker2 = casa2.selectCharacterToAttack(characterList2);
                Character attacked2 = casa1.selectRivalToAttack(characterList1);

                if (casa2.isAttackerArcher(attacker2) && casa1.isAttackerArcher(attacked2)) {
                    damage = casa2.acherIsAttacked(attacker2, attacked2);
                }else{
                    if (casa2.isAttackerArcher(attacker2)) {
                        damage = casa2.archerAttack(attacker2,attacked2);
                    }else{
                        damage = casa2.attackCharacter(attacker2, attacked2);
                    }
                    
                }
                isDead = casa1.isCharacterDead(attacked2);
                if (isDead) {
                    casa1.setCharacterDeadHealth(attacked2);
                    casa1.CharacterDied(attacked2,characterList1,deadCharacterList1);
                }
                casa2.showAttack(attacker2, attacked2, casa1, casa2, damage);
                casa1.showStats(characterList1, casa1);
                casa2.showStats(characterList2, casa2);
            }
    }
}
    
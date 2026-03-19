package com.juegopoo;
import java.util.ArrayList;

import com.juegopoo.characters.Character;
import com.juegopoo.homes.Home;
public class Main {
    public static void main(String[] args) {
            ArrayList<Character> characterList1 = new ArrayList<>();
            ArrayList<Character> deadCharacterList1 = new ArrayList<>();
            Home casa1 = new Home(characterList1,deadCharacterList1,"Stark");
            ArrayList<Character> characterList2 = new ArrayList<>();
            ArrayList<Character> deadCharacterList2 = new ArrayList<>();
            Home casa2 = new Home(characterList2,deadCharacterList2,"Targaryen");
            while(characterList1.size() !=5){
                casa1.selectCharacter(characterList1);
            }
            while(characterList2.size() !=5){
                casa2.selectCharacter(characterList2);
            }
                casa1.showStats(characterList1, casa1);
                casa2.showStatsDied(deadCharacterList2,casa2);

            double damage = 0;
            double healing =0;
            boolean isDead;
            Character attacker2;
            Character attacked2;
            Character attacker1;
            Character attacked1;
            while(!Home.finishedGame(casa1,casa2,characterList1,characterList2)){
                

                if (!characterList2.isEmpty() && !characterList1.isEmpty()) {
                    System.out.println("-----------TURNO CASA " + casa1.getName() + " -----------------");
                    attacker1 = casa1.selectCharacterToAttack(characterList1);
                    if (casa1.isAttackerCurandeer(attacker1)) {
                        attacked1 = casa1.selectTeammateToHeal(characterList1);
                        healing = casa1.CurandeerHeals(attacker1, attacked1);
                        casa1.showAttack(attacker1, attacked1, casa1, casa1, damage,healing);
                    }else{
                        attacked1 = casa1.selectRivalToAttack(characterList2);
                        if (casa1.isAttackerArcher(attacker1) && casa2.isAttackerArcher(attacked1)) {
                        damage = casa1.archerAttack(attacker1, attacked1);
                        }
                    
                        else  if (casa1.isAttackerArcher(attacker1)) {
                            damage = casa1.archerAttack(attacker1,attacked1);
                        }
                    
                        else if (casa2.isAttackedLongRange(attacked1)) {
                            damage = casa1.longRangerIsAttacked(attacker1, attacked1);
                        }

                        else{
                        damage = casa1.attackCharacter(attacker1, attacked1);
                        }
                    }


                isDead = casa2.isCharacterDead(attacked1);
                if (isDead) {
                    casa2.setCharacterDeadHealth(attacked1);
                    casa2.CharacterDied(attacked1,characterList2,deadCharacterList2);
                }
                    if (!attacker1.isCurandeer()) {
                        casa1.showAttack(attacker1, attacked1, casa1, casa2, damage,healing);
                    }

                }else{
                    System.out.println("La Casa " + casa1.getName() + " ha caido");
                }

                //Turno Casa 2
                if (!characterList1.isEmpty() && !characterList2.isEmpty()) {
                    System.out.println("-----------TURNO CASA " + casa2.getName() + " -----------------");
                    attacker2 = casa2.selectCharacterToAttack(characterList2);
                    if (casa2.isAttackerCurandeer(attacker2)) {
                        attacked2 = casa2.selectTeammateToHeal(characterList2);
                        healing = casa2.CurandeerHeals(attacker2, attacked2);
                        
                    }else{
                        attacked2 = casa2.selectRivalToAttack(characterList1);
                        if (casa2.isAttackerArcher(attacker2) && casa1.isAttackerArcher(attacked2)) {
                            damage = casa2.archerAttack(attacker2, attacked2);
                        }     
                        else if (casa2.isAttackerArcher(attacker2)) {
                            damage = casa1.archerAttack(attacker2,attacked2);
                        }
                
                        else if (casa2.isAttackedLongRange(attacked2)) {
                            damage = casa2.longRangerIsAttacked(attacker2, attacked2);
                        } 
                
                        else{
                            damage = casa2.attackCharacter(attacker2, attacked2);
                        }
                    }



                    
                
                isDead = casa1.isCharacterDead(attacked2);
                if (isDead) {
                    casa1.setCharacterDeadHealth(attacked2);
                    casa1.CharacterDied(attacked2,characterList1,deadCharacterList1);
                }
                if (!attacker2.isCurandeer()) {
                    casa2.showAttack(attacker2, attacked2, casa1, casa2, damage,healing);
                }



                casa1.showStats(characterList1, casa1);
                casa1.showStatsDied(deadCharacterList1,casa1);
                System.out.println();
                casa2.showStats(characterList2, casa2);
                casa2.showStatsDied(deadCharacterList2,casa2);
                }else{
                    System.out.println("La Casa " + casa1.getName() + " ha caido");
                }
                
            }
            System.out.println("Juego Terminado!!!");
            if (!characterList1.isEmpty()) {
            System.out.println("El ganador es... La Casa " + casa1.getName());
            }else{
                System.out.println("El ganador es... La Casa " + casa2.getName());
            }

    }
}
    
package com.juegopoo.homes;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.juegopoo.characters.Archer;
import com.juegopoo.characters.Character;
import com.juegopoo.characters.DragonRider;
import com.juegopoo.characters.Knight;
import com.juegopoo.characters.Soldier;

public class Home {
    public Scanner sc = new Scanner(System.in);
    int limSoldier = 3, limArcher = 2, limKnight = 2, limDragonRider =1, limCurandeer = 1;
     int contSoldier  = 0, contKnight = 0, contArcher = 0;
    ArrayList<Character> characterList = new ArrayList<>();
    ArrayList<Character> deadCharacterList = new ArrayList<>();
    private String name;
    public Home (ArrayList<Character> characterList,ArrayList<Character> deadCharacterList, String name){
        this.name = name;
        
    }
    public String getName(){
        return name; 
    }  
    public void selectCharacter(ArrayList<Character> characterLis){
                               
                Random rand = new Random();
                int opc= rand.nextInt(4);
            switch(opc){
                case 0 -> {
                    if (limSoldier > 0) {
                        Character soldier = new Soldier();
                        characterLis.add(soldier);
                        soldier.setName("Soldier " + (contSoldier+1));
                        contSoldier++;
                        limSoldier--;
                    }else{
                        break;
                    }
                    break;
            }
                case 1 -> {
                    if (limKnight > 0) {
                        Character knight = new Knight();
                        characterLis.add(knight);
                        knight.setName("Barbas " + (contKnight+1));
                        contKnight++;
                        limKnight--;
                    }else{
                        break;
                    }
                    break;
            }
                case 2 -> {
                    if (limArcher > 0) {
                        Character archer = new Archer();
                        characterLis.add(archer);
                        archer.setName("robbin " + (contArcher+1));
                        contArcher++;
                        limArcher--;
                    }else{
                        break;
                    }
                    break;
                }
                case 3 -> {
                    if (limDragonRider > 0) {
                        Character dragonRider = new DragonRider();
                        characterLis.add(dragonRider);
                        limDragonRider--;
                    }else{
                        break;
                    }
                    break;
                    
            }

        }
        
    }
    public Character selectCharacterToAttack (ArrayList <Character> characterList){
                Random rand = new Random();
                int optionAttacker= rand.nextInt(characterList.size());
        if(optionAttacker >= 0 && optionAttacker <= characterList.size()){
            return characterList.get(optionAttacker);
        }
        return null;
    }
    public Character selectRivalToAttack (ArrayList <Character> characterList){
         Random rand = new Random();
         int randomNum = rand.nextInt(characterList.size());
           
        if(randomNum >= 0 && randomNum <= characterList.size()){
            return characterList.get(randomNum);
        }

        return null;
        }
        public double archerAttack (Character attacker, Character attacked){
        
        Random rand = new Random();
        int archerAttackOption = rand.nextInt(1);
        attacker = new Archer();
        switch(archerAttackOption){
            case 0 -> {  
                double damage = attacker.bowAttack();
                double totDamage = attacked.getHealth()-(attacked.getHealth()-damage);
                attacked.setHealth(attacked.getHealth()-totDamage);
                return totDamage;
            }
            case  1 -> {
                double damage = attacker.swordAttack();
                double totDamage = attacked.getHealth()-(attacked.getHealth()-damage);
                attacked.setHealth(attacked.getHealth()-totDamage);
                return totDamage;
            }

        }
        return 0;
    }
    public boolean isArcherARival(Character attacked){
        boolean attackedClass = attacked.getClasses().equals("long");
        return attackedClass;
    }
        public boolean isNotArcherAnAttacker(Character attacker){
        boolean attackerClass = attacker.getClasses().equals("long");
        return  !attackerClass ;
    }
    
    public boolean isAttackerArcher(Character attacker){
        return attacker.isArcher();
    }
    public boolean isAttackedArcher(Character attacked){
        return attacked.isArcher();
    }
    
    public double acherIsAttacked(Character attacker, Character attacked){
            double damage = attacker.attack();
            double totDamage = attacked.getHealth()-(attacked.getHealth()-damage*2);
            attacked.setHealth(attacked.getHealth()-totDamage);
            return totDamage;
    }
    public double attackCharacter (Character attacker, Character attacked){
        double damage = attacker.attack();
        double totDamage = attacked.getHealth()-(attacked.getHealth()-damage);
        attacked.setHealth(attacked.getHealth()-totDamage);
        return totDamage;
    } 
    public boolean isCharacterDead (Character attacked){
        return attacked.getHealth() <= 0;

    }
    
    public double setCharacterDeadHealth (Character attacked){
        boolean newHealth = isCharacterDead(attacked);
        if(newHealth){
            attacked.setHealth(0);
        }
        return attacked.getHealth();
    }
    
    public void CharacterDied (Character attacked, ArrayList <Character> characterLis,ArrayList <Character> deadCharacterLis){
        double health = attacked.getHealth();
        System.out.println("Vida actual: " + health);
        int index = characterLis.indexOf(attacked);
        if (health <= 0) {    
            if (index != -1) {
            Character temporal = characterLis.remove(index);
            deadCharacterLis.add(temporal);
            }
        }
    }
    public void msgfinishedGame (Home p1, Home p2){
        if (p1.deadCharacterList.size() == 5) {
            System.out.println("La casa " + p2.getName() + " es el ganador");
        }if (p2.deadCharacterList.size() == 5) {
            System.out.println("La casa " + p1.getName() + " es el ganador");
        }

    }
        
    public static boolean finishedGame (Home p1, Home p2,ArrayList <Character> characterList1,ArrayList <Character> characterList2){
        return p1.deadCharacterList.size() == 5 || p2.deadCharacterList.size() == 5 || characterList1.isEmpty() || characterList2.isEmpty();
    }
    public void showStats (ArrayList<Character> characterLista, Home casa){
        System.out.println("---------------Personajes vivos-----------------");
        System.out.println("----- " + casa.getName()+ " ------");
        System.out.println();
        for (Character character : characterLista) {
            System.out.println(character.getName()+ " : " + character.getHealth() + "HP");
            System.out.println();
            }
    }
    public void showStatsDied (ArrayList<Character> characterListaMuertos,Home casa){        
            System.out.println("---------------Personajes Muertos-----------------");
            System.out.println("-----" + casa.getName()+ "------");
            System.out.println();
                for (Character characterMuerto : characterListaMuertos) {
                    System.out.println(characterMuerto.getName()+ " : " + characterMuerto.getHealth() + "HP");
                    System.out.println();
                }

    }
    public void showAttack(Character attacker, Character attacked, Home casa1, Home casa2, double damage){
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("El personaje: " + attacker.getName() + " de la Casa: " + casa1.getName() + " Hace " + damage +  " de danio con: "+ attacker.getItem() + "\nHacia el personaje: " + attacked.getName() + " de la casa: " + casa2.getName()+" quedando con un total de " + attacked.getHealth());
            System.out.println("-----------------------------------------------------------------------");
    }
} 
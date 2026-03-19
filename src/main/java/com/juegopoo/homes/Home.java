package com.juegopoo.homes;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.juegopoo.characters.Archer;
import com.juegopoo.characters.Character;
import com.juegopoo.characters.DragonRider;
import com.juegopoo.characters.Knight;
import com.juegopoo.characters.Soldier;
import com.juegopoo.characters.Curandeer;

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
                int opc= rand.nextInt(5);
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
                case 4 -> {
                    if (limCurandeer > 0) {
                        Character curandeer = new Curandeer();
                        characterLis.add(curandeer);
                        limCurandeer--;
                    }else{
                        break;
                    }
                    break;
                    
            }

        }
        
    }
    // ----------------- SELECT CHARACTER TO ------------------
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
    public Character selectTeammateToHeal(ArrayList <Character> characterList){
        Random rand = new Random();
        int randomNum = rand.nextInt(characterList.size());   
        if(randomNum >= 0 && randomNum <= characterList.size()){
            return characterList.get(randomNum);
        }
        return null;
    }
    // ----------------- SELECT CHARACTER TO------------------
        
        
    
    
        
    // ----------- LONG RANGE BOOLEANS ------------
    
    public boolean isAttackerCurandeer(Character attacker){
        return attacker.isCurandeer();
    }
    public boolean isAttackerArcher(Character attacker){
        return attacker.isArcher();
    }
    public boolean isAttackedLongRange(Character attacked){
        return attacked.isArcher() || attacked.isCurandeer();
    }
    
    // ----------- ARCHER BOOLEANS ------------
    
    
    
    
    // ---------- CURANDEER ------------------
    
    public double CurandeerHeals (Character curandeer, Character healed){
        double healing = curandeer.heal();
        double totHealing = healed.getHealth()-(healed.getHealth()-healing);
        healed.setHealth(healed.getHealth()+totHealing);
        return totHealing;
    }
    
    // ---------- CURANDEER ------------------



    
    // ----------- ARCHER ATTACKED ------------
    public double longRangerIsAttacked(Character attacker, Character attacked){
            double damage = attacker.attack();
            double totDamage = attacked.getHealth()-(attacked.getHealth()-damage*2);
            attacked.setHealth(attacked.getHealth()-totDamage);
            return totDamage;
    }
    //------------- ARCHER ATTACKED--------------------
    
    
    
    
    
    // -------------- ARCHER ATTACKS --------------------
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
    // -------------- ARCHER ATTACKS --------------------
    
    
        // ----------------  CHARACTER ATTACKS -------------------
    
    public double attackCharacter (Character attacker, Character attacked){
        double damage = attacker.attack();
        double totDamage = attacked.getHealth()-(attacked.getHealth()-damage);
        attacked.setHealth(attacked.getHealth()-totDamage);
        return totDamage;
    } 
    
    
    
        // ----------------  CHARACTER ATTACKS -------------------
    
    
    
    
    // ----------------  CHARACTER DIES -------------------
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
        int index = characterLis.indexOf(attacked);
        if (health <= 0) {    
            if (index != -1) {
            Character temporal = characterLis.remove(index);
            deadCharacterLis.add(temporal);
            }
        }
    }
    // ----------------  CHARACTER DIES -------------------
    
    
    
            // ----------------  IS THE GAME FINISHED? -------------------
        
    public static boolean finishedGame (Home p1, Home p2,ArrayList <Character> characterList1,ArrayList <Character> characterList2){
        return p1.deadCharacterList.size() == 5 || p2.deadCharacterList.size() == 5 || characterList1.isEmpty() || characterList2.isEmpty();
    }
    public void showStats (ArrayList<Character> characterLista, Home casa){
        System.out.println("---------------Personajes vivos-----------------");
        System.out.println("----- " + casa.getName()+ " ------");
        System.out.println();
        for (Character character : characterLista) {
            System.out.println(character.getName()+ " : " + character.getHealth() + " HP");
            System.out.println();
            }
    }
    
    
            // ----------------  IS THE GAME FINISHED? -------------------
    
        // ----------------  STATS -------------------
    public void showStatsDied (ArrayList<Character> characterListaMuertos,Home casa){        
            System.out.println("---------------Personajes Muertos-----------------");
            System.out.println("-----" + casa.getName()+ "------");
            System.out.println();
                for (Character characterMuerto : characterListaMuertos) {
                    System.out.println(characterMuerto.getName()+ " : " + characterMuerto.getHealth() + " HP");
                    System.out.println();
                }

    }
    public void showAttack(Character attacker, Character attacked, Home from, Home to, double damage, double healing){
        if (attacker.isCurandeer()) {
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("El personaje: " + attacker.getName() + " de la Casa: " + from.getName() + " Hace " + "+"+ healing +  "HP"+" de curacion con: "+ attacker.getItem() +"\n"+ "\nHacia el personaje: " + attacked.getName() + " de la casa: " + to.getName()+" quedando con un total de " + attacked.getHealth());
            System.out.println("-----------------------------------------------------------------------");
        }else{
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("El personaje: " + attacker.getName() + " de la Casa: " + from.getName() + " Hace " + "-"+damage + "HP"+ " de danio con: "+ attacker.getItem() +"\n"+ "\nHacia el personaje: " + attacked.getName() + " de la casa: " + to.getName()+" quedando con un total de " + attacked.getHealth());
            System.out.println("-----------------------------------------------------------------------");
        }

    }
}
        // ----------------  STATS -------------------
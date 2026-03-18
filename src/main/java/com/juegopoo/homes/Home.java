package com.juegopoo.homes;
import com.juegopoo.characters.Character;
import com.juegopoo.characters.Soldier;
import com.juegopoo.characters.Knight;
import com.juegopoo.characters.Archer;
import com.juegopoo.characters.DragonRider;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

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
                int opc= rand.nextInt(4)+1;
            switch(opc){
                case 1 -> {
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
                case 2 -> {
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
                case 3 -> {
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
                case 4 -> {
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
    public Character selectCharacterToAttack (){
                Random rand = new Random();
                int optionAttacker= rand.nextInt(2)+1;
        if(optionAttacker >= 1 && optionAttacker <= characterList.size()){
            return characterList.get(optionAttacker - 1);
        }
        return null;
    }
    public Character selectRivalToAttack (){
         Random rand = new Random();
         int randomNum = rand.nextInt(characterList.size()+1);
           
        if(randomNum >= 1 && randomNum <= characterList.size()){
            return characterList.get(randomNum - 1);
        }

        return null;
        }
        public double archerAttack (Character pa){
        
        Random rand = new Random();
        int archerAttackOption = rand.nextInt(2)+1;
        switch(archerAttackOption){
            case 1 -> {  
                pa = new Archer();
                return pa.bowAttack();
            }
            case  2 -> {
                pa = new Archer();
                return pa.swordAttack();
            }
            default -> {
                return 0;
            }
        }
    }
    public boolean isArcherARival(Character attacker, Character attacked){
        return attacker.getClasses().equals("melee") && attacked.getClasses().equals("long");

    }
    public double acherIsAttacked(Character attacker, Character attacked){
            double damage = attacker.attack();
            double totDamage = attacked.getHealth()- (damage*2);
            attacked.setHealth(totDamage);
            return totDamage;
    }
    public double attackCharacter (Character attacker, Character attacked){
        double damage = attacker.attack();
        double totDamage = attacked.getHealth()- (damage);
        attacked.setHealth(totDamage);
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
    
    public void CharacterDied (Character attacked, ArrayList <Character> characterList,ArrayList <Character> deadcharacterList){
        double health = attacked.getHealth();
        if (health == 0) {    
            int index = characterList.indexOf(attacked);
            Character temporal  = characterList.remove(index);
            deadCharacterList.add(temporal);
        }
    }
    public void msgfinishedGame (Home p1, Home p2){
        if (p1.deadCharacterList.size() == 5) {
            System.out.println("La casa " + p2.getName() + " es el ganador");
        }if (p2.deadCharacterList.size() == 5) {
            System.out.println("La casa " + p1.getName() + " es el ganador");
        }

    }
        
    public static boolean finishedGame (Home p1, Home p2){
        return p1.deadCharacterList.size() == 5 || p2.deadCharacterList.size() == 5;
    }
    public void showStats (ArrayList<Character> characterLista, Home casa){
        System.out.println("-----" + casa.getName()+ "------");
        System.out.println();
        for (Character c : characterLista) {
            System.out.println(c.getName()+ " : " + c.getHealth() + "HP");
            System.out.println();
        }
    }
    public void showAttack(Character attacker, Character attacked, Home casa1, Home casa2, double damage){
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("El personaje: " + attacker.getName() + " de la Casa: " + casa1.getName() + "Hace " + damage +  " de danio con: "+ attacker.getItem() + "\nHacia el personaje: " + attacked.getName() + " quedando con un total de " + attacked.getHealth());
            System.out.println("-----------------------------------------------------------------------");
    }
} 
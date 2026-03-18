package com.juegopoo.characters;

public abstract class Character {
    private String name;
    private double health;
    private int attackLvl;
    private String classes;
    private String item;
    public String getName(){
        return name; 
    }                   
    public int getAttackLvl(){
        return attackLvl; 
    }
    public double getHealth(){
        return health; 
    }
    public void setName(String name){
        this.name = name; 
    }                   
    public void setAttackLvl(int attackLvl){
        this.attackLvl = attackLvl; 
    }
    public void setHealth(double health){
        this.health = health; 
    }
    public String getClasses(){
        return classes; 
    }
    public void setClasses(String classes){
        this.classes= classes; 
    }  
    public double attack(){
        return 0;
    }
    public double bowAttack() {
        return 0;
    }
    public double swordAttack() {
        return 0;
    }
        public String getItem(){
        return item; 
    }
    public void setItem(String item){
        this.item= item; 
    }  
    public boolean isArcher() {
        return this instanceof Archer;
    }
}

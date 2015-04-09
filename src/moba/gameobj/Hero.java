package moba.gameobj;

import moba.gameobj.features.*;

public class Hero implements GameObject, Movable, Attacking, Attacked,
                                      Alive, Team, Gold, Experience {

    // variables
    private String heroName;
    private int positionX;
    private int positionY;
    private int healthPoint;
    private int healthPointMax;
    private int attackDamage;
    private TeamEnum team;
    private int gold;
    private int experience;

    // constructor
    public Hero(String name, 
                int x, 
                int y, 
                int hp,
                int hpmax, 
                int damage, 
                TeamEnum team,
                int gold, 
                int exp) {
         this.heroName = name;
         this.positionX = x;
         this.positionY = y;
         this.healthPoint = hp;
         this.healthPointMax = hpmax;
         this.attackDamage = damage;
         this.team = team;
         this.gold = gold;
         this.experience = exp;
     }

     // methods

     @Override
     public String toString() {
         return heroName;
     }

     @Override
     public int getPositionX() {
         return positionX;
     }

     @Override
     public int getPositionY() {
         return positionY;
     }

     @Override
     public void move(int x, int y) {
         // Algorithm for moving
         if(positionX < x){
             positionX++;
         }else if(positionX > x){
             positionX--;
         }else{
             // move x finished
         }

         if(positionY < y){
             positionY++;
         }else if(positionY > y){
             positionY--;
         }else{
             // move y finished
         }
     }

     @Override
     public int attacking() {
         return attackDamage;
     }

     @Override
     public void attacked(int ad) {
         healthPoint -= ad;

     }

     @Override
     public void recover(int recover) {
         healthPoint = healthPoint + recover < healthPointMax ? healthPoint
             + recover : healthPointMax;
     }

    @Override
    public TeamEnum getTeam() {
        return team;
    }

    @Override
    public boolean isSameTeam(TeamEnum te) {
        return team.equals(te);
    }

    @Override
    public void gainGold(int g) {
        gold += g;
    }
	
    @Override
    public void gainExperience(int e) {
        experience += e;
    }

    @Override
    public boolean isAlive(){
        return healthPoint == 0;
    }

    @Override 
    public void damage(int damage){
        healthPoint -= damage;
        if(healthPoint < 0){
            healthPoint = 0;
        }
    }

    public void death(){
        if(!isAlive()){
            System.out.println(heroName + " dead!");
        }
    }

    /* this part is a series of set/get method which is used in 
     server database. infact, those methods above should be refactoried 
    using the basic function below. so as the interfaces.*/

    public void setHealth(int hp){
        this.healthPoint = hp;
    }

    public int getHealth(){ 
        return healthPoint;
    }

    public void setHealthMax(int hpmax){
        this.healthPointMax = hpmax;
    }

    public int getHealthMax(){ 
        return healthPointMax;
    }

    public void setAttackDamage(int attack){
        this.attackDamage = attack;
    }

    public int getAttackDamage(){ 
        return attackDamage;
    }

    public void setGold(int gold){
        this.gold = gold;
    }

    public int getGold(int gold){
        return gold;
    }

    public void setExperience(int experience){
        this.experience = experience;
    }

    public int getExperience(){
        return experience;
    }

    public void setTeam(TeamEnum team){
        this.team = team;
    }


}

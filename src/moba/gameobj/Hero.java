package moba.gameobj;

import moba.gameobj.features.*;
import java.util.*;
public class Hero implements GameObject, Movable, Attacking, Attacked,
                                      Alive, Team, Gold, Experience {

    // variables
    private String heroName;
    private int positionX;
    private int positionY;
    private int destinationX;
    private int destinationY;
    private int healthPoint;
    private int healthPointMax;
    private int attackDamage;
    private TeamEnum team;
    private int gold;
    private int experience;
    private int speed;

    // constructor
    public Hero(String name, 
                int x, 
                int y, 
                int hp,
                int hpmax, 
                int damage, 
                TeamEnum team,
                int gold, 
                int exp,
                int speed) {
         this.heroName = name;
         this.positionX = x;
         this.positionY = y;
         this.destinationX = x;
         this.destinationY = y;
         this.healthPoint = hp;
         this.healthPointMax = hpmax;
         this.attackDamage = damage;
         this.team = team;
         this.gold = gold;
         this.experience = exp;
         this.speed = speed;
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
         // set for destination
         this.destinationX = x;
         this.destinationY = y;

         // Algorithm for moving
         // setDestPositionX(e.getX() + screenX);
         // setDestPositionY(e.getY() + screenY);

         int dx = Math.abs(destinationX - positionX);
         int dy = Math.abs(destinationY - positionY);
         int s1, s2;
         int interchange;
         int p;
         LinkedList list = new LinkedList();
         list.add(positionX);
         list.add(positionY);
         if (destinationX - positionX >= 0) {
             s1 = 1;
         }
         else {
             s1 = -1;
         }


         if (destinationY - positionY >= 0) {
             s2 = 1;
         }
         else {
             s2 = -1;
         }

		
         if (dy > dx) {
             int temp = dx;
             dx = dy;
             dy = temp;
             interchange = 1;
         }
         else {
             interchange = 0;
         }
		
         p = 2 * dy - dx;

         for (int i = 1;i < dx;i++) {
             if (p >= 0) {
                 if (interchange == 0) {
                     setPositionY(positionY + s2);
                 }
                 else {
                     setPositionX(positionX + s1);
                 }
                 p -= 2 * dx;
             }
             else {
                 if (interchange == 0) {
                     setPositionX(positionX + s1);
                 }
                 else {
                     setPositionY(positionY + s2);
                 }
                 p += 2 * dy;
             }
             list.add(positionX);
             list.add(positionY);
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

    public String getHeroname(){
        return heroName;
    }

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

    public int getGold(){
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

    public void setPositionX(int x){
        this.positionX = x;
    }

    public void setPositionY(int y){
        this.positionY = y;
    }

    public int getDestinationX(){
        return destinationX;
    }

    public int getDestinationY(){
        return destinationY;
    }

    public void setSpeed(int s){
        this.speed = s;
    }

    public int getSpeed(){
        return speed;
    }
}

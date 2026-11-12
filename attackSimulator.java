import java.util.*;
public class attackSimulator{
    //this class allows one to simulate an attack with various weapons
    private int[] rolls = {1,1,1};
    public characterStats attacker;
    public characterStats defender;
    public weaponStats attackerWeapon;
    /**
     * Constructor for the attackSimulator class
     * @param attack the characterStats of the attacker
     * @param defend the characterStats of the defender
     * @param weapon the weaponStats of the weapon being used
     */
    public attackSimulator(characterStats attack, characterStats defend, weaponStats weapon){
        this.attacker = attack;
        this.defender = defend;
        this.attackerWeapon = weapon;
    }
    /**
     * Runs a single attack simulation and returns the results as a Hashtable
     * @return a Hashtable containing the permutations of damage numbers
     */
    public Hashtable<Integer, Integer> runIndividualattack(){
        
        //hash table is encoded by resultant damage 
        Hashtable<Integer, Integer> resultsHash = new Hashtable<Integer, Integer>();

        //Need to modify strength via weapon
        int attackerS = attacker.strength;
        System.out.println("s");

        int attackdamage = attacker.weapon.damage;
        System.out.println("s");
        int xc = 0;

        while(rolls[0] <= 6){
            System.out.println("rolls" + rolls[0] + "rolls" + rolls[1] + "" + rolls[2]);
            //Run through a test for each value, and add 1 to it if it fails, 
            //or move to the next one when it suceeds
            if(checkHit(attacker.weaponSkill, defender.weaponSkill, rolls[0])){
                //Continue to check wounds
                if(checkWound(attackerS, defender.toughness, rolls[1])){
                    System.out.println("wound");
                    //Now, roll a save
                    if(attackerWeapon.ap <= defender.save){
                        //progress to invuln
                        if(rolls[2] >= defender.inv){
                            //successful save
                            rolls[2] = rolls[2] + 1;
                            try{
                                int x = resultsHash.get(0);
                                x = x + 1;
                                resultsHash.put(0, x);
                            }catch (Exception e){
                                resultsHash.put(0, 1);

                            }
                        }else{
                            rolls[2] = rolls[2] + 1;
                            
                            
                            try{
                                int x = resultsHash.get(attackdamage);
                                x = x + 1;
                                resultsHash.put(attackdamage, x);
                            }catch (Exception e){
                                resultsHash.put(attackdamage, 1);

                            }

                        }

                    }else if(rolls[2] >= defender.save){
                        //successful save
                        rolls[2] = rolls[2] + 1;
                        try{
                            int x = resultsHash.get(0);
                            x = x + 1;
                            resultsHash.put(0, x);
                        }catch (Exception e){
                            resultsHash.put(0, 1);

                        }
                    }
                   
                }
                else{
                    System.out.println("failedWound");
                    rolls[1] = rolls[1] + 1;
                     try{
                        int x = resultsHash.get(0);
                        x = x + 6;
                        resultsHash.put(0, x);
                    }catch (Exception e){
                        resultsHash.put(0, 6);
                    }
                }
            }
            else{
                rolls[0] = rolls[0] + 1;
                rolls[1] = 1;
                rolls[2] = 1;
                // update results table
                try{
                    int x = resultsHash.get(0);
                    x = x + 36;
                    resultsHash.put(0, x);
                }catch (Exception e){
                    resultsHash.put(0, 36);

                }
            }
            //check for overflows
            if(rolls[2] > 6){
                rolls[2] = 1;
                rolls[1] = rolls[1] + 1;
            }
            if(rolls[1] > 6){
                rolls[1] = 1;
                rolls[0] = rolls[0] + 1;
            }
        }
        return resultsHash;
    }
    /**
     * Checks if an attack hits based on the attacker's weapon skill, the defender's weapon skill, and the roll
     * @param attackerWS the weapon skill of the attacker
     * @param defenderWS the weapon skill of the defender
     * @param roll the roll value to check against
     * @return true if the attack hits, false otherwise
     */

    public Boolean checkHit(int attackerWS, int defenderWS, int roll){
        //setting max WS
        if(attackerWS > 10){
            attackerWS = 10;
        }
        if(defenderWS > 10){
            defenderWS = 10;
        }

        int[][] targetnum = {
        {4, 6, 6, 6, 6, 6, 6, 6, 6, 6}, 
        {2, 4, 5, 6, 6, 6, 6, 6, 6, 6}, 
        {2, 3, 4, 5, 5, 6, 6, 6, 6, 6},
        {2, 2, 3, 4, 5, 5, 5, 6, 6, 6},
        {2, 2, 3, 3, 4, 5, 5, 5, 5, 6},
        {2, 2, 2, 3, 3, 4, 5, 5, 5, 5},
        {2, 2, 2, 3, 3, 3, 4, 5, 5, 5},
        {2, 2, 2, 2, 3, 3, 3, 4, 5, 5},
        {2, 2, 2, 2, 3, 3, 3, 3, 4, 5},
        {2, 2, 2, 2, 2, 3, 3, 3, 3, 4},
        };

        if (targetnum[attackerWS - 1][defenderWS -1] <= roll){
            return true;
        }
        return false;
    }

    /**
     * Checks if an attack wounds based on the attacker's strength, the defender's toughness, and the roll
     * @param attackerS the strength of the attacker
     * @param defenderT the toughness of the defender
     * @param roll the roll value to check against
     * @return true if the attack wounds, false otherwise
     */
    public Boolean checkWound(int attackerS, int defenderT, int roll){
        //setting max WS
        if(attackerS > 10){
            attackerS = 10;
        }
        if(defenderT > 10){
            defenderT = 10;
        }

        int[][] targetnum = {
        {4, 5, 6, 6, 7, 7, 7, 7, 7, 7},
        {3, 4, 5, 6, 6, 7, 7, 7, 7, 7},
        {2, 3, 4, 5, 6, 6, 7, 7, 7, 7},
        {2, 2, 3, 4, 5, 6, 6, 7, 7, 7},
        {2, 2, 2, 3, 4, 5, 6, 6, 7, 7},
        {2, 2, 2, 2, 3, 4, 5, 6, 6, 7},
        {2, 2, 2, 2, 2, 3, 4, 5, 6, 6},
        {2, 2, 2, 2, 2, 2, 3, 4, 5, 6},
        {2, 2, 2, 2, 2, 2, 2, 3, 4, 5},
        {2, 2, 2, 2, 2, 2, 2, 2, 3, 4}
        };

        if(targetnum[attackerS - 1][defenderT -1] <= roll){
            return true;
        }
        return false;
    }


}


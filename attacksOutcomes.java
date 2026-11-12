import java.math.BigInteger;
import java.util.*;
public class attacksOutcomes{
    Hashtable<Integer, Integer> individualAttack;
    characterStats attacker;
    characterStats defender;
    weaponStats weapon;
    /**
     * Constructor for the attacksOutcomes class
     * @param attck the characterStats of the attacker
     * @param defend the characterStats of the defender
     * @param weapon the weaponStats of the weapon being used
     */
    public attacksOutcomes(characterStats attck, characterStats defend, weaponStats weapon){
        this.attacker = attck;
        this.defender = defend;
        this.weapon = weapon;
        attackSimulator strikeOutcome = new attackSimulator(attacker, defender, weapon);
        this.individualAttack = strikeOutcome.runIndividualattack();
        
    }
    /**
     * Calculates the overall damage of several attacks
     * @return a Hashtable containing the permutations of damage numbers
     */
     public Hashtable<Integer, BigInteger> calculateOverallDamage(){
        int maxSingleDamageAttack = individualAttack.size();
        System.out.println(individualAttack);
        BigInteger[] valuesArray = new BigInteger[maxSingleDamageAttack];
        Arrays.fill(valuesArray, BigInteger.valueOf(0));
        Boolean x = true;
        int count = 0;
        BigInteger total = BigInteger.valueOf(0);
        
        while(count < maxSingleDamageAttack){
            System.out.println(count);
            valuesArray[count] = BigInteger.valueOf(individualAttack.get(count));
            count += 1;
         
            
        }
        System.out.println(Arrays.toString(valuesArray));
        PGF toCalc = new PGF(valuesArray, total);
        
        for (int i = 0; i < attacker.attacks; i++){
            toCalc = multiplyPGFs(toCalc, new PGF(valuesArray, total) );
            System.out.println(Arrays.toString(toCalc.currentProbabilitiyNumerator));
        }
        Hashtable<Integer, BigInteger> returnValue = new Hashtable<Integer, BigInteger>();
        for(int i = 0; i < toCalc.currentProbabilitiyNumerator.length; i++){
            returnValue.put(i, toCalc.currentProbabilitiyNumerator[i]);
        }

        return returnValue;
       
        
    }
    /**
     * multiplies PGF's
     * @param primaryPGF the first PGF to multiply
     * @param secondaryPGF the second PGF to multiply
     * @return the product of the two PGF's as a PGF
     */
   public PGF multiplyPGFs(PGF primaryPGF, PGF secondaryPGF){
        int highestValue = (primaryPGF.currentProbabilitiyNumerator.length) + (secondaryPGF.currentProbabilitiyNumerator.length) - 1;
        PGF outputPGF = new PGF(new BigInteger[(highestValue)], (primaryPGF.currentProbabilitiyDemnomerator.multiply(secondaryPGF.currentProbabilitiyDemnomerator)));
        Arrays.fill(outputPGF.currentProbabilitiyNumerator, BigInteger.valueOf(0));
        for(int i = 0; i < primaryPGF.currentProbabilitiyNumerator.length; i++){
            for(int y = 0; y < secondaryPGF.currentProbabilitiyNumerator.length; y++){

                outputPGF.currentProbabilitiyNumerator[i + y] = outputPGF.currentProbabilitiyNumerator[i + y].add((primaryPGF.currentProbabilitiyNumerator[i]).multiply(secondaryPGF.currentProbabilitiyNumerator[y]));
                
            }
        }
        

        return outputPGF;
    }
    }


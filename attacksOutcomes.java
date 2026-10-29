import java.util.*;
public class attacksOutcomes{
    Hashtable<Integer, Integer> individualAttack;
    characterStats attacker;
    characterStats defender;
    weaponStats weapon;
    public attacksOutcomes(characterStats attck, characterStats defend, weaponStats weapon){
        this.attacker = attck;
        this.defender = defend;
        this.weapon = weapon;
        attackSimulator strikeOutcome = new attackSimulator(attacker, defender, weapon);
        this.individualAttack = strikeOutcome.runIndividualattack();
        
    }
    public Hashtable<Integer, Integer> calculateOverallDamage(){

        //make a PGF, then * it by itself a number of times equal to the attacks
       
        
    }
    public PGF multiplyPGFs(PGF primaryPGF, PGF secondaryPGF){
    int highestValue = (primaryPGF.currentProbabilitiyNumerator.length) + (secondaryPGF.currentProbabilitiyNumerator.length) - 1;
    PGF outputPGF = new PGF(new int[highestValue], (primaryPGF.currentProbabilitiyDemnomerator*secondaryPGF.currentProbabilitiyDemnomerator));
    for(int i = 0; i < primaryPGF.currentProbabilitiyNumerator.length; i++){
        for(int y = 0; y < secondaryPGF.currentProbabilitiyNumerator.length; y++){
            outputPGF.currentProbabilitiyNumerator[i + y] += ((primaryPGF.currentProbabilitiyNumerator[i]) * (secondaryPGF.currentProbabilitiyNumerator[y]));
            
        }
    }
    

    return outputPGF;
}
}


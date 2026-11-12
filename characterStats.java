public class characterStats{
    //This class will represent a given character -
    // needs a constructor method, a way of assigning damage and storing core stats

    public String name;
    //The basic stats of the character
    public int weaponSkill;
    public int ballisticSkill;
    public int strength;
    public int toughness;
    public int wounds;
    public int attacks;
    public int initiative;
    public int save;
    public int inv = 7;

    //The mental stats of the character
    public int leadership;
    public int willpower;
    public int cool;
    public int intelligence;

    //The special rules applied to the character
    public String specialRules = "";

    public weaponStats weapon;
    //Constructor method
    /**
     * Constructor for the characterStats class
     * @param name the name of the character
     * @param weaponSkill the weapon skill of the character
     * @param ballisticSkill the ballistic skill of the character
     * @param strength the strength of the character
     * @param toughness the toughness of the character
     * @param wounds the number of wounds of the character
     * @param attacks the number of attacks of the character
     * @param initiative the initiative of the character
     * @param save the save value of the character
     * @param inv the invulnerable save value of the character (default is 7)
     */
    public characterStats(String name, int weaponSkill, int ballisticSkill, int strength, int toughness, int wounds, int attacks, int initiative, int save, int inv){
        this.name = name;
        this.weaponSkill = weaponSkill;
        this.ballisticSkill = ballisticSkill;
        this.strength = strength;
        this.toughness = toughness;
        this.wounds = wounds;
        this.attacks = attacks;
        this.initiative = initiative;
        this.save = save;
        this.inv = inv;
    }
    /**
     * Sets the mental stats of the character
     * @param leadership the leadership of the character
     * @param willpower the willpower of the character
     * @param cool the cool of the character
     * @param intelligence the intelligence of the character
     */
    public void setMentalStats(int leadership, int willpower, int cool, int intelligence){
        this.leadership = leadership;
        this.willpower = willpower;
        this.cool = cool;
        this.intelligence = intelligence;
    }
    /**
     * Adds a special rule to the list of special rules for the character
     * @param newSpecialRule the special rule to be added
     */
    public void addSpecialRule(String newSpecialRule){
        this.specialRules += newSpecialRule + ", ";
    }
    
}
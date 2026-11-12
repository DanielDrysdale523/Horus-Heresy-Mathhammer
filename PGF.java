
import java.math.BigInteger;

public class PGF{
    public BigInteger[] currentProbabilitiyNumerator;
    public BigInteger currentProbabilitiyDemnomerator;
    /**
     * Constructor for the PGF class
     * @param numeratorsArray an array of BigIntegers representing the numerators of the probability generating function
     * @param commonDenominator a BigInteger representing the common denominator of the probability generating function
     */
    public PGF(BigInteger[] numeratorsArray, BigInteger commonDenominator){
        currentProbabilitiyNumerator = numeratorsArray;
        currentProbabilitiyDemnomerator = commonDenominator;  
    }


}
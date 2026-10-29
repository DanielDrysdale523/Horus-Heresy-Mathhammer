
import java.math.BigInteger;

public class PGF{
    public BigInteger[] currentProbabilitiyNumerator;
    public BigInteger currentProbabilitiyDemnomerator;
    public PGF(BigInteger[] numeratorsArray, BigInteger commonDenominator){
        currentProbabilitiyNumerator = numeratorsArray;
        currentProbabilitiyDemnomerator = commonDenominator;  
    }


}
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class SavingsMethodTest {

    @Test
    public void testFutureLumpSum1(){
        assertEquals(60.02499999999999, SavingsFormulas.futureValueLumpSum(4000,0.35,4),"incorrect");
    }

    @Test
    public void testFutureLumpSum2(){
        assertEquals(2720000.0, SavingsFormulas.futureValueLumpSum(170000,4,2),"incorrect");
    }
    @Test
    public void testFutureValueLS_VariableInterest1() {
        double[] valTest1 = new double[]{2, 4, 5};
        assertEquals(1.53E7, SavingsFormulas.futureValueLS_VariableInterest(170000, valTest1), "incorrect");
    }
    @Test
    public void testFutureValueLS_VariableInterest2(){
        double[] valTest2 = new double[]{17,8,35};
        assertEquals(3.4992E7, SavingsFormulas.futureValueLS_VariableInterest(6000,valTest2) ,"incorrect");
    }

    @Test
    public void testCompoundSavingsConstant(){
        assertEquals(13800.0, SavingsFormulas.compoundSavingsConstant(2300,4,2), "incorrect");
    }

    @Test
    public void testCompoundSavingsConstant2(){
        assertEquals(4500.000000000001, SavingsFormulas.compoundSavingsConstant(4500,0.89,1), "incorrect");
    }
    @Test
    public void testCompoundSavingsVariable1(){
        double[] valTest3 = new double[]{56,23,4};
        assertEquals(992.0, SavingsFormulas.compoundSavingsVariable(valTest3,3), "incorrect");

    }
    @Test
    public void testCompoundSavingsVariable2(){
        double[] valTest3 = new double[]{20,40,60};
        assertEquals(216.418, SavingsFormulas.compoundSavingsVariable(valTest3,0.97), "incorrect");

    }
}
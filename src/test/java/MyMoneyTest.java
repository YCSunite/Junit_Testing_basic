import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MyMoneyTest {

    static int pos1 = 0;
    static int pos2 = 0;
    MyMoney money;
    MyMoney money2;

    @BeforeEach
    public void init(){
    money = new MyMoney("values.txt" ,8,1);
    money2 = new MyMoney("values.txt","values2.txt", 8,8);

    }

    @ParameterizedTest
    @ValueSource(ints = {4000,5500,15000,18000,24000,9000,11000,12000})
    void testFirstConstructor1(int cashVals){
        assertEquals(money.getCashValues()[pos1], cashVals, "incorrect");
        pos1++;

    }
//
    @Test
    void testFirstConstructor2(){
        double[] cashExpected = new double[]{4000,5500,15000,18000,24000,9000,11000,12000};
        assertArrayEquals(cashExpected, money.getCashValues(), "incorrect");
    }
    @ParameterizedTest
    @ValueSource(ints = {4000,5500,15000,18000,24000,9000,11000,12000})
    public void testSecondConstructor1(int cashVals2){
        System.out.println("pi "+ pos2);
        assertEquals(money2.getCashValues()[pos2], cashVals2, "incorrect");
        pos2++;
    }
    @Test
    public void testSecondConstructor2(){
    double[] interestExpected = new double[]{.055,.075, .045,.09, .10,.065,.035,.025};
    assertArrayEquals(interestExpected, money2.getInterestValues(), "incorrect");
    }
//
    @Test
    public void testLumpSum_ConstantRate(){
        assertEquals(8.000000000000002, money.lumpSum_ConstantRate(5000,0.2 , 4), "incorrect");
    }

    @Test
    public void testLumpSum_ConstantRate2(){
        assertEquals(171.0, money.lumpSum_ConstantRate(1900,0.3 , 2), "incorrect");
    }
//
    @Test
    public void testLumpSumVariableRate(){
    assertEquals(6421.998676371145, money2.lumpSum_VariableRate(4000),"incorrect");
    }
    @Test
    public void testLumpSumVariableRate2(){
        assertEquals(43348.49106550523, money2.lumpSum_VariableRate(27000),"incorrect");
    }
    @Test
    public void testCompoundSavings_sameContribution(){
    assertEquals(10200.000000000002, money2.compoundSavings_sameContribution(4000,0.55,2), "incorrect");
    }
    @Test
    public void testCompoundSavings_sameContribution2(){
        assertEquals(93000.0, money2.compoundSavings_sameContribution(16000,0.75,3), "incorrect");

    }
    @Test
    public void testCompoundSavings_variableContribution(){
    assertEquals(1.86345E7, money2.compoundSavings_variableContribution(2),"incorrect");
    }
    @Test
    public void testCompoundSavings_variableContribution2(){
        assertEquals(4.598545E8, money2.compoundSavings_variableContribution(4),"incorrect");

    }

	
}

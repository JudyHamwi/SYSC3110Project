package RiskTestCases;

import RiskModel.Die;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DieTest {
    Die die;
    @Before
    public void setUp() throws Exception {
        die = new Die();
    }

    @Test
    public void testDie(){
        assertTrue(die.equals(die));
    }

    @Test
    public void getFaceValue() {
        assertEquals(die.getFaceValue(),1 );
    }

    @Test
    public void rollDie() {
        assertEquals(die.rollDie(), die.getFaceValue());
    }
}
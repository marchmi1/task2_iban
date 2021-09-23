package test;

import static main.App.change4FirstTo4Last;
import static main.App.lettersToNumbers;
import static main.App.removeWhitespace;
import static main.App.validateIban;
import static main.App.validateLengthOfIban;
import static main.App.lettersToNumbersAlternative;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;


public class AppTest {


@Test
public void checkIfChangeOfCharactersOrdersWork()
{
    String given = "PL83101010230000261395100000";
    String then =  "101010230000261395100000PL83";
    assertEquals(then, change4FirstTo4Last(given));
}

@Test
public void checkIfLettersToNumbersWork()
{
    String given = "PL83101010230000261395100000";
    String then =  "252183101010230000261395100000";
    assertEquals(then, lettersToNumbers(given));
}

@Test
public void checkIfLettersToNumbersWorkWithAlternative()
{
    String given = "PL83101010230000261395100000";
    String then =  "252183101010230000261395100000";
    assertEquals(then, lettersToNumbersAlternative(given));
}

@Test
public void checkIfValidationReturnsTrue0()
{
    String given = "1";
    assertTrue(validateIban(given));
}
@Test
public void checkIfValidationReturnsTrue1()
{
    String given = "98";
    assertTrue(validateIban(given));
}
@Test
public void checkIfValidationReturnsTrue2()
{
    String given = "101010230000261395100000252183";
    assertTrue(validateIban(given));
}

@Test
public void checkIfValidationReturnsTrue()
{
    String given = "252183101010230000261395100079";
    assertTrue(validateIban(given));
}


@Test
public void checkIfValidationReturnsFalse()
{
    String given = "252183101010230000261395100076";
    assertFalse(validateIban(given));
}

@Test
public void checkIfLengthIsCorrect()
{
    String given = "252183101010230000261395100079";
    assertTrue(validateLengthOfIban(given));

    String given2 = "PL83101010230000261395100000";
    assertTrue(validateLengthOfIban(given2));
}

@Test
public void chcekIfLengthIsIncorrect(){
    
    String given = "2";
    assertFalse(validateLengthOfIban(given));

    String given2 = "PL83101010230000261395100000PL83101010230000261395100000PL83101010230000261395100000";
    assertFalse(validateLengthOfIban(given2));

}

@Test
public void testRemovingWhitespaces()
{
    String given = "PL 83 1010 10230   000261   3951 00000";
    String then =  "PL83101010230000261395100000";
    given = removeWhitespace(given);
    assertEquals(then, given );

}

}


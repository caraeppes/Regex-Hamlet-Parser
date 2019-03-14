import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        // Given
        Assert.assertTrue(hamletParser.findHamlet(hamletText));

        // When
        hamletParser.changeHamletToLeon();

        // Then
        Assert.assertFalse(hamletParser.findHamlet(hamletParser.getHamletData()));
    }

    @Test
    public void testChangeHoratioToTariq() {
        // Given
        Assert.assertTrue(hamletParser.findHoratio(hamletText));

        // When
        hamletParser.changeHoratioToTariq();

        // Then
        Assert.assertFalse(hamletParser.findHoratio(hamletParser.getHamletData()));

    }

    @Test
    public void testFindHoratio() {
        // When
        boolean actualTrue = hamletParser.findHoratio(hamletParser.getHamletData());

        // Then
        Assert.assertTrue(actualTrue);

        // When
        hamletParser.changeHoratioToTariq();
        boolean actualFalse = hamletParser.findHoratio(hamletParser.getHamletData());

        // Then
        Assert.assertFalse(actualFalse);
    }

    @Test
    public void testFindHamlet() {
        // When
        boolean actualTrue = hamletParser.findHamlet(hamletParser.getHamletData());

        // Then
        Assert.assertTrue(actualTrue);

        // When
        hamletParser.changeHamletToLeon();
        boolean actualFalse = hamletParser.findHamlet(hamletParser.getHamletData());

        // Then
        Assert.assertFalse(actualFalse);
    }

    @Test
    public void replaceTest(){
        // Given
        String data = "I love chicken tenders!";
        String original = "tenders";
        String replacement = "nuggets";
        String expected = "I love chicken nuggets!";

        // When
        String actual = hamletParser.replace(original, replacement, data);

        // Then
        Assert.assertEquals(expected, actual);
    }
}
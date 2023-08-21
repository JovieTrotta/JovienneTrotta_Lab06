import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This represents the test Class for the Sentence.
 * We start by setting up the three variables that we will use to test Sentences:
 * testSentenceOne, testSentenceTwo, and testSentenceThree.
 * We are using three variables, so we can also test the three types of Sentence constructors that we have.
 */
public class SentenceTest {
    Sentence testSentenceOne, testSentenceTwo, testSentenceThree;

    /**
     * Assigns our variables their values.
     * We have to write our sentence backwards because of the LIFO method of our add function.
     */
    @Before
    public void setup() {
        // testSentenceOne setup. This is the Default constructor.
        testSentenceOne = new Sentence();
        testSentenceOne.add("Jovie");
        testSentenceOne.add("is");
        testSentenceOne.add("name");

        // testSentenceOne setup. This is the String constructor.
        testSentenceTwo = new Sentence("hello");
        testSentenceTwo.add("say");
        testSentenceTwo.add("to");
        testSentenceTwo.add("like");
        testSentenceTwo.add("would");

        // testSentenceOne setup. This is the Node constructor, therefore we add the EmptyNode.
        testSentenceThree = new Sentence(new WordNode("xinchao", new EmptyNode()));
        testSentenceThree.add("say");
        testSentenceThree.add("also");
        testSentenceThree.add("can");
    }

    @Test
    public void testGetNumberOfWords() {
        assertEquals(3, testSentenceOne.getNumberOfWords());
        assertEquals(5, testSentenceTwo.getNumberOfWords());
        assertEquals(4, testSentenceThree.getNumberOfWords());
    }

    @Test
    public void testLongestWord() {
        assertEquals("Jovie", testSentenceOne.longestWord());
        assertEquals("would", testSentenceTwo.longestWord()); // If two words have the same length, it returns the more recently added one as the "Largest" (would(5) and hello(5)).
        assertEquals("xinchao", testSentenceThree.longestWord());
    }

    @Test
    public void testToString() {
        assertEquals("name is Jovie.", testSentenceOne.toString());
        assertEquals("would like to say hello.", testSentenceTwo.toString());
        assertEquals("can also say xinchao.", testSentenceThree.toString());
    }

    @Test
    public void testAdd() {
        // Testing adding a word to testSentenceOne.
        testSentenceOne.add("My");
        assertEquals(4, testSentenceOne.getNumberOfWords());
        assertEquals("My name is Jovie.", testSentenceOne.toString());

        // Testing adding a word to testSentenceTwo.
        testSentenceTwo.add("I");
        assertEquals(6, testSentenceTwo.getNumberOfWords());
        assertEquals("I would like to say hello.", testSentenceTwo.toString());

        // Testing adding a word to testSentenceThree.
        testSentenceThree.add("I");
        assertEquals(5, testSentenceThree.getNumberOfWords());
        assertEquals("I can also say xinchao.", testSentenceThree.toString());
    }

    @Test
    public void testClone() {
        // Just so we're working with nice full sentences :)
        testSentenceOne.add("My");
        testSentenceTwo.add("I");
        testSentenceThree.add("I");

        // Testing clone with testSentenceOne.
        // Like with the NodeTest, we want them to be identical, but not the same.
        assertEquals(4, testSentenceOne.clone().getNumberOfWords());
        assertEquals("Jovie", testSentenceOne.clone().longestWord());
        assertEquals("My name is Jovie.", testSentenceOne.clone().toString());
        assertNotEquals(testSentenceOne, testSentenceOne.clone());

        //Testing clone with testSentenceTwo.
        //Like with the NodeTest, we want them to be identical, but not the same.
        assertEquals(6, testSentenceTwo.clone().getNumberOfWords());
        assertEquals("would", testSentenceTwo.clone().longestWord());
        assertEquals("I would like to say hello.", testSentenceTwo.clone().toString());
        assertNotEquals(testSentenceTwo, testSentenceTwo.clone());

        //Testing clone with testSentenceThree.
        //Like with the NodeTest, we want them to be identical, but not the same.
        assertEquals(5, testSentenceThree.clone().getNumberOfWords());
        assertEquals("xinchao", testSentenceThree.clone().longestWord());
        assertEquals("I can also say xinchao.", testSentenceThree.clone().toString());
        assertNotEquals(testSentenceThree, testSentenceThree.clone());
    }

    @Test
    public void testMerge() {
        // Again, we test that the merged clone is what we expect, but not the same object.
        assertEquals(9, testSentenceTwo.merge(testSentenceThree).getNumberOfWords());
        assertEquals("xinchao", testSentenceTwo.merge(testSentenceThree).longestWord());
        assertEquals("would like to say hello can also say xinchao.", testSentenceTwo.merge(testSentenceThree).toString());
        assertEquals("would like to say hello can also say xinchao.", testSentenceTwo.merge(testSentenceThree).clone().toString());
        assertNotEquals(testSentenceTwo.merge(testSentenceThree), testSentenceTwo.merge(testSentenceThree).clone());
    }
}

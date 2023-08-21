import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This represents the test Class for the Nodes.
 * We start by setting up the three variables that we will use to test each Node type:
 * emptyNode (EmptyNode), punctuationNode (PunctuationNode), and wordNode (WordNode).
 */
public class NodeTest {
    Node emptyNode, punctuationNode, wordNode, sentenceNode;

    /**
     * Assigns our variables their values.
     * PunctuationNode and WordNode must always have an EmptyNode as their next Node.
     */
    @Before
    public void setup() {
        emptyNode = new EmptyNode();
        punctuationNode = new PunctuationNode(".", new EmptyNode());
        wordNode = new WordNode("test", new EmptyNode());
        sentenceNode = new WordNode("test", new WordNode("again", new EmptyNode()));
    }

    @Test
    public void testGetString() {
        assertEquals("", emptyNode.getString());
        assertEquals(".", punctuationNode.getString());
        assertEquals("test", wordNode.getString());
        // We don't test sentenceNode here since getString was only designed to return one Node.
    }

    @Test
    public void testGetNumberOfWords() {
        assertEquals(0, emptyNode.getNumberOfWords());
        assertEquals(0, punctuationNode.getNumberOfWords());
        assertEquals(1, wordNode.getNumberOfWords());
        assertEquals(2, sentenceNode.getNumberOfWords());
    }

    @Test
    public void testLongestWord() {
        assertEquals("", emptyNode.longestWord());
        assertEquals("", punctuationNode.longestWord());
        assertEquals("test", wordNode.longestWord());
        assertEquals("again", sentenceNode.longestWord());
    }

    @Test
    public void testToString() {
        assertEquals("", emptyNode.toString());
        assertEquals(".", punctuationNode.toString());
        assertEquals("test.", wordNode.toString());
        assertEquals("test again.", sentenceNode.toString());
    }

    @Test
    public void testClone() {
        // Tests that emptyNode clone is identical, but not the same object.
        assertEquals("", emptyNode.clone().getString());
        assertEquals(0, emptyNode.clone().getNumberOfWords());
        assertEquals("", emptyNode.clone().longestWord());
        assertEquals("", emptyNode.clone().toString());
        assertNotEquals(emptyNode, emptyNode.clone());

        // Tests that punctuationNode clone is identical, but not the same object.
        assertEquals(".", punctuationNode.clone().getString());
        assertEquals(0, punctuationNode.clone().getNumberOfWords());
        assertEquals("", punctuationNode.clone().longestWord());
        assertEquals(".", punctuationNode.clone().toString());
        assertNotEquals(punctuationNode, punctuationNode.clone());

        // Tests that wordNode clone is identical, but not the same object.
        assertEquals("test", wordNode.clone().getString());
        assertEquals(1, wordNode.clone().getNumberOfWords());
        assertEquals("test", wordNode.clone().longestWord());
        assertEquals("test.", wordNode.clone().toString());
        assertNotEquals(wordNode, wordNode.clone());

        // Tests that sentenceNode clone is identical, but not the same object.
        // Again, we don't test getString() here.
        assertEquals(2, sentenceNode.clone().getNumberOfWords());
        assertEquals("again", sentenceNode.clone().longestWord());
        assertEquals("test again.", sentenceNode.clone().toString());
        assertNotEquals(sentenceNode, sentenceNode.clone());
    }

    @Test
    public void testMerge() {
        // Again, we test that the merged clone is what we expect, but not the same object.
        // Again, we don't test getString() here, since we now have a "Sentence" of sorts.
        assertEquals(3, sentenceNode.merge(wordNode).getNumberOfWords());
        assertEquals("again", sentenceNode.merge(wordNode).longestWord());
        assertEquals("test again test.", sentenceNode.merge(wordNode).toString());
        assertNotEquals(sentenceNode.merge(wordNode), sentenceNode.merge(wordNode).clone());
    }

}

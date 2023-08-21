/**
 * This represents a Punctuation Node.
 * A Punctuation Node has a string (the symbol it represents) and a next (the next Node in the Sentence).
 * The next Node links the current Node to the rest of the Nodes in the Sentence.
 */
public class PunctuationNode implements Node {
    private String string;
    private Node next;

    /**
     * This constructs the PunctuationNode.
     * @param string String that represents the symbol assigned to this Node.
     * @param next Node that represents the next Node in the Sentence.
     */
    public PunctuationNode(String string, Node next) {
        this.string = string;
        this.next = next;
    }

    /**
     * Return the String associated with a particular Node.
     * For a PunctuationNode, this is a symbol.
     * @return a String.
     */
    @Override
    public String getString() {
        return string;
    }

    /**
     * Return a number added to the number associated with the next Node.
     * Since we don't count PunctuationNode, a PunctuationNode will return only return the next node.
     * @return an Integer.
     */
    @Override
    public int getNumberOfWords() {
        return this.next.getNumberOfWords();
    }

    /**
     * Return the longest String in the Sentence.
     * Looks at the length of the current Node's String, and compares it recursively to the next Node's String.
     * Since a PunctuationNode can't be considered a word, the method just skips to the next Node.
     * @return a String.
     */
    @Override
    public String longestWord() {
        return next.longestWord();
    }

    /**
     * Return the String associated with the current Node.
     * Combine it with the String associated with the next Node.
     * If the next Node is a WordNode, make sure you put spaces between them.
     * If the next Node is either an EmptyNode or another PunctuationNode, don't put a space.
     * @return a String.
     */
    @Override
    public String toString() {
        if (this.next instanceof WordNode) {return this.string + " " + this.next;}
        else {return this.string + this.next;}
    }

    /**
     * Create a new Node that is the exact duplicate of this PunctuationNode.
     * Recursively clone the next Node until you reach the end of the Sentence.
     * @return a Node.
     */
    @Override
    public Node clone() {
        return new PunctuationNode(this.string,this.next.clone());
    }

    /**
     * Create a new Node that is the exact duplicate of this PunctuationNode.
     * Recursively clone the next Node until you reach the end of the Sentence.
     * @param otherNode this Node represents the linked list (Sentence) of new Nodes to be merged.
     * @return a Node.
     */
    @Override
    public Node merge(Node otherNode) {
        return new PunctuationNode(this.string,this.next.merge(otherNode));
    }

}

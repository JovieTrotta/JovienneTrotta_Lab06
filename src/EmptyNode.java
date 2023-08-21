/**
 * This represents an Empty Node.
 * An empty node should always represent the end of a linked list (Sentence).
 */
public class EmptyNode implements Node {

    /**
     * Return the string associated with a particular Node.
     * For an EmptyNode, this is an empty string.
     * @return a String.
     */
    @Override
    public String getString() {
        return "";
    }

    /**
     * Return a number added to the number associated with the other Nodes.
     * Since we don't count EmptyNode, and an EmptyNode is the end of the Sentence, return 0.
     * @return an Integer.
     */
    @Override
    public int getNumberOfWords() {
        return 0;
    }

    /**
     * Return the longest String in the Sentence.
     * Since an EmptyNode can't be considered a word, the method returns an empty string.
     * @return a String.
     */
    @Override
    public String longestWord() {
        return "";
    }

    /**
     * Return the String associated with the current Node.
     * Since an EmptyNode can't be considered a word, the method returns an empty string.
     * @return a String.
     */
    @Override
    public String toString() {
        return "";
    }

    /**
     * Create a new Node that is the exact duplicate of this EmptyNode.
     * Since an EmptyNode represents the end of the sentence, just return the new Node.
     * @return a Node.
     */
    @Override
    public Node clone() {
        return new EmptyNode();
    }

    /**
     * Recursively clone the next Nodes (otherNode) until you reach the end of that Sentence.
     * @param otherNode this Node represents the linked list (Sentence) of new Nodes to be merged.
     * @return a Node.
     */
    @Override
    public Node merge(Node otherNode){
        return otherNode.clone();
    }

}

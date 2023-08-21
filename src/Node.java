/**
 * This interface represents an individual Node.
 * It outlines the operations to be supported by the Nodes.
 */
public interface Node {

    /**
     * @return a String.
     */
    public String getString();

    /**
     * @return an Integer.
     */
    public int getNumberOfWords();

    /**
     * @return an String.
     */
    public String longestWord();

    /**
     * @return a String.
     */
    public String toString();

    /**
     * @return a Node.
     */
    public Node clone();

    /**
     * @param otherNode this Node represents linked list (Sentence) of new Nodes to be added.
     * @return a Node.
     */
    public Node merge(Node otherNode);

}

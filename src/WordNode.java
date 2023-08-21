/**
 * This represents a Word Node.
 * A Word Node has a string (the word it represents) and a next (the next Node in the Sentence).
 * The next Node links the current Node to the rest of the Nodes in the Sentence.
 */
public class WordNode implements Node {
    private String string;
    private Node next;

    /**
     * This constructs the WordNode.
     * @param string String that represents the word assigned to this Node.
     * @param next Node that represents the next Node in the Sentence.
     */
    public WordNode(String string, Node next) {
        this.string = string;
        this.next = next;
    }

    /**
     * Return the String associated with a particular Node.
     * For a WordNode, this is a word.
     * @return a String.
     */
    @Override
    public String getString(){
        return string;
    }

    /**
     * Return a number added to the number associated with the next Node.
     * Since we only want to count WordNodes, a WordNode will return 1.
     * @return an Integer.
     */
    @Override
    public int getNumberOfWords(){
        return 1 + this.next.getNumberOfWords();
    }

    /**
     * Return the longest String in the Sentence.
     * Looks at the length of the current Node's String, and compares it recursively to the next Node's String.
     * @return a String.
     */
    @Override
    public String longestWord(){

        String holderOne; // Creates a variable to hold one of the words. This is the variable returned at the end.
        String holderTwo; // Creates a variable to hold the other word.
        // This works because each Node has its own instances of holderOne and holderTwo when it runs the method.

        if (this.string.length() > this.next.getString().length()) { // If the string associated with the current Node is longer than the string in next Node...
            holderOne = this.string; // ...assign holderOne the string value of the current Node.
            if (this.next instanceof EmptyNode) {return holderOne;} // If the next Node is Empty, just return holderOne.
            else {holderTwo = this.next.longestWord();} // Else, assign holderTwo the value of the next Node.longestWord method.

        } else { // If the string associated with the current Node is NOT longer than the string in next Node...
            holderOne = this.next.getString(); // ...assign holderOne the value of the next Node.
            if (this.next instanceof EmptyNode) {return holderOne;} // If the next Node is Empty, just return holderOne.
            else {holderTwo = this.next.longestWord();} // Else, assign holderTwo the value of the next Node.longestWord method.
        }

        if (holderOne.length() < holderTwo.length()) { // If the word in holderTwo is longer than the word in holderOne...
            holderOne = holderTwo; //...then assign holderOne the value of holderTwo.
        }

        return holderOne; // Either way, return holderOne as the longest word.
    }

    /**
     * Return the String associated with the current Node.
     * Combine it with the String associated with the next Node.
     * If the next Node is a WordNode, make sure you put spaces between them.
     * If the next Node is an EmptyNode, add a period and stop.
     * If the next Node is a PunctuationNode, don't add a space.
     * @return a String.
     */
    @Override
    public String toString() {
        if (this.next instanceof WordNode) {return this.string + " " + this.next;}
        else if (this.next instanceof EmptyNode) {return this.string + ".";}
        else {return this.string + this.next;}
    }

    /**
     * Create a new Node that is the exact duplicate of this WordNode.
     * Recursively clone the next Node until you reach the end of the Sentence.
     * @return a Node.
     */
    @Override
    public Node clone() {
        return new WordNode(this.string,this.next.clone());
    }

    /**
     * Create a new Node that is the exact duplicate of this WordNode.
     * Recursively clone the next Node until you reach the end of the Sentence.
     * @param otherNode this Node represents the linked list (Sentence) of new Nodes to be merged.
     * @return a Node.
     */
    @Override
    public Node merge(Node otherNode){
        return new WordNode(this.string,this.next.merge(otherNode));
    }

}

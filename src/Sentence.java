import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * This represents a Sentence as a linked list.
 * The linked list is made up of Nodes.
 * A Sentence has a Node (head), which represents the start of the Sentence.
 */
public class Sentence {
    private Node head;

    // I created a pattern so that the constructor and add method would automatically know which type of Node to create.
    private Pattern letter = Pattern.compile("[a-zA-z]");
    private Pattern digit = Pattern.compile("[0-9]");
    private Pattern symbol = Pattern.compile("[!@#$%&*()_+=|<>.?{}/~-]");
    private Pattern whiteSpace = Pattern.compile("[ ]");

    /**
     * This is the default constructor for the Sentence.
     * It takes no parameters, since it is an empty Sentence, and automatically knows to begin (head) and end the Sentence with an EmptyNode.
     */
    public Sentence() {
        this.head = new EmptyNode();
    }

    /**
     * This is the first constructor for the Sentence with parameters.
     * It takes a String and uses that String to create a Node.
     * Based off the string's pattern, it will create the appropriate Node.
     * @param string is the String to be associated with the head.
     */
    public Sentence(String string) {
        this();

        Matcher hasSymbol = symbol.matcher(string);
        Matcher hasWhiteSpace = whiteSpace.matcher(string);

        if (hasWhiteSpace.find()) {
            throw new IllegalArgumentException("You can't start a sentence with a blank space.");
        } else if (hasSymbol.find()) {
            this.head = new PunctuationNode(string,this.head);
        } else {
            this.head = new WordNode(string,this.head);
        }
    }

    /**
     * This is the second constructor for the Sentence with parameters.
     * It takes a Node, which should already be either Punctuation, Word, or Empty.
     * @param node is the Node to be associated with the head.
     */
    public Sentence(Node node) {
        //this();
        this.head = node;
    }

    /**
     * This method allows you to add to your Sentence.
     * It takes a String and uses that String to create a Node.
     * Based off the string's pattern, it will create the appropriate Node.
     * The old head now becomes the next Node, beginning the linked list chain.
     * @param string is the String to be associated with the new Node.
     */
    public void add(String string) {

        Matcher hasLetter = letter.matcher(string);
        Matcher hasDigit = digit.matcher(string);
        Matcher hasSymbol = symbol.matcher(string);
        Matcher hasWhiteSpace = whiteSpace.matcher(string);

        if (hasWhiteSpace.find()) { // We don't want users to add blank spaces because our program already does that for us.
            throw new IllegalArgumentException("You can't add blank space to your sentence.");

        } else if ((hasLetter.find() && hasSymbol.find()) || (hasDigit.find() && hasSymbol.find())) { // We don't want out users to mix punctuation and words because that will get confusing.
            throw new IllegalArgumentException("Punctuation marks must be in their own string.");

        } else if (hasSymbol.find()) {
            this.head = new PunctuationNode(string,this.head);

        } else {this.head = new WordNode(string,this.head);}
    }

    /**
     * Return the number of words in the Sentence.
     * @return an Integer.
     */
    public int getNumberOfWords() {
        return head.getNumberOfWords();
    }

    /**
     * Return the longest word in the Sentence.
     * @return a String.
     */
    public String longestWord() {
        return head.longestWord();
    }

    /**
     * Return the Sentence.
     * @return a String.
     */
    @Override
    public String toString() {
        return head.toString();
    }

    /**
     * Return an exact duplicate of the Sentence.
     * @return a Sentence.
     */
    public Sentence clone() {
        return new Sentence(this.head.clone());
    }

    /**
     * Return a Sentence that has been merged with another Sentence.
     * Remember that Node merge takes another Node as a parameter, so we need to get the sentenceOther's head.
     * @param sentenceOther a Sentence that is to be merged into the current Sentence.
     * @return a Sentence.
     */
    public Sentence merge(Sentence sentenceOther) {
        return new Sentence(this.head.merge(sentenceOther.head));
    }

}
/**
 * This represents the driver (main) file.
 */
public class Main {
    public static void main(String[] args) {

        // Create a new Sentence object.
        Sentence main = new Sentence();

        // Add some words to your new Sentence.
        main.add("lamb");
        main.add("little");
        main.add("a");
        main.add("had");
        main.add("Mary");

        // Print the Sentence.
        System.out.println(main);

        // See how many words there are in your Sentence.
        System.out.println(main.getNumberOfWords());

        // See the longest word in your Sentence.
        System.out.println(main.longestWord());

        // Clone your sentence.
        System.out.println(main.clone());

        // Create another sentence.
        Sentence mainTwo = new Sentence();

        // Add some words to your new sentence.
        mainTwo.add("snow");
        mainTwo.add("as");
        mainTwo.add("white");
        mainTwo.add("was");
        mainTwo.add("fleece");
        mainTwo.add("whose");

        // Print the new Sentence.
        System.out.println(mainTwo);

        // See how many words there are in your new Sentence.
        System.out.println(mainTwo.getNumberOfWords());

        // See the longest word in your new Sentence.
        System.out.println(mainTwo.longestWord());

        // Merge and then print your two sentences.
        Sentence mergedSentence = main.merge(mainTwo);
        System.out.println(mergedSentence);

        // Check the new number of words.
        System.out.println(mergedSentence.getNumberOfWords());

        // Check the new longest word.
        System.out.println(mergedSentence.longestWord());
    }
}
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class QuestWord {

    private static List<String>dictionary;
    private static final Random RANDOM = new Random();

    static {

        dictionary = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader("src/resources/dictionary.txt"))) {

            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                dictionary.add(line);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String keyWord;
    private Set<Character> mistakes;
    private char[] rightChars;
    private final int MISTAKES_LIMIT = 6;

    private final char STAR = 42;


    public QuestWord() {

        keyWord = dictionary.get(RANDOM.nextInt(dictionary.size()));
        rightChars = new char[keyWord.length()];
        Arrays.fill(rightChars, STAR);
        mistakes = new HashSet<>();
    }

    public boolean keyWordContainsLetter(String letter) {
        int lastIndex = 0;
        int count = 0;

        char symb = letter.charAt(0);

        if (!Character.isAlphabetic(symb) || (!Character.UnicodeBlock.of(symb).equals(Character.UnicodeBlock.CYRILLIC))) {
            return true; // введена не буква кириллицы, за ошибку считать не будем
        }

        while (lastIndex != -1) {
            lastIndex = keyWord.indexOf(letter, lastIndex);

            if (lastIndex != - 1) {
                rightChars[lastIndex] = letter.charAt(0);
                count++;
                lastIndex += letter.length();
            }

        }

        if (count == 0) {
            mistakes.add(letter.charAt(0));
            return false;
        }

        return true;
    }

    boolean hasStars() {
        for (int i = 0; i < rightChars.length; i++) {
            if (rightChars[i] == STAR) {
                return true;
            }
        }
        return false;
    }

    public static List<String> getDictionary() {
        return dictionary;
    }

    public static void setDictionary(List<String> dictionary) {
        QuestWord.dictionary = dictionary;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public char[] getRightChars() {
        return rightChars;
    }

    public void setRightChars(char[] rightChars) {
        this.rightChars = rightChars;
    }

    public Set<Character> getMistakes() {
        return mistakes;
    }

    public void setMistakes(Set<Character> mistakes) {
        this.mistakes = mistakes;
    }

    public int getMISTAKES_LIMIT() {
        return MISTAKES_LIMIT;
    }


}

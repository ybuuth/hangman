import java.util.Locale;
import java.util.Scanner;

public class Game {

    private static Scanner scanner = new Scanner(System.in);

    private QuestWord questWord = new QuestWord();
    private HangmanPrinter hangmanPrinter = new HangmanPrinterImpl();

    public Game() {
    }

    public void run() {

        setBeginSettings();
        checkGameStatus();

        while (true) {

            String letter = inputLetter();

            checkInput(letter);

            checkGameStatus();

            if (questWord.getMistakes().size() == questWord.getMISTAKES_LIMIT()) {
                System.out.println("Игра окончена. Гейм как говорится овер. Вы проиграли, загаданное слово " + questWord.getKeyWord());
                break;
            } else if (!questWord.hasStars()) {
                System.out.println("Вы отгадали");
                break;
            }
        }
    }

    private void checkInput(String letter) {
        if (!questWord.keyWordContainsLetter(letter)) {
            hangmanPrinter.addMistakePicture(questWord.getMistakes().size());
        }
    }

    private static String inputLetter() {
        System.out.println("Введите букву");
        String letter = scanner.next().toString().toLowerCase(Locale.ROOT);
        return letter;
    }

    private void checkGameStatus() {

        hangmanPrinter.printPicture();
        System.out.println("Слово: " + String.valueOf(questWord.getRightChars()));
        String status = String.format("Ошибки (%d): %s", questWord.getMistakes().size(),
                questWord.getMistakes());
        System.out.println(status);
    }

    private void setBeginSettings() {
        hangmanPrinter.setBeginPicture();
    }
}

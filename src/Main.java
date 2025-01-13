import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        runGame();

    }

    public static void runGame() {

        while (isGameStarted()) {
            Game game=new Game();
            game.run();
        }
        System.exit(0);
    }

    private static boolean isGameStarted() {

        do {
            System.out.println("[Н]ачать игру или [В]ыйти?");
            String answer = scanner.nextLine();
            if (answer.equals("н")||answer.equals(("Н"))) {
                System.out.println("Начинаем");
                return true;
            } else if (answer.equals("в")|| answer.equals("В")) {
                System.out.println("Закончили");
                scanner.close();
                return false;
            }
        } while (true);
    }
}
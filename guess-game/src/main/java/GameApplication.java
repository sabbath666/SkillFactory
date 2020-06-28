import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class GameApplication {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // приветствуем игрока
        // игрок создает персонажа
        // комп загадывает число от 1 до 10
        // игрок пытается угадать за 3 попытки
        //   если угадал - игрок радуется, пишем: Угадал, чертяка!! и заканчиваем игру
        //   иначе даем еще попытку
        // если не угадал за 3 попытки - пишем: Неудачник

        greeting();
        Player player = createPlayer();
        int number = makeNumber();
        int count = 0;
        boolean guessed = false;
        while (count < 3 && !guessed) {
            count = count + 1;
            guessed = guessNumber(player, number, count, guessed);
        }
    }

    private static boolean guessNumber(Player player, int number, int count, boolean guessed) {
        System.out.println("Попытка № " + count);
        int myNumber = scanner.nextInt();
        if (myNumber == number) {
            guessed = true;
            System.out.println("Угадал, чертяка!!");
            player.sayName();
            player.sayVictory();
        }
        if (count == 3 && !guessed) {
            player.sayName();
            player.sayDefeat();
            System.out.println("Неудачник");
        }
        return guessed;
    }

    private static int makeNumber() {
        int number = ThreadLocalRandom.current().nextInt(0, 10);
        System.out.println("Комп загадал число: " + number);
        return number;
    }

    private static Player createPlayer() {
        return new Troll("Сергей");
    }

    private static void greeting() {
        System.out.println("Привет. Угадай число от 0 до 9 с 3-х попыток");
    }
}

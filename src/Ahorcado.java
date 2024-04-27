import java.util.Random;
import java.util.Scanner;

public class Ahorcado {

        private static Random random = new Random();

        public static void main(String[] args) {
                // entrada de datos
                Scanner scanner = new Scanner(System.in);

                // variables
                String wordSecret = "";
                int played = 0;
                final int maxPlayed = 7;
                boolean isWinner = false;

                // wordList
                String[] wordList = {
                                "java", "python", "php",
                                "javascript", "c++", "c#", "ruby",
                                "swift", "kotlin", "go", "scala",
                                "android", "ios", "windows",
                                "linux", "mac"
                };

                // Array
                // obtener palabra ramdon para adivinar
                for (int w = 0; w < wordList.length; w++) {
                        wordSecret = getRamdonSecretWord(wordList);
                }

                // Array (char)
                char[] wordsPlayed = new char[wordSecret.length()];

                // Loop(for)
                // Inicializar el array con guiones bajos por defecto
                for (int i = 0; i < wordsPlayed.length; i++) {
                        wordsPlayed[i] = '_';
                }

                // Loop(do while)
                do {
                        System.out.println("\nPalabra a adivinar " +
                                        String.valueOf(wordsPlayed) +
                                        " (" + wordSecret.length() + " letras)");

                        System.out.print("Ingrese una letra, Por favor : ");
                        char wordPlayed = Character.toLowerCase(scanner.next().charAt(0));

                        // VALIDAR SI LA LETRA INGRESADA ES CORRECTA
                        boolean wordCorrect = false;
                        for (int i = 0; i < wordSecret.length(); i++) {
                                if (wordSecret.charAt(i) == wordPlayed) {
                                        wordsPlayed[i] = wordPlayed;
                                        wordCorrect = true;
                                }
                        }

                        // VALIDAR SI EL USUARIO HA GANADO
                        if (wordSecret.equals(String.valueOf(wordsPlayed))) {
                                System.out.println(
                                                "\n****************************************************************");
                                System.out.println(String.format(
                                                "     ¡Felicidades , Lo has conseguido la palabra era '%s' ",
                                                wordSecret));
                                System.out.println(
                                                "****************************************************************\n");
                                isWinner = true;
                        }
                        // VALIDAR SI EL USUARIO HA PERDIDO
                        if (!wordCorrect) {
                                System.out.println(getPicture(played));
                                System.out.println("\n");
                                played++;
                                String message = ((maxPlayed - played) != 1) ? " Intentos!" : " Intento!";
                                System.out.println(
                                                "****************************************************************");
                                System.out.println(
                                                "\t\t¡Incorrecto, Te quedan " + (maxPlayed - played) + message);
                                System.out.println(
                                                "****************************************************************\n");
                        }

                } while (!isWinner && played < maxPlayed);

                // SI EL USUARIO NO HA GANADO
                if (!isWinner) {
                        System.out.println("****************************************************************");
                        System.out.println(String.format(
                                        "\tHas perdido, la palabra era '%s'", wordSecret));
                        System.out.println(
                                        "****************************************************************\n");

                        System.out.println("\r\n" + //
                                        "░██████╗░░█████╗░███╗░░░███╗███████╗  ░█████╗░██╗░░░██╗███████╗██████╗░\r\n"
                                        + //
                                        "██╔════╝░██╔══██╗████╗░████║██╔════╝  ██╔══██╗██║░░░██║██╔════╝██╔══██╗\r\n"
                                        + //
                                        "██║░░██╗░███████║██╔████╔██║█████╗░░  ██║░░██║╚██╗░██╔╝█████╗░░██████╔╝\r\n"
                                        + //
                                        "██║░░╚██╗██╔══██║██║╚██╔╝██║██╔══╝░░  ██║░░██║░╚████╔╝░██╔══╝░░██╔══██╗\r\n"
                                        + //
                                        "╚██████╔╝██║░░██║██║░╚═╝░██║███████╗  ╚█████╔╝░░╚██╔╝░░███████╗██║░░██║\r\n"
                                        + //
                                        "░╚═════╝░╚═╝░░╚═╝╚═╝░░░░░╚═╝╚══════╝  ░╚════╝░░░░╚═╝░░░╚══════╝╚═╝░░╚═╝");
                }
                scanner.close();
        }

        private static String getPicture(int index) {

                String[] figure = {
                                """
                                                      +---+
                                                      |   |
                                                          |
                                                          |
                                                          |
                                                          |
                                                      =========
                                                """,
                                """
                                                      +---+
                                                      |   |
                                                      O   |
                                                          |
                                                          |
                                                          |
                                                      =========
                                                """,
                                """
                                                      +---+
                                                      |   |
                                                      O   |
                                                      |   |
                                                          |
                                                          |
                                                      =========
                                                """,
                                """
                                                      +---+
                                                      |   |
                                                      O   |
                                                     /|   |
                                                          |
                                                          |
                                                      =========
                                                """,
                                """
                                                      +---+
                                                      |   |
                                                      O   |
                                                     /|\\  |
                                                          |
                                                          |
                                                      =========
                                                """,
                                """
                                                      +---+
                                                      |   |
                                                      O   |
                                                     /|\\  |
                                                     /    |
                                                          |
                                                      =========
                                                """,
                                """
                                                      +---+
                                                      |   |
                                                      O   |
                                                     /|\\  |
                                                     / \\  |
                                                          |
                                                      =========
                                                """
                };

                return figure[index].toString();
        }

        private static String getRamdonSecretWord(String[] list) {
                int index = random.nextInt(list.length);
                return list[index];
        }
}
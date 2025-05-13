import java.util.Scanner;
import java.util.Random;

public class JogoAdivinhacao {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean jogarNovamente;

        System.out.println("\n Bem-vindo ao Jogo de Adivinhação!");

        do {
            jogarJogo(scanner);
            jogarNovamente = desejaJogarNovamente(scanner);
        } while (jogarNovamente);

        System.out.println(" Obrigado por jogar! Até a próxima.");
        scanner.close();
    }

    private static void jogarJogo(Scanner scanner) {
        Random random = new Random();
        int numeroSecreto = random.nextInt(100) + 1;
        int tentativas = 0;

        System.out.println("\nTente adivinhar o número secreto entre 1 e 100.");

        while (true) {
            System.out.print("Digite seu chute: ");

            int chute;

            try {
                chute = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("❌ Entrada inválida! Digite um número.");
                continue;
            }

            if (chute < 1 || chute > 100) {
                System.out.println(" O número deve estar entre 1 e 100!");
                continue;
            }

            tentativas++;

            if (chute < numeroSecreto) {
                System.out.println(" Muito baixo! Tente um número maior.");
            } else if (chute > numeroSecreto) {
                System.out.println(" Muito alto! Tente um número menor.");
            } else {
                if (tentativas == 1) {
                    System.out.println(" Incrível! Você acertou de primeira! O número era " + numeroSecreto + "!");
                } else {
                    System.out.println(" Parabéns! Você acertou o número " + numeroSecreto + " em " + tentativas + " tentativas.");
                }
                break;
            }
        }
    }

    private static boolean desejaJogarNovamente(Scanner scanner) {
        System.out.print("\n Deseja jogar novamente? (s/n): ");
        String resposta = scanner.nextLine().trim().toLowerCase();

        return resposta.equals("s") || resposta.equals("sim");
    }
}

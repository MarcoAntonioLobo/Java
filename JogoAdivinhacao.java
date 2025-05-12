import java.util.Scanner;
import java.util.Random;

public class JogoAdivinhacao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int numeroSecreto = random.nextInt(100) + 1; // Número entre 1 e 100
        int tentativas = 0;
        int chute;

        System.out.println("🎯 Bem-vindo ao Jogo de Adivinhação!");
        System.out.println("Tente adivinhar o número secreto entre 1 e 100.");

        do {
            System.out.print("Digite seu chute: ");
            chute = scanner.nextInt();
            tentativas++;

            if (chute < numeroSecreto) {
                System.out.println("🔻 Muito baixo! Tente um número maior.");
            } else if (chute > numeroSecreto) {
                System.out.println("🔺 Muito alto! Tente um número menor.");
            } else {
                System.out.println("✅ Parabéns! Você acertou o número " + numeroSecreto + " em " + tentativas + " tentativas.");
            }

        } while (chute != numeroSecreto);

        scanner.close();
    }
}

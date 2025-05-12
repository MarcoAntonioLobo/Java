import java.util.Scanner;
import java.util.Random;

public class JogoAdivinhacao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean jogarNovamente;

        do {
            int numeroSecreto = random.nextInt(100) + 1;
            int tentativas = 0;
            int chute;
            jogarNovamente = false;

            System.out.println("\n🎯 Bem-vindo ao Jogo de Adivinhação!");
            System.out.println("Tente adivinhar o número secreto entre 1 e 100.");

            while (true) {
                System.out.print("\nDigite seu chute: ");
                chute = scanner.nextInt();
                tentativas++;

                if (chute < 1 || chute > 100) {
                    System.out.println("⚠️ O número deve estar entre 1 e 100!");
                    continue;
                }

                if (chute < numeroSecreto) {
                    System.out.println("🔻 Muito baixo! Tente um número maior.");
                } else if (chute > numeroSecreto) {
                    System.out.println("🔺 Muito alto! Tente um número menor.");
                } else {
                    if (tentativas == 1) {
                        System.out.println("🎉 Incrível! Você acertou de primeira! O número era " + numeroSecreto + "!");
                    } else {
                        System.out.println("✅ Parabéns! Você acertou o número " + numeroSecreto + " em " + tentativas + " tentativas.");
                    }
                    break;
                }
            }

            System.out.print("\n🔁 Deseja jogar novamente? (s/n): ");
            scanner.nextLine(); // limpa buffer
            String resposta = scanner.nextLine().trim().toLowerCase();
            if (resposta.equals("s") || resposta.equals("sim")) {
                jogarNovamente = true;
            }

        } while (jogarNovamente);

        System.out.println("👋 Obrigado por jogar! Até a próxima.");
        scanner.close();
    }
}

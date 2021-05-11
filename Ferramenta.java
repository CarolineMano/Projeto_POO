import java.util.Scanner;

public class Ferramenta {
    public static void sleep (int milisegundos) {

		try {
			Thread.sleep(milisegundos);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

    public static void computarEscolha() {
        System.out.print(". ");
        Ferramenta.sleep(2000);
        System.out.print(". ");
        Ferramenta.sleep(2000);
        System.out.print(". ");
        System.out.println();
    }

    public static int testarInteiro(String mensagem, Scanner entrada) {
        boolean testeInteiro = true;
        String testeEscolha;
        int escolha = 0;
        do {
            System.out.print(mensagem);
            testeEscolha = entrada.next();
            try {
                escolha = Integer.parseInt(testeEscolha);
                testeInteiro = false;
            } catch (Exception e) {
                System.out.println("Você não digitou um número!");
                testeInteiro = true;
            }
        } while (testeInteiro);
        return escolha;
    }
}

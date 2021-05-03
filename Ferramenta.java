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
    }
        // for(int i = 0; i < novoJogo.getTamanho(); i++){
        //     System.out.println("Nome do Pokemon: " + novoJogo.getPokemons()[i].getNome());
        //     System.out.println("Arte do Pokemon: ");
        //     novoJogo.imprimirArte(i);
        //     System.out.println("*********************");
        // }
}

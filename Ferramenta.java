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
}

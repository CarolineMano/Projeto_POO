public class Main {
    public static void main(String[] args) {
        Jogo novoJogo = new Jogo();


        novoJogo.imprimirDescricao();
        novoJogo.escolherMaoComputador();
        novoJogo.escolherMaoJogador();
        novoJogo.decidirQuemComeca();
    }
}

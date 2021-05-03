import java.util.Random;
import java.util.Scanner;

public class Jogo {
    private final boolean JOGADOR = true;
    private final boolean COMPUTADOR = false;
    private Pokemon[] pokemons;
    private Pokemon[] maoJogador;
    private Pokemon[] maoComputador;
    private int tamanho;
    private Scanner entrada = new Scanner(System.in);

    public Jogo() {
        pokemons = new Pokemon[] {
            new Pokemon("Charmander", 4000, 7000, 35, 25000, "fire"),
            new Pokemon("Moltres", 10000, 6000, 40, 40000, "fire"),
            new Pokemon("Vulpix", 3000, 5000, 50, 20000, "fire"),
            new Pokemon("Magmar", 5000, 4000, 25, 50000, "fire"),
            new Pokemon("Pikachu", 7000, 8000, 40, 20000, "electric"),
            new Pokemon("Electrode", 9000, 10000, 35, 50000, "electric"),
            new Pokemon("Magnemite", 4000, 4000, 50, 35000, "electric"),
            new Pokemon("Jolteon", 5000, 5000, 50, 45000, "electric"),
            new Pokemon("Tangela", 9000, 6000, 20, 50000, "grass"),
            new Pokemon("Gloom", 6000, 6000, 35, 35000, "grass"),
            new Pokemon("Bellsprout", 3000, 7000, 50, 45000, "grass"),
            new Pokemon("Bulbasaur", 7000, 2000, 50, 10000, "grass"),
            new Pokemon("Horsea", 7000, 3000, 30, 35000, "water"),
            new Pokemon("Squirtle", 6000, 5000, 40, 30000, "water"),
            new Pokemon("Lapras", 10000, 5000, 50, 40000, "water"),
            new Pokemon("Seel", 3000, 5000, 40, 40000, "water")
        };
        tamanho = pokemons.length;
        maoJogador = new Pokemon[6];
        maoComputador = new Pokemon[6];
    }

    public Pokemon[] getPokemons() {
        return pokemons;
    }

    public int getTamanho() {
        return tamanho;
    }

    public Pokemon[] getMaoComputador() {
        return maoComputador;
    }

    public Pokemon[] getMaoJogador() {
        return maoJogador;
    }

    public void imprimirArte(int index){
        for(int i = 0; i < pokemons[index].getArte().length; i++){
            System.out.println(pokemons[index].getArte()[i]);
        }
    }

    public void imprimirDescricao() {
        String[] titulo = {
            "                               .::.                           ",
            "                              .;:**'                          ",
            "                              `                               ",
            "  .:XHHHHk.              db.   .;;.     dH  MX                ",
            "oMMMMMMMMMMM       ~MM  dMMP :MMMMMR   MMM  MR      ~MRMN     ",
            "QMMMMMb  'MMX       MMMMMMP !MX' :M~   MMM MMM  .oo. XMMM 'MMM",
            "  `MMMM.  )M> :X!Hk. MMMM   XMM.o'  .  MMMMMMM X?XMMM MMM>!MMP",
            "   'MMMb.dM! XM M'?M MMMMMX.`MMMMMMMM~ MM MMM XM `' MX MMXXMM ",
            "    ~MMMMM~ XMM. .XM XM`'MMMb.~*?**~ .MMX M t MMbooMM XMMMMMP ",
            "     ?MMM>  YMMMMMM! MM   `?MMRb.    `MM   !L'MMMMM XM IMMM   ",
            "      MMMX   'MMMM'  MM       ~%:           !Mh.''' dMI IMMP  ",
            "      'MMM.                                             IMX   ",
            "       ~M!M                                             IM    " 
        };

        for(int i = 0; i < titulo.length; i++){
            System.out.println(titulo[i]);
        }

        System.out.println("\n\n\nBem vindo ao Super Trunfo Pokémon!");
        System.out.println("******Regras do Jogo******");
        System.out.println("1 - Cada jogardor escolherá 6 Pokémon");
        System.out.println("2 - Em cada turno, os dois jogadores escolherão uma carta válida");
        System.out.println("3 - O vencedor do turno anterior escolhe uma característica");
        System.out.println("4 - Aquele que tiver a maior pontuação vence a rodada. O Pokémon perdedor fica indisponível para as próximas rodadas");
        System.out.println("5 - Em caso de empate, os dois Pokémon ficam indisponíveis");
        System.out.println("6 - Os elementos de cada Pokémon podem influenciar a pontuação final");
        System.out.println("7 - Ganha aquele que tiver Pokémons, quando o adversário não tiver mais nenhum!");
        System.out.println("*************************\n\n");
        Ferramenta.sleep(2000);
    }

    public void escolherMaoComputador() {
        Random random = new Random();
        int contador = 0;
        int escolha;
        System.out.println("O computador escolherá 6 Pokémon");
        while(contador < maoComputador.length) {
            escolha = random.nextInt(16);
            if(pokemons[escolha].isEscolhido() == false){
                maoComputador[contador] = pokemons[escolha];
                pokemons[escolha].setEscolhido(true);
                contador++;
            }
        }
        Ferramenta.computarEscolha();
        System.out.println("Pokémons escolhidos: ");
        for(int i = 0; i < maoComputador.length; i++){
            System.out.println(maoComputador[i].getNome());
        }
        System.out.println("*************************\n\n");
        Ferramenta.sleep(2000);
    }

    public void escolherMaoJogador() {
        int contador = 0;
        int escolha = 0;
        System.out.println("Você irá escolher seis Pokémon");

        while(contador < maoJogador.length){
            System.out.println("*Pokémon disponíveis*");
            for(int i = 0; i < pokemons.length; i++){
                if(pokemons[i].isEscolhido() == false){
                    System.out.println("Pokémon nº "+ i + ": " + pokemons[i].getNome());
                }            
            }
            System.out.println("Escolha o número correspondente ao Pokémon que quer escolher: ");
            escolha = entrada.nextInt();
            if(escolha < pokemons.length && pokemons[escolha] != null && !pokemons[escolha].isEscolhido()) {
                System.out.println("Você escolheu: " + pokemons[escolha].getNome());
                pokemons[escolha].setEscolhido(true);
                contador++;
            }
            else {
                System.out.println("Por favor, escolha uma opção válida!");
            }
            System.out.println("Faltam escolher " + (maoJogador.length - contador) + " Pokémon\n");
            Ferramenta.sleep(1000);
        }
    }

    public boolean decidirQuemComeca() {
        int escolha = 0;
        Random random = new Random();
        System.out.println("Vamos sortear quem irá começar!");
        escolha = random.nextInt(2);
        Ferramenta.computarEscolha();
        if(escolha == 0) {
            System.out.println("O jogador irá começar a partida");
            return JOGADOR;
        }
        else {
            System.out.println("O computador irá começar a partida");
            return COMPUTADOR;
        }
    }

  
}

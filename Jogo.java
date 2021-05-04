import java.util.Random;
import java.util.Scanner;

public class Jogo {
    private final boolean JOGADOR = true;
    private final boolean COMPUTADOR = false;
    private final int ATAQUE = 1;
    private final int DEFESA = 2;
    private final int AGILIDADE = 3;
    private final int HP = 4;
    private final String[] ATRIBUTOS = {"ataque", "defesa", "agilidade", "hp"};

    private Pokemon[] pokemons;
    private Pokemon[] maoJogador;
    private Pokemon[] maoComputador;
    private int pontosAtributoJogador;
    private int pontosAtributoComputador;
    private int atributoJogador;
    private int atributoComputador;
    private Scanner entrada = new Scanner(System.in);

    public Jogo() {
        pokemons = new Pokemon[] {
            new Pokemon("Charmander", 4000, 7000, 35, 25000, "fire"),
            new Pokemon("Ho-oh", 10000, 6000, 40, 40000, "fire"),
            new Pokemon("Vulpix", 3000, 5000, 50, 20000, "fire"),
            new Pokemon("Magmar", 5000, 4000, 25, 50000, "fire"),
            new Pokemon("Pikachu", 7000, 8000, 40, 20000, "electric"),
            new Pokemon("Ampharos", 9000, 10000, 35, 50000, "electric"),
            new Pokemon("Dedenne", 4000, 4000, 50, 35000, "electric"),
            new Pokemon("Jolteon", 5000, 5000, 50, 45000, "electric"),
            new Pokemon("Bayleef", 9000, 6000, 20, 50000, "grass"),
            new Pokemon("Treecko", 6000, 6000, 35, 35000, "grass"),
            new Pokemon("Shaymin", 3000, 7000, 50, 45000, "grass"),
            new Pokemon("Bulbasaur", 7000, 2000, 50, 10000, "grass"),
            new Pokemon("Totodile", 7000, 3000, 30, 35000, "water"),
            new Pokemon("Squirtle", 6000, 5000, 40, 30000, "water"),
            new Pokemon("Lapras", 10000, 5000, 50, 40000, "water"),
            new Pokemon("Maril", 3000, 5000, 40, 40000, "water")
        };
        maoJogador = new Pokemon[6];
        maoComputador = new Pokemon[6];
    }

    public Pokemon[] getPokemons() {
        return pokemons;
    }

    public Pokemon[] getMaoComputador() {
        return maoComputador;
    }

    public Pokemon[] getMaoJogador() {
        return maoJogador;
    }

    public int getAtributoComputador() {
        return atributoComputador;
    }
  
    public int getAtributoJogador() {
        return atributoJogador;
    }

    public int getPontosAtributoComputador() {
        return pontosAtributoComputador;
    }

    public int getPontosAtributoJogador() {
        return pontosAtributoJogador;
    }

    public void imprimirDescricao() {
        String[] titulo = Arte.getTitulo();

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
                maoJogador[contador] = pokemons[escolha];
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
            System.out.println("\nO jogador irá começar a partida\n");
            Ferramenta.sleep(2000);
            return JOGADOR;
        }
        else {
            System.out.println("\nO computador irá começar a partida\n");
            Ferramenta.sleep(2000);
            return COMPUTADOR;
        }
    }

    public boolean prepararPartida() {
        this.imprimirDescricao();
        if(decidirQuemComeca()) {
            this.escolherMaoJogador();
            this.escolherMaoComputador();
            return JOGADOR;
        }
        this.escolherMaoComputador();
        this.escolherMaoJogador();
        return COMPUTADOR;
    }
    
    public void mostrarPokemonValido() {
        for(int i = 0; i < maoJogador.length; i++) {
            if(!maoJogador[i].isDesmaiado()){
                System.out.println("Pokémon nº " + i);
                System.out.println("Nome: " + maoJogador[i].getNome());
                System.out.println("Ataque: " + maoJogador[i].getAtaque());
                System.out.println("Defesa: " + maoJogador[i].getDefesa());
                System.out.println("Agilidade: " + maoJogador[i].getAgilidade());
                System.out.println("HP: " + maoJogador[i].getHp());
                System.out.println("Tipo: " + maoJogador[i].getTipo());
                System.out.println("********************");
                Ferramenta.sleep(1000);
            }
        }
    }

    public int comecarTurnoJogador() {
        int escolhaPokemon = 0;
        int escolhaAtributo = 0;
        boolean teste = true;
        System.out.println("Pokémon disponíveis: ");
        mostrarPokemonValido();

        while(teste) {
            System.out.println("Primeiro escolha o número do Pokémon: ");
            escolhaPokemon = entrada.nextInt();
            if(escolhaPokemon < maoJogador.length && escolhaPokemon >= 0 && !maoJogador[escolhaPokemon].isDesmaiado()){
                System.out.println("Você escolheu " + maoJogador[escolhaPokemon].getNome());
                Arte.imprimirArte(maoJogador[escolhaPokemon].getNome());   
                teste = false;
            }
            else {
                System.out.println("Escolha um número válido");
            }
        }
        
        
        teste = true;

        while(teste) {
            System.out.println("Escolha o atributo do " + maoJogador[escolhaPokemon].getNome() + " para a batalha: ");
            System.out.println("1 - Ataque / 2 - Defesa / 3 - Agilidade / 4 - HP");
            escolhaAtributo = entrada.nextInt();
            if(escolhaAtributo > 0 && escolhaAtributo < 5) {
                teste = false;
                switch (escolhaAtributo) {
                    case ATAQUE:
                        System.out.println("Você escolheu Ataque, com um valor de: " + maoJogador[escolhaPokemon].getAtaque());
                        this.pontosAtributoJogador = maoJogador[escolhaPokemon].getAtaque();
                        this.atributoJogador = ATAQUE;
                        break;
                    case DEFESA:
                        System.out.println("Você escolheu Defesa, com um valor de: " + maoJogador[escolhaPokemon].getDefesa());
                        this.pontosAtributoJogador = maoJogador[escolhaPokemon].getDefesa();
                        this.atributoJogador = DEFESA;
                        break;
                    case AGILIDADE:
                        System.out.println("Você escolheu Agilidade, com um valor de: " + maoJogador[escolhaPokemon].getAgilidade());
                        this.pontosAtributoJogador = maoJogador[escolhaPokemon].getAgilidade();
                        this.atributoJogador = AGILIDADE;
                        break;
                    case HP:
                        System.out.println("Você escolheu HP, com um valor de: " + maoJogador[escolhaPokemon].getHp());
                        this.pontosAtributoJogador = maoJogador[escolhaPokemon].getHp();
                        this.atributoJogador = HP;
                        break;
                }
            } 
            else {
                System.out.println("Escolha um número válido");
            }           
        }
        return escolhaPokemon;
    }

    public int comecarTurnoComputador() {
        Random random = new Random();
        boolean teste = true;
        int escolhaPokemon = 0;
        int escolhaAtributo = 0;
        System.out.println("O computador escolherá o Pokémon");
        Ferramenta.computarEscolha();
        while(teste) {
            escolhaPokemon = random.nextInt(6);
            if(pokemons[escolhaPokemon].isDesmaiado() == false){
                System.out.println("\nO computador escolheu o " + maoComputador[escolhaPokemon].getNome());
                Arte.imprimirArte(maoComputador[escolhaPokemon].getNome());   
                teste = false;
            }
        }
        Ferramenta.sleep(1000);
        System.out.println("Agora ele irá escolher o atributo para a batalha");
        Ferramenta.computarEscolha();
        escolhaAtributo = random.nextInt(4) + 1;
        switch (escolhaAtributo) {
            case ATAQUE:
                System.out.println("\nEle escolheu Ataque, com um valor de: " + maoComputador[escolhaPokemon].getAtaque());
                this.pontosAtributoComputador = maoComputador[escolhaPokemon].getAtaque();
                this.atributoComputador = ATAQUE;
                Ferramenta.sleep(1000);
                break;
            case DEFESA:
                System.out.println("\nEle escolheu Defesa, com um valor de: " + maoComputador[escolhaPokemon].getDefesa());
                this.pontosAtributoComputador = maoComputador[escolhaPokemon].getDefesa();
                this.atributoComputador = DEFESA;
                Ferramenta.sleep(1000);
                break;
            case AGILIDADE:
                System.out.println("\nEle escolheu Agilidade, com um valor de: " + maoComputador[escolhaPokemon].getAgilidade());
                this.pontosAtributoComputador = maoComputador[escolhaPokemon].getAgilidade();
                this.atributoComputador = AGILIDADE;
                Ferramenta.sleep(1000);
                break;
            case HP:
                System.out.println("\nEle escolheu HP, com um valor de: " + maoComputador[escolhaPokemon].getHp());
                this.pontosAtributoComputador = maoComputador[escolhaPokemon].getHp();
                this.atributoComputador = HP;
                Ferramenta.sleep(1000);
                break;
        }
        return escolhaPokemon;
    }

    public int responderTurnoJogador() {
        int escolha = 0;
        boolean teste = true;
        System.out.println("O computador escolheu o atributo " + ATRIBUTOS[atributoComputador - 1] + ". Escolha um Pokémon para batalhar com o mesmo atributo");
        Ferramenta.sleep(1000);
        System.out.println("Escolha um Pokémon para batalhar com o atributo " + ATRIBUTOS[atributoComputador - 1]);
        mostrarPokemonValido();

        while(teste) {
            escolha = entrada.nextInt();
            if(maoJogador[escolha].isDesmaiado() == false && escolha >= 0 && escolha < maoJogador.length) {
                teste = false;
                System.out.println("Você escolheu o " + maoJogador[escolha].getNome());
                if(atributoComputador == ATAQUE) {
                    System.out.println("Ataque: " + maoJogador[escolha].getAtaque());
                    pontosAtributoJogador = maoJogador[escolha].getAtaque();
                }
                else if(atributoComputador == DEFESA) {
                    System.out.println("Defesa: " + maoJogador[escolha].getDefesa());
                    pontosAtributoJogador = maoJogador[escolha].getDefesa();
                }
                else if(atributoComputador == AGILIDADE) {
                    System.out.println("Agilidade: " + maoJogador[escolha].getAgilidade());
                    pontosAtributoJogador = maoJogador[escolha].getAgilidade();
                }
                else if(atributoComputador == HP) {
                    System.out.println("HP: " + maoJogador[escolha].getHp());
                    pontosAtributoJogador = maoJogador[escolha].getHp();
                }
            }
            else {
                System.out.println("Escolha um número válido");
            }
        }
        Arte.imprimirArte(maoJogador[escolha].getNome());   
        return escolha;
    }

    public int responderTurnoComputador() {
        Random random = new Random();
        int escolha = 0;
        boolean teste = true; 
        System.out.println("O jogador escolheu o atributo " + ATRIBUTOS[atributoJogador - 1] + ". O computador irá escolher um Pokémon para batalhar com o mesmo atributo");
        Ferramenta.computarEscolha();
        while(teste) {
            escolha = random.nextInt(6);
            if(maoComputador[escolha].isDesmaiado() == false) {
                teste = false;
                System.out.println("O computador escolheu o " + maoComputador[escolha].getNome());
                if(atributoJogador == ATAQUE) {
                    System.out.println("Ataque: " + maoComputador[escolha].getAtaque());
                    pontosAtributoComputador = maoComputador[escolha].getAtaque();
                }
                else if(atributoJogador == DEFESA) {
                    System.out.println("Defesa: " + maoComputador[escolha].getDefesa());
                    pontosAtributoComputador = maoComputador[escolha].getDefesa();
                }
                else if(atributoJogador == AGILIDADE) {
                    System.out.println("Agilidade: " + maoComputador[escolha].getAgilidade());
                    pontosAtributoComputador = maoComputador[escolha].getAgilidade();
                }
                else if(atributoJogador == HP) {
                    System.out.println("HP: " + maoComputador[escolha].getHp());
                    pontosAtributoComputador = maoComputador[escolha].getHp();
                }
            }
        }
        Arte.imprimirArte(maoComputador[escolha].getNome());  
        return escolha;
    }

    public boolean definirFimJogo(int contadorJogador, int contadorComputador) {
        if(contadorJogador == maoJogador.length || contadorComputador == maoComputador.length) {
            System.out.println("Fim de jogo!");
            if(contadorJogador < contadorComputador) {
                System.out.println("Você ganhou a partida");
                return false;
            }
            else if(contadorComputador < contadorJogador) {
                System.out.println("O computador ganhou a partida");
                return false;
            }
            else {
                System.out.println("A partida empatou!");
                return false;
            }
        }
        return true;
    }

    public void implementarJogo() {
        int indicePokemonJogador;
        int indicePokemonComputador;
        int contadorJogador = 0;
        int contadorComputador = 0;
        boolean testeFimJogo = true;
        boolean testePartida = prepararPartida();
        while (testeFimJogo) {
            System.out.println("O turno já vai começar!\n");
            if (testePartida) {
                indicePokemonJogador = comecarTurnoJogador();
                indicePokemonComputador = responderTurnoComputador();
            } else{
                indicePokemonComputador = comecarTurnoComputador();
                indicePokemonJogador = responderTurnoJogador();
            }

            if(pontosAtributoComputador > pontosAtributoJogador) {
                System.out.println("O computador venceu o turno. O seu Pokémon desmaiou");
                maoJogador[indicePokemonJogador].setDesmaiado(true);
                contadorJogador++;
                testePartida = COMPUTADOR;
                System.out.println("Você tem " + contadorJogador + " Pokémon desmaiados");
            }
            else if (pontosAtributoJogador > pontosAtributoComputador) {
                System.out.println("Você venceu esse turno! O Pokémon do computador desmaiou");
                maoComputador[indicePokemonComputador].setDesmaiado(true);
                contadorComputador++;
                testePartida = JOGADOR;
                System.out.println("O computador tem " + contadorComputador + " Pokémon desmaiados");
            }
            else {
                System.out.println("O turno empatou. Os dois Pokémon desmaiaram!");
                maoJogador[indicePokemonJogador].setDesmaiado(true);
                maoComputador[indicePokemonComputador].setDesmaiado(true);
                contadorComputador++;
                contadorJogador++;
                System.out.println("Você tem " + contadorJogador + " Pokémon desmaiados");
                System.out.println("O computador tem " + contadorComputador + " Pokémon desmaiados");
            }
            testeFimJogo = definirFimJogo(contadorJogador, contadorComputador);
        }                
    }  
}

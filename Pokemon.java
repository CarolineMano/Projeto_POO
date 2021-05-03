public class Pokemon {
    private String nome;
    private int ataque;
    private int defesa;
    private int agilidade;
    private int hp;
    private String tipo;
    private boolean desmaiado;
    private boolean escolhido;
    private String[] arte;

    public Pokemon(String nome, int ataque, int defesa, int agilidade, int hp, String tipo) {
        setNome(nome);
        setAtaque(ataque);
        setDefesa(defesa);
        setHp(hp);
        setTipo(tipo);
        setDesmaiado(false);
        setEscolhido(false);
        setArte(nome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getAgilidade() {
        return agilidade;
    }

    public void setAgilidade(int agilidade) {
        this.agilidade = agilidade;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isDesmaiado() {
        return desmaiado;
    }

    public void setDesmaiado(boolean desmaiado) {
        this.desmaiado = desmaiado;
    }
    
    public boolean isEscolhido() {
        return escolhido;
    }

    public void setEscolhido(boolean escolhido) {
        this.escolhido = escolhido;
    }

    public String[] getArte() {
        return arte;
    }

    public void setArte(String nome) {
        this.arte = Arte.getArte(nome);
    }  
    
}

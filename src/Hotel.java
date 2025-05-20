public class Hotel {
    private String nome;
    private String ddd;
    private String numero;

    public Hotel(String nome, String ddd, String numero) {
        this.nome = nome;
        this.ddd = ddd;
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String setDdd(){
        return ddd;
    }

    public String getDdd() {
        return ddd;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

}

public class endereco {
    private String lougradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String cep;
    private String uf;

    public endereco(String lougradouro, String numero, String complemento, String bairro, String cidade, String cep, String uf) {
        this.lougradouro = lougradouro;
        this.complemento = complemento;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
        this.uf = uf;

    }

    public String getLougradouro() {
        return lougradouro;
    }

    public void setLougradouro(String lougradouro) {
        this.lougradouro = lougradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}

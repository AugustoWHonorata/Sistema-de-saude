package entidades;

public class Endereco {
    private String logradouro;
    private String estado;
    private String cidade;
    private int numero;
    private String cep;

    // Construtor
    public Endereco(String logradouro, String estado, String cidade, int numero, String cep) {
        this.logradouro = logradouro;
        this.estado = estado;
        this.cidade = cidade;
        this.numero = numero;
        this.cep = cep;
    }

    // Getters e Setters
    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    // Método para retornar uma string com o endereço completo
    @Override
    public String toString() {
        return "Endereço: " + logradouro + ", " + numero + " - " + cidade + ", " + estado + " - CEP: " + cep;
    }
}

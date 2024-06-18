package entidades;

public class Endereco {
    private String logradouro;
    private String estado;
    private String cidade;
    private int numero;
    private String cep;

    // Construtors
    public Endereco(){}
    public Endereco( String cep, String estado, String cidade, String logradouro, int numero) {
        this.cep = cep;
        this.estado = estado;
        this.cidade = cidade;
        this.logradouro = logradouro;
        this.numero = numero;
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
        return "Endereço: " + getLogradouro() +
                ", " + getNumero() +
                " - " + getCidade() +
                ", " + getEstado() +
                " - CEP: " + getCep();
    }
}

package entidades;

public class Funcionario {
    private int id;
    private String nome;
    private int idade;
    private Endereco endereco;
    private double salario;

    // Construtors
    public Funcionario(){}

    public Funcionario(int id, String nome, int idade, Endereco endereco, double salario) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
        this.salario = salario;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    // Método para retornar uma string com as informações do funcionário
    @Override
    public String toString() {
        return "Funcionário: " + nome + ", Idade: " + idade + ", Salário: " + salario + ", " + endereco.toString();
    }
}

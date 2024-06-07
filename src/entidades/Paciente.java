package entidades;

import java.util.ArrayList;
import java.util.List;

public class Paciente {
    private int id;
    private String nome;
    private int idade;
    private double peso;
    private double altura;
    private String pressaoArterial;
    private int frequenciaCardiaca;
    private String dietaAlimentar;
    private List<String> atividadesFisicas;

    public Paciente(int id, String nome, int idade, double peso, double altura, String pressaoArterial, int frequenciaCardiaca, String dietaAlimentar, List<String> atividadesFisicas) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;
        this.pressaoArterial = pressaoArterial;
        this.frequenciaCardiaca = frequenciaCardiaca;
        this.dietaAlimentar = dietaAlimentar;
        this.atividadesFisicas = new ArrayList<>(atividadesFisicas) ;
    }

    // Getters e setters

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

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getPressaoArterial() {
        return pressaoArterial;
    }

    public void setPressaoArterial(String pressaoArterial) {
        this.pressaoArterial = pressaoArterial;
    }

    public int getFrequenciaCardiaca() {
        return frequenciaCardiaca;
    }

    public void setFrequenciaCardiaca(int frequenciaCardiaca) {
        this.frequenciaCardiaca = frequenciaCardiaca;
    }

    public String getDietaAlimentar() {
        return dietaAlimentar;
    }

    public void setDietaAlimentar(String dietaAlimentar) {
        this.dietaAlimentar = dietaAlimentar;
    }

    public List<String> getAtividadesFisicas() {
        return atividadesFisicas;
    }

    public void setAtividadesFisicas(List<String> atividadesFisicas) {
        this.atividadesFisicas = atividadesFisicas;
    }

    // Metodo para calcular IMC
    public double calcularIMC() {
        return peso / (altura * altura);
    }

    //Exercicio 03 semana 02 modulo 02
    // Método para monitorar o paciente
    public String monitoramentoPaciente() {
        return this.toString();
    }

    // Método para registrar atividades físicas
    public void registrarAtividadeFisica(String atividade) {
        atividadesFisicas.add(atividade);
    }
    @Override
    public String toString() {
        return "\n\nentidades.Paciente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", peso=" + peso +
                ", altura=" + altura +
                ", Pressao Arterial='" + pressaoArterial + '\'' +
                ", Frequencia Cardiaca=" + frequenciaCardiaca +
                ", Dieta Alimentar='" + dietaAlimentar + '\'' +
                ", Atividades Fisicas=" + atividadesFisicas +
                ", IMC=" + calcularIMC() +
                '}';
    }
}

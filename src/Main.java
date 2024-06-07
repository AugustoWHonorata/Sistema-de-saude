import entidades.Paciente;
import repositorio.GerenciamentoPacientes;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            mostrarMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (opcao) {
                case 1:
                    cadastrarPaciente();
                    break;
                case 2:
                    listarPacientes();
                    break;
                case 3:
                    alterarPaciente();
                    break;
                case 4:
                    mostrarInformacoesPaciente();
                    break;
                case 5:
                    registrarAtividadeFisica();
                    break;
                case 6:
                    removerPaciente();
                    break;
                default:
                    System.out.println("\n\nOpção inválida.");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n\nEscolha uma opção:");
        System.out.println("1 - Cadastrar um novo paciente");
        System.out.println("2 - Listar todos os pacientes");
        System.out.println("3 - Alterar informações do paciente");
        System.out.println("4 - Mostrar informações de um paciente");
        System.out.println("5 - Registrar atividade física para um paciente");
        System.out.println("6 - Remover paciente");
        System.out.print("Opção: ");
    }

    private static void cadastrarPaciente() {
        System.out.print("\nID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        System.out.print("Peso: ");
        double peso = scanner.nextDouble();
        scanner.nextLine(); // Consumir nova linha

        System.out.print("Altura: ");
        double altura = scanner.nextDouble();
        scanner.nextLine(); // Consumir nova linha

        System.out.print("Pressão Arterial: ");
        String pressaoArterial = scanner.nextLine();

        System.out.print("Frequência Cardíaca: ");
        int frequenciaCardiaca = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        System.out.print("Dieta Alimentar: ");
        String dietaAlimentar = scanner.nextLine();

        System.out.print("Atividades Físicas (separadas por vírgula): ");
        String atividades = scanner.nextLine();
        List<String> atividadesFisicas = Arrays.asList(atividades.split(","));

        Paciente novoPaciente = new Paciente(id, nome, idade, peso, altura, pressaoArterial, frequenciaCardiaca, dietaAlimentar, atividadesFisicas);
        GerenciamentoPacientes.adicionar(novoPaciente);

        System.out.println("\n\nentidades.Paciente cadastrado com sucesso!");
    }

    private static void listarPacientes() {
         GerenciamentoPacientes.listar();
    }

    private static void alterarPaciente() {
        System.out.print("\n\nID do paciente a ser alterado: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        Paciente paciente = GerenciamentoPacientes.buscarPorId(id);
        if (paciente != null) {
           System.out.print("Altere o Peso: ");
            double peso = scanner.nextDouble();
            scanner.nextLine(); // Consumir nova linha

            System.out.print("Altere a Altura: ");
            double altura = scanner.nextDouble();
            scanner.nextLine(); // Consumir nova linha

            System.out.print("Altere a Pressão Arterial: ");
            String pressaoArterial = scanner.nextLine();

            System.out.print("Altere a Frequência Cardíaca: ");
            int frequenciaCardiaca = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            System.out.print("Altere a Dieta Alimentar: ");
            String dietaAlimentar = scanner.nextLine();

            System.out.print("Altere as Atividades Físicas (separadas por vírgula): ");
            String atividades = scanner.nextLine();
            List<String> atividadesFisicas = Arrays.asList(atividades.split(","));

            boolean alterado = GerenciamentoPacientes.alterar(id, peso, altura, pressaoArterial, frequenciaCardiaca, dietaAlimentar, atividadesFisicas);
            if (alterado) {
                System.out.println("\n\nentidades.Paciente alterado com sucesso!");
            } else {
                System.out.println("\n\nentidades.Paciente não encontrado.");
            }
        } else {
            System.out.println("\n\nentidades.Paciente não encontrado.");
        }
    }

    private static void mostrarInformacoesPaciente() {
        System.out.print("\n\nID do paciente: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        Paciente paciente = GerenciamentoPacientes.buscarPorId(id);
        if (paciente != null) {
            System.out.println(paciente.monitoramentoPaciente());
        } else {
            System.out.println("\n\nentidades.Paciente não encontrado.");
        }
    }

    private static void registrarAtividadeFisica() {
        System.out.print("\n\nID do paciente: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        Paciente paciente = GerenciamentoPacientes.buscarPorId(id);
        if (paciente != null) {
            System.out.print("\n\nNova atividade física: ");
            String atividade = scanner.nextLine();
            paciente.registrarAtividadeFisica(atividade);
            System.out.println("\n\nAtividade registrada com sucesso!");
        } else {
            System.out.println("\n\nentidades.Paciente não encontrado.");
        }
    }
    private static void removerPaciente() {
        System.out.print("\n\nID do paciente a ser removido: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        boolean removido = GerenciamentoPacientes.remover(id);
        if (removido) {
            System.out.println("\n\nentidades.Paciente removido com sucesso!");
        } else {
            System.out.println("\n\nentidades.Paciente não encontrado.");
        }
    }
}

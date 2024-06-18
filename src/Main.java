import entidades.*;
import repositorio.GerenciamentoConsultas;
import repositorio.GerenciamentoFuncionarios;
import repositorio.GerenciamentoNutricionistas;
import repositorio.GerenciamentoPacientes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<String> certificacoes = new ArrayList<>();

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
                case 7:
                    cadastrarFuncionario();
                    break;
                case 8:
                    cadastrarNutricionista();
                    break;
                case 9:
                    criarConsulta();
                    break;
                case 10:
                    listarFuncionarios();
                case 11:
                    listarConsultas();
                    break;
                case 12:
                    realizarConsulta();
                    break;
                default:
                    System.out.println("\n\nOpção inválida.");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n\nEscolha uma opção:");
        System.out.println("1 - Cadastrar um novo Paciente");
        System.out.println("2 - Listar todos os Pacientes");
        System.out.println("3 - Alterar Informações do Paciente");
        System.out.println("4 - Mostrar Informações de um Paciente");
        System.out.println("5 - Registrar Atividade Física para um Paciente");
        System.out.println("6 - Remover Paciente");
        System.out.println("7 - Cadastrar Novo Funcionário");
        System.out.println("8 - Cadastrar Nutricionista");
        System.out.println("9 - Criar Consulta");
        System.out.println("10 - Listar Funcionários");
        System.out.println("11 - Listar Consultas");
        System.out.println("12 - Realizar Consulta");
        System.out.print("\nOpção: ");
    }

    private static void cadastrarPaciente() {
        System.out.println("\nCadastro de Paciente");
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

        Paciente novoPaciente = new Paciente(nome, idade, peso, altura, pressaoArterial, frequenciaCardiaca, dietaAlimentar, atividadesFisicas);
        GerenciamentoPacientes.adicionarPaciente(novoPaciente);

        System.out.println("\n\nPaciente cadastrado com sucesso!");
    }

    private static void listarPacientes() {
        System.out.println(GerenciamentoPacientes.listarPacientes());
    }

    private static void alterarPaciente() {
        System.out.println("\nAlteração de Paciente");
        System.out.print("ID do Paciente a ser alterado: ");
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
                System.out.println("\n\nPaciente alterado com sucesso!");
            } else {
                System.out.println("\n\nPaciente não encontrado.");
            }
        } else {
            System.out.println("\n\nPaciente não encontrado.");
        }
    }

    private static void mostrarInformacoesPaciente() {
        System.out.println("\n\nInformações do Paciente");
        System.out.print("ID do paciente: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        Paciente paciente = GerenciamentoPacientes.buscarPorId(id);
        if (paciente != null) {
            System.out.println(paciente.monitoramentoPaciente());
        } else {
            System.out.println("\n\nPaciente não encontrado.");
        }
    }

    private static void registrarAtividadeFisica() {
        System.out.println("\nRegistro de Atividade Física");
        System.out.print("ID do paciente: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        Paciente paciente = GerenciamentoPacientes.buscarPorId(id);
        if (paciente != null) {
            System.out.print("\n\nNova atividade física: ");
            String atividade = scanner.nextLine();
            paciente.registrarAtividadeFisica(atividade);
            System.out.println("\n\nAtividade registrada com sucesso!");
        } else {
            System.out.println("\n\nPaciente não encontrado.");
        }
    }
    private static void removerPaciente() {
        System.out.println("\nRemoção de Paciente");
        System.out.print("\n\nID do paciente a ser removido: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        boolean removido = GerenciamentoPacientes.remover(id);
        if (removido) {
            System.out.println("\n\nPaciente removido com sucesso!");
        } else {
            System.out.println("\n\nPaciente não encontrado.");
        }
    }

    private static void cadastrarFuncionario() {
        System.out.println("\nCadastro de Novo Funcionário");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        System.out.print("Cadastrar Endereco? (1- Sim, 2- Não): ");
        int cadastrarEndereco = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        Endereco endereco = new Endereco() ;

        switch (cadastrarEndereco){
            case 1:
                System.out.println("\nCadastro de Endereço ");
                System.out.print("Cep : ");
                String cep = scanner.next();
                scanner.nextLine(); // Consumir nova linha

                System.out.print("Estado: ");
                String estado = scanner.next();
                scanner.nextLine(); // Consumir nova linha

                System.out.print("Cidade: ");
                String cidade = scanner.next();
                scanner.nextLine(); // Consumir nova linha

                System.out.print("Rua: ");
                String logradouro = scanner.next();
                scanner.nextLine(); // Consumir nova linha

                System.out.print("Numero: ");
                int numeroCasa = scanner.nextInt();
                scanner.nextLine(); // Consumir nova linha

                endereco = new Endereco(cep, estado, cidade, logradouro, numeroCasa)  ;
                break;
            case 2:
                System.out.println("Endereço não cadastrado!");
                break;

        }

        System.out.print("Salario: R$ ");
        double salario  = scanner.nextDouble();
        scanner.nextLine(); // Consumir nova linha

        Funcionario novoFuncionario = new Funcionario(nome, idade, endereco, salario);
        GerenciamentoFuncionarios.adicionarFuncionario(novoFuncionario);

        System.out.println("\n\nFuncionário cadastrado com sucesso!");
    }

    private static void cadastrarNutricionista() {
        System.out.println("\nCadastro de Novo Nutricionista");
        System.out.print("\nNome: ");
        String nome = scanner.nextLine();

        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        System.out.print("Cadastrar Endereco? (1- Sim, 2- Não): ");
        int cadastrarEndereco = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        Endereco endereco = new Endereco() ;

        switch (cadastrarEndereco){
            case 1:
                System.out.println("\nCadastro de Endereço ");
                System.out.print("Cep : ");
                String cep = scanner.next();
                scanner.nextLine(); // Consumir nova linha

                System.out.print("Estado: ");
                String estado = scanner.next();
                scanner.nextLine(); // Consumir nova linha

                System.out.print("Cidade: ");
                String cidade = scanner.next();
                scanner.nextLine(); // Consumir nova linha

                System.out.print("Rua: ");
                String logradouro = scanner.next();
                scanner.nextLine(); // Consumir nova linha

                System.out.print("Numero: ");
                int numeroCasa = scanner.nextInt();
                scanner.nextLine(); // Consumir nova linha

                endereco = new Endereco(cep, estado, cidade, logradouro, numeroCasa)  ;
                break;
            case 2:
                System.out.println("\nEndereço não cadastrado!\n");
                break;

        }

        System.out.print("Salário: R$ ");
        double salario  = scanner.nextDouble();
        scanner.nextLine(); // Consumir nova linha

        System.out.println("Certificações: ");
        while (true) {
            System.out.print("Insira uma certificação (ou 0 para finalizar): ");
            String certificacao = scanner.nextLine();

            if (certificacao.equalsIgnoreCase("0")) {
                break;
            }
            certificacoes.add(certificacao);
            System.out.println("\nCertificação cadastrada com sucesso!");
        }

        System.out.print("Numero de Consultas: ");
        int numeroConsultas  = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        System.out.print("Tempo Experiencia: ");
        int tempoExperiencia  = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        Nutricionista novoNutricionista = new Nutricionista(nome, idade, endereco, salario, certificacoes, numeroConsultas, tempoExperiencia);
        GerenciamentoNutricionistas.adicionarNutricionista(novoNutricionista);

        System.out.println("\n\nNutricionista cadastrado com sucesso!");
    }


    private static void criarConsulta() {

        System.out.println("\nCadastrar Consulta: ");

        String nomeNutricionista;
        String nomePaciente;

        System.out.print("Insira o nome do Nutricionista: ");
        nomeNutricionista  = scanner.next();
        scanner.nextLine(); // Consumir nova linha

        System.out.print("Insira o nome do Paciente: ");
        nomePaciente  = scanner.next();
        scanner.nextLine(); // Consumir nova linha

        Paciente existePaciente = GerenciamentoPacientes.buscarPacientePorNome(nomePaciente);

        Nutricionista existeNutricionista =  GerenciamentoNutricionistas.buscarNutricionistaPorNome(nomeNutricionista);

        if (existePaciente == null || existeNutricionista == null){
            System.out.println("\nPaciente ou Nutricionista inexistentes, verifique os dados digitados ou cadastre os elementos faltante.");
            return;
        }

        LocalDateTime dataConsulta;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        while (true) {
            try {
                System.out.print("Digite a data e horário no formato DD/MM/AAAA HH:MM - ");
                String dataHoraString = scanner.nextLine();
                dataConsulta = LocalDateTime.parse(dataHoraString, formatter);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Data e hora inválidas. Por favor, insira no formato correto (DD/MM/AAAA HH:MM).");
            }
        }


        boolean consultaRealizada = false;

        Consulta novaConsulta = new Consulta(nomeNutricionista, nomePaciente, dataConsulta, consultaRealizada);

        GerenciamentoConsultas.adicionarConsulta(novaConsulta);

    }

    private static void listarFuncionarios() {
        System.out.println(GerenciamentoFuncionarios.listarFuncionarios());
        System.out.println(GerenciamentoNutricionistas.listarNutricionistas());
    }

    private static void listarConsultas() {
        System.out.println(GerenciamentoConsultas.listarConsultas());
    }

    private static void realizarConsulta() {
        System.out.println("\nRealizar Consulta");
        System.out.print("Insira o ID da Consulta: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha
        GerenciamentoConsultas.realizarConsulta(id);
    }


}

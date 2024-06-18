package repositorio;

import java.util.ArrayList;
import java.util.List;
import entidades.Funcionario;

public class GerenciamentoFuncionarios {
    private static List<Funcionario> funcionarios = new ArrayList<>();

    public static String listarFuncionarios() {
        if (!funcionarios.isEmpty()) {
            System.out.println("==================== Funcionários ====================");
            for (Funcionario funcionario : funcionarios) {
                return funcionario.toString();
            }
        }
        return "\nNão há Funcionários Cadastrados";
    }

    public static Funcionario buscarFuncionarioPorId(int id) {
        for (Funcionario f : funcionarios) {
            if (f.getId() == id) {
                return f;
            }
        }
        return null;
    }

    public static void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public static boolean removerFuncionario(int id) {
        return funcionarios.removeIf(f -> f.getId() == id);
    }

    public static boolean alterarFuncionario(int id, Funcionario funcionarioAlterado) {
        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getId() == id) {
                funcionarios.set(i, funcionarioAlterado);
                return true;
            }
        }
        return false;
    }
}

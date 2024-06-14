package repositorio;

import java.util.ArrayList;
import java.util.List;
import entidades.Funcionario;

public class GerenciamentoFuncionarios {
    private static List<Funcionario> funcionarios = new ArrayList<>();

    public static List<Funcionario> listarFuncionario() {
        return new ArrayList<>(funcionarios);
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

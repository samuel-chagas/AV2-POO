package q2_samuelchagas;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class sistema {
	private static final String arquivoDeDados  = "C:\\Users\\SAMUEL\\Documents\\java\\AV2_SamuelChagas\\src\\q2_samuelchagas\\usuarios.txt";
	private Map<String, String> baseDeDados;	

	public sistema() {
        baseDeDados = caregarBaseDeDados();
    }

    public void registrarUsuario(String usuario, String senha) {
    	baseDeDados.put(usuario, senha);
    	salvaUsuario();
    }

    public boolean login(String usuario, String senha) {
        String salvarSenha = baseDeDados.get(usuario);
        return salvarSenha != null && salvarSenha.equals(senha);
    }

    private void salvaUsuario() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(arquivoDeDados))) {
            for (Map.Entry<String, String> entry : baseDeDados.entrySet()) {
                writer.println(entry.getKey() + ":" + entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Map<String, String> caregarBaseDeDados() {
        Map<String, String> database = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivoDeDados))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] parts = linha.split(":");
                if (parts.length == 2) {
                    String nomeUsuario = parts[0];
                    String senha = parts[1];
                    database.put(nomeUsuario, senha);
                }
            }
        } catch (IOException e) {
                    }
        return database;
    }

    public static void main(String[] args) {
        sistema loginSystem = new sistema();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Registrar");
            System.out.println("2 - Fazer login");
            System.out.println("3 - Sair");
            int escolha = scanner.nextInt();

            if (escolha == 1) {
                System.out.print("usuário: ");
                String usuario = scanner.next();
                System.out.print("senha: ");
                String senha = scanner.next();
                loginSystem.registrarUsuario(usuario, senha);
                System.out.println("Usuário registrado com sucesso.");
            } else if (escolha == 2) {
                System.out.print(" usuário: ");
                String usuario = scanner.next();
                System.out.print("senha: ");
                String senha = scanner.next();

                if (loginSystem.login(usuario, senha)) {
                    System.out.println("SUCESSO");
                } else {
                    System.out.println("FRACASSO");
                }
            } else if (escolha == 3) {
                break;
            }
        }

        scanner.close();
    }
}




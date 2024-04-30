package com.mycompany.logiu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserInfo {

    private static UserInfo instance;
    private List<HashMap<String, String>> usuarios;
    
    private UserInfo() {
    
        this.usuarios = carregarUsuariosDoArquivo();
       
    }

    

    public static UserInfo getInstance() {
        if (instance == null) {
            instance = new UserInfo();
        }
        return instance;
    }

    public void adicionarUsuario(String nome, String cpf, String email, String dataNascimento, String peso, String altura, String senha) {
        HashMap<String, String> usuarioInfo = new HashMap<>();
        usuarioInfo.put("Nome", nome);
        usuarioInfo.put("CPF", cpf);
        usuarioInfo.put("Email", email);
        usuarioInfo.put("DataNascimento", dataNascimento);
        usuarioInfo.put("Peso", peso);
        usuarioInfo.put("Altura", altura);
        usuarioInfo.put("Senha", senha);

        usuarios.add(usuarioInfo);
        salvarUsuariosEmArquivo("usuarios.dat");
    }
    private List<HashMap<String, String>> carregarUsuariosDoArquivo() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("usuarios.dat"))) {
            return (List<HashMap<String, String>>) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("O arquivo de usuários ainda não existe. Será criado um novo.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao carregar os usuários do arquivo: " + e.getMessage());
        }
        return new ArrayList<>();
    }

    public List<HashMap<String, String>> getUsuarios() {
        return usuarios;
    }
    public void removerUsuarioPorNome(String nome) {
    usuarios.removeIf(usuario -> usuario.get("Nome").equalsIgnoreCase(nome));
}
    public void salvarUsuariosEmArquivo(String filePath) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            objectOutputStream.writeObject(usuarios);
            System.out.println("Usuários salvos com sucesso no arquivo: " + filePath);
        } catch (IOException e) {
            System.err.println("Erro ao salvar os usuários no arquivo: " + e.getMessage());
        }
    }
    public boolean verificarLogin(String email, String senha) {
        for (HashMap<String, String> usuario : usuarios) {
            if (usuario.get("Email").equals(email) && usuario.get("Senha").equals(senha)) {
                return true;
            }
        }
        return false;
    }
}




package com.mycompany.logiu;
import java.util.HashMap;
import java.util.Map;

public class Dependente {

    public Dependente(String nome1, String cpf1, String numero1) {
    }
    private static Map<String, Dependente> dependenteMap = new HashMap<>();
    private String nome;
    private String cpf;
    private String numero;

     public static Dependente criarDependente(String nome, String cpf, String numero) {

        if (dependenteMap.containsKey(cpf)) {
            System.out.println("CPF já existe. Por favor, insira um CPF único.");
            return null;
        }

        Dependente dependente = new Dependente(nome, cpf, numero);
        dependenteMap.put(cpf, dependente);
        return dependente;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNumero() {
        return numero;
    }
   
}

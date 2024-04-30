/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.logiu;

/**
 *
 * @author ledru
 */
public class Logiu {

    public static void main(String[] args) {
        UserInfo userInfo = UserInfo.getInstance();
        String filePath = "usuarios.dat";
        userInfo.adicionarUsuario("Alice", "123456", "alice@example.com", "2000-01-01", "70", "1.65", "senha123");
        userInfo.adicionarUsuario("Bob", "654321", "bob@example.com", "1995-05-15", "80", "1.75", "senha456"); 
        userInfo.salvarUsuariosEmArquivo(filePath);
    }
}

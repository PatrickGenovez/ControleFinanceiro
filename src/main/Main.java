package main;

import java.sql.Connection;

import Model.Menu;
import database.ConnectionFactory;

public class Main {
    public static void main(String[] args) {

        Connection conexao = ConnectionFactory.getConnection();
        System.out.println("Conexão com o MySQL realizada com sucesso!");


        Menu menu = new Menu();
        menu.iniciar();
    }
}
package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.Scanner;

public class connection {

        static Scanner teclado = new Scanner(System.in);
        static Scanner tecladoINT = new Scanner(System.in);

        public static Connection conexao() {
            Properties props = new Properties();
            props.setProperty("user", "postgres");
            props.setProperty("password ", "paradizo123");
            props.setProperty("ssl", "false");
            String URL_SERVIDOR = "jdbc:postgresql://localhost:5432/linketinder?currentSchema=public&user=postgres&password=paradizo123";


            try {
                Class.forName("org.postgresql.Driver");
                return DriverManager.getConnection(URL_SERVIDOR, props);

            } catch (Exception e) {
                e.printStackTrace();
                if (e instanceof ClassNotFoundException) {
                    System.err.println("Verifique o driver de conexão");
                } else {
                    System.err.println("Verifique se o servidor está ativo");
                }
                System.exit(-42);
                return null;
            }

        }
    }


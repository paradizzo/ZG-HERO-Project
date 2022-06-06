package com.model;

import com.connection.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InserirEmpresas {


    public static void registrarEmpresas(String nomeEmpresa, String emailEmpresa, String cnpjEmpresa, String paisEmpresa, String cepEmpresa, String descricaoEmpresa, String senhaEmpresa) {
        String INSERIR_EMPRESAS = "INSERT INTO empresas(nome, email, cnpj, pais, cep, senha) VALUES(?,?,?,?,?,?)";

        try {
            Connection conn = connection.conexao();

            PreparedStatement salvarEmpresa = conn.prepareStatement(INSERIR_EMPRESAS);
            salvarEmpresa.setString(1,nomeEmpresa);
            salvarEmpresa.setString(2,emailEmpresa);
            salvarEmpresa.setString(3,cnpjEmpresa);
            salvarEmpresa.setString(4,paisEmpresa);
            salvarEmpresa.setString(5,cepEmpresa);
            salvarEmpresa.setString(6,senhaEmpresa);

            salvarEmpresa.executeUpdate();
            salvarEmpresa.close();
            System.out.println("A empresa foi inserida com sucesso");
        } catch(Exception e) {
            e.printStackTrace();
            System.err.println("Erro inserindo empresa");
            System.exit(-42);
        }
    }
}


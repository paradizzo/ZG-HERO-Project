package com.model;

import com.connection.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import static com.model.Utils.listarCompetencias;

public class InserirCandidatos {


    public static void registrarCandidatos(String nomeCandidato, String sobrenome, String nascimentoCandidato, String emailCandidato, String cpfCandidato, String paisCandidato, String cepCandidato, String formacaoCandidato, String descricaoCandidato, String senhaCandidato, String angularCandidato, String javaCandidato, String groovyCandidato, String pythonCandidato, String typescriptCandidato) {

        // Declaração de variaveis
        String LAST_CANDIDATO = "SELECT MAX(id) FROM candidatos;";
        String INSERIR_CANDIDATOS = "INSERT INTO candidatos(nome, sobrenome, data_de_nascimento, email, cpf, pais, cep, descricao, senha) VALUES(?,?,?,?,?,?,?,?,?) ";
        ArrayList<String> arrayCompetencias = new ArrayList<String>();

        try {
            Connection conn = connection.conexao();
            PreparedStatement salvarCandidato = conn.prepareStatement(INSERIR_CANDIDATOS);
            salvarCandidato.setString(1,nomeCandidato);
            salvarCandidato.setString(2,sobrenome);
            try {
                DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
                java.sql.Date nascimentoCandidatoFormatado = new java.sql.Date(fmt.parse(nascimentoCandidato).getTime());

                salvarCandidato.setDate(3, nascimentoCandidatoFormatado);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            salvarCandidato.setString(4,emailCandidato);
            salvarCandidato.setString(5,cpfCandidato);
            salvarCandidato.setString(6,paisCandidato);
            salvarCandidato.setString(7,cepCandidato);
            salvarCandidato.setString(8,descricaoCandidato);
            salvarCandidato.setString(9,senhaCandidato);



            /* Inserção de competências */
            int ULTIMO_ID_INT = 0;
            PreparedStatement ultimoID = conn.prepareStatement(LAST_CANDIDATO);
            salvarCandidato.executeUpdate();
            ResultSet resUltimoID = ultimoID.executeQuery();
            String callerString = "INSERT INTO candidatos_has_competencias(candidatos_id, competencias_id) VALUES(?,?) ";
            while (resUltimoID.next()) {
                ULTIMO_ID_INT = resUltimoID.getInt(1);
            }

            competencias.listarCompetencias(ULTIMO_ID_INT, callerString, angularCandidato, javaCandidato, groovyCandidato, pythonCandidato, typescriptCandidato);
            String SELECIONAR_COMPETENCIAS = "SELECT * FROM candidatos_has_competencias WHERE candidatos_id =(SELECT max(candidatos_id) FROM candidatos_has_competencias )";
            PreparedStatement salvarCompetencias = conn.prepareStatement(SELECIONAR_COMPETENCIAS);
            ResultSet resCompetencias = salvarCompetencias.executeQuery();
            while (resCompetencias.next()) {
                String valorCompetencia = resCompetencias.getString(2);
                if (valorCompetencia.equals("1")) {
                    arrayCompetencias.add("Angular");
                }
                else if (valorCompetencia.equals("2")) {
                    arrayCompetencias.add("Java");
                }
                else if (valorCompetencia.equals("3")) {
                    arrayCompetencias.add("Groovy");
                }
                else if (valorCompetencia.equals("4")) {
                    arrayCompetencias.add("Python");
                } else {
                    arrayCompetencias.add("Typescript");
                }
            }
            String listString = String.join(", ", arrayCompetencias);
            String APLICADOR_COMPETENCIAS =  "UPDATE candidatos SET competencias=? WHERE ID = ?";
            PreparedStatement aplicarCompetencias = conn.prepareStatement(APLICADOR_COMPETENCIAS);
            aplicarCompetencias.setString(1, listString);
            aplicarCompetencias.setInt(2, ULTIMO_ID_INT);
            aplicarCompetencias.executeUpdate();

            ultimoID.close();
            salvarCandidato.close();
            aplicarCompetencias.close();
            System.out.println("O candidato foi inserido com sucesso");

        } catch(Exception e) {
            e.printStackTrace();
            System.err.println("Erro inserindo candidatos");
            System.exit(-42);
        }
    }
}


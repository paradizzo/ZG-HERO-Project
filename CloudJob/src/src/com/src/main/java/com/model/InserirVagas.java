package com.model;

import com.connection.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class InserirVagas {
    public static void registrarVagas(String nomeVaga, String localVaga, String estado, String descricaoVaga, String angularVaga, String javaVaga, String groovyVaga, String pythonVaga, String typescriptVaga) {
        String LAST_VAGA = "SELECT MAX(id) FROM vagas;";
        String EMPRESA_ID = "SELECT MAX(id) FROM empresas";
        String INSERIR_VAGAS = "INSERT INTO vagas(nome, descricao, estado, cidade, id_empresas) VALUES(?,?,?,?,?)";
        ArrayList<String> arrayCompetencias = new ArrayList<String>();
        try {
            Connection conn = connection.conexao();

            PreparedStatement salvarVaga = conn.prepareStatement(INSERIR_VAGAS);
            salvarVaga.setString(1,nomeVaga);
            salvarVaga.setString(2,descricaoVaga);
            salvarVaga.setString(3,estado);
            salvarVaga.setString(4,localVaga);
            PreparedStatement idEmpresa = conn.prepareStatement(EMPRESA_ID);
            ResultSet resIdEmpresa = idEmpresa.executeQuery();
            resIdEmpresa.next();
            int ULTIMO_ID_EMPRESA = resIdEmpresa.getInt(1);
            salvarVaga.setInt(5,ULTIMO_ID_EMPRESA);

            /* Inserção de competências */
            int ULTIMO_ID_INT = 0;
            PreparedStatement ultimoID = conn.prepareStatement(LAST_VAGA);
            salvarVaga.executeUpdate();
            ResultSet resUltimoID = ultimoID.executeQuery();
            String callerString = "INSERT INTO vagas_has_competencias(vagas_id, competencias_id) VALUES(?,?) ";
            while (resUltimoID.next()) {
                ULTIMO_ID_INT = resUltimoID.getInt(1);
            }
            competencias.listarCompetencias(ULTIMO_ID_INT, callerString, angularVaga, javaVaga, groovyVaga, pythonVaga, typescriptVaga);
            String SELECIONAR_COMPETENCIAS = "SELECT * FROM vagas_has_competencias WHERE vagas_id =(SELECT max(vagas_id) FROM vagas_has_competencias )";
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
            String APLICADOR_COMPETENCIAS =  "UPDATE vagas SET competencias=? WHERE ID = ?";
            PreparedStatement aplicarCompetencias = conn.prepareStatement(APLICADOR_COMPETENCIAS);
            aplicarCompetencias.setString(1, listString);
            aplicarCompetencias.setInt(2, ULTIMO_ID_INT);
            aplicarCompetencias.executeUpdate();

            salvarVaga.close();
            System.out.println("A vaga foi inserida com sucesso");

        } catch(Exception e) {
            e.printStackTrace();
            System.err.println("Erro inserindo vaga");
            System.exit(-42);
        }

    }
}

package com.model;

import com.connection.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class competencias {
    static void listarCompetencias(int ULTIMO_ID_INT, String callerString, String angularCandidato, String javaCandidato, String groovyCandidato, String pythonCandidato, String typescriptCandidato) {
        String BUSCAR_COMPETENCIAS = "SELECT * FROM competencias";
        String INSERIR_CANDIDATOS_HAS_COMPETENCIAS = callerString;
        try {
            Connection conn = connection.conexao();
            PreparedStatement competencias = conn.prepareStatement(BUSCAR_COMPETENCIAS, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            PreparedStatement salvarCandidatoHasCompetencias = conn.prepareStatement(INSERIR_CANDIDATOS_HAS_COMPETENCIAS);
            ResultSet resCompetencia = competencias.executeQuery();
            resCompetencia.last();
            resCompetencia.beforeFirst();
            if (angularCandidato != null && angularCandidato.equals("true")) {
                salvarCandidatoHasCompetencias.setInt(1,ULTIMO_ID_INT);
                salvarCandidatoHasCompetencias.setInt(2,1);
                salvarCandidatoHasCompetencias.executeUpdate();
            }
            if (javaCandidato != null && javaCandidato.equals("true")) {
                salvarCandidatoHasCompetencias.setInt(1,ULTIMO_ID_INT);
                salvarCandidatoHasCompetencias.setInt(2,2);
                salvarCandidatoHasCompetencias.executeUpdate();

            }
            if (groovyCandidato != null && groovyCandidato.equals("true")) {
                salvarCandidatoHasCompetencias.setInt(1,ULTIMO_ID_INT);
                salvarCandidatoHasCompetencias.setInt(2,3);
                salvarCandidatoHasCompetencias.executeUpdate();

            }
            if (pythonCandidato != null && pythonCandidato.equals("true")) {
                salvarCandidatoHasCompetencias.setInt(1,ULTIMO_ID_INT);
                salvarCandidatoHasCompetencias.setInt(2,4);
                salvarCandidatoHasCompetencias.executeUpdate();

                if (typescriptCandidato != null && typescriptCandidato.equals("true")) {
                    salvarCandidatoHasCompetencias.setInt(1,ULTIMO_ID_INT);
                    salvarCandidatoHasCompetencias.setInt(2,5);
                    salvarCandidatoHasCompetencias.executeUpdate();
                }
            }
        } catch(Exception e){
            e.printStackTrace();
            System.err.println("Erro buscando Competências");
            System.exit(-42);
        }
    }
}

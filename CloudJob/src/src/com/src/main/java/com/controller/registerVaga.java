package com.controller;


import com.model.InserirCandidatos;
import com.model.InserirVagas;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/registerVagas")
public class registerVaga extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h3>Vagas</h3>");
        System.out.println("ENTROU NO GET");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            String nomeVaga = request.getParameter("nomeVaga");
            String localVaga = request.getParameter("localVaga");
            String estado = request.getParameter("estado");
            String nivel = request.getParameter("nivel");
            String outsideWork = request.getParameter("outsideWork");
            String descricaoVaga = request.getParameter("descricaoVaga");
            String angularVaga = request.getParameter("angular");
            String javaVaga = request.getParameter("java");
            String groovyVaga = request.getParameter("groovy");
            String pythonVaga = request.getParameter("python");
            String typescriptVaga = request.getParameter("typescript");


            InserirVagas.registrarVagas(nomeVaga, localVaga, estado, descricaoVaga, angularVaga, javaVaga, groovyVaga, pythonVaga, typescriptVaga);

        }

    }


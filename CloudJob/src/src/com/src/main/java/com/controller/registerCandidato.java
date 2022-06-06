package com.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

import com.model.InserirCandidatos;

@WebServlet("/registerCandidatos")
public class registerCandidato extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h3>Candidato</h3>");
        System.out.println("ENTROU NO GET");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        System.out.println("ENTROU NO POST");
        // Procurei algumas bibliotecas para transformar uma String "JsonLike" em objeto Json ( achei Gson, JSONObject etc..), mas por algum motivo elas quebram a criação do artefato, então vou aproveitar que fiz um form aparentemente bem estruturado e usar ele pra completar essa parte. Tecnicamente eu ainda estou enviando por HTTP POST, então tamo junto, eventualmente vou pedir ajuda pro óraculo nessa questão. Vou deixar aqui um exemplo de "JsonLike" string que eu estava recebendo: "nomeSobrenome":"Lucas de Souza Paradizo","dataDeNascimento":"2022-05-13","email":"lucasparadizzo@gmail.com","CPF":"16777031723","País":"brasil","formacao":"213213213213","descricaoCandidato":"asdasd","password":"123213213","angular":"on","java":"on","groovy":"on","python":"on","typescript":"on"}

        // Durante a construção do projeto eu pensei em uma ideia, um trigger, uma parte do form escondida que identifica se o solicitante foi EMPRESA ou CANDIDATO.
        // TRIGGER de valor 2 é Candidato, o outro, empresa.
        // Assim eu posso ter um servlet inteiro que serve só pro cadastro.
        String trigger = request.getParameter("trigger");
        if(trigger.equals("2")){
            System.out.println("Entrou no trigger");
            String nomeCandidato = request.getParameter("nomeSobrenome");
            String nascimentoCandidato = request.getParameter("dataDeNascimento");
            String emailCandidato = request.getParameter("email");
            String CPFCandidato = request.getParameter("CPF");
            String paisCandidato = request.getParameter("pais");
            String cepCandidato = request.getParameter("cep");
            String formacaoCandidato = request.getParameter("formacao");
            String descricaoCandidato = request.getParameter("descricaoCandidato");
            String senhaCandidato = request.getParameter("password");
            String angularCandidato = request.getParameter("angular");
            String javaCandidato = request.getParameter("java");
            String groovyCandidato = request.getParameter("groovy");
            String pythonCandidato = request.getParameter("python");
            String typescriptCandidato = request.getParameter("typescript");

            String sobrenome = nomeCandidato.substring(nomeCandidato.lastIndexOf(" ")+1);
            if(nomeCandidato.contains(" ")){
                nomeCandidato= nomeCandidato.substring(0, nomeCandidato.indexOf(" "));
            }

            InserirCandidatos.registrarCandidatos(nomeCandidato, sobrenome, nascimentoCandidato, emailCandidato, CPFCandidato, paisCandidato, cepCandidato, formacaoCandidato, descricaoCandidato, senhaCandidato, angularCandidato, javaCandidato, groovyCandidato, pythonCandidato, typescriptCandidato);

        }
    }
}

package com.controller;

import com.model.InserirEmpresas;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/registerEmpresa")
public class registerEmpresa  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h3>Empresa</h3>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String trigger = request.getParameter("trigger");
        if (trigger.equals("1")) {
            String nomeEmpresa = request.getParameter("nomeSobrenomeEmpresa");
            String emailEmpresa = request.getParameter("emailEmpresa");
            String CNPJEmpresa = request.getParameter("CNPJ");
            String paisEmpresa = request.getParameter("paisEmpresa");
            String cepEmpresa = request.getParameter("CEPempresa");
            String descricaoEmpresa = request.getParameter("descricaoEmpresa");
            String senhaEmpresa = request.getParameter("passwordEmpresa");

            InserirEmpresas.registrarEmpresas(nomeEmpresa, emailEmpresa, CNPJEmpresa, paisEmpresa, cepEmpresa, descricaoEmpresa, senhaEmpresa);
        }

    }
}


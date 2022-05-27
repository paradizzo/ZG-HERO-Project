package com.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Properties;

@WebServlet("/candidatos")
public class DemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h3>Servlet ta pegando</h3>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String jsonStringfied = request.getParameter("formCandidato");
        // Procurei algumas bibliotecas para transformar uma String "JsonLike" em objeto Json ( achei Gson, JSONObject etc..), mas por algum motivo elas quebram a criação do artefato, então vou aproveitar que fiz um form aparentemente bem estruturado e usar ele pra completar essa parte. Tecnicamente eu ainda estou enviando por HTTP POST, então tamo junto, eventualmente vou pedir ajuda pro óraculo nessa questão. Vou deixar aqui um exemplo de "JsonLike" string que eu estava recebendo: "nomeSobrenome":"Lucas de Souza Paradizo","dataDeNascimento":"2022-05-13","email":"lucasparadizzo@gmail.com","CPF":"16777031723","País":"brasil","formacao":"213213213213","descricaoCandidato":"asdasd","password":"123213213","angular":"on","java":"on","groovy":"on","python":"on","typescript":"on"}

        // Durante a construção do projeto eu pensei em uma ideia, um trigger, uma parte do form escondida que identifica se o solicitante foi EMPRESA ou CANDIDATO.
        // TRIGGER de valor 2 é Candidato, o outro, empresa.
        // Assim eu posso ter um servlet inteiro que serve só pro cadastro.
        String trigger = request.getParameter("trigger");
        System.out.println(trigger);
        if(trigger.equals("2")){

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

            try {
                //Conexão
                Properties props = new Properties();
                props.setProperty("user", "postgres");
                props.setProperty("password ", "paradizo123");
                props.setProperty("ssl", "false");
                String URL_SERVIDOR = "jdbc:postgresql://localhost:5432/linketinder?currentSchema=public&user=postgres&password=paradizo123";
                Class.forName("org.postgresql.Driver");
                Connection con= DriverManager.getConnection(URL_SERVIDOR, props);


                //Declaração de Variaveis
                PreparedStatement ps=con.prepareStatement("INSERT INTO candidatos(nome, sobrenome, data_de_nascimento, email, cpf, pais, cep, descricao, senha) VALUES(?,?,?,?,?,?,?,?,?) ");
                PreparedStatement competencias = con.prepareStatement("SELECT * FROM competencias", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                PreparedStatement salvarCompetencias = con.prepareStatement("INSERT INTO candidatos_has_competencias(candidatos_id, competencias_id) VALUES(?,?) ");
                PreparedStatement ultimoID = con.prepareStatement("SELECT MAX(id) FROM candidatos;");
                ArrayList<String> arrayCompetencias = new ArrayList<String>();
                // Adiciona um candidato
                ps.setString(1,nomeCandidato);
                ps.setString(2,sobrenome);
                try {
                    DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
                    java.sql.Date nascimentoCandidatoFormatado = new java.sql.Date(fmt.parse(nascimentoCandidato).getTime());

                    ps.setDate(3, nascimentoCandidatoFormatado);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                ps.setString(4,emailCandidato);
                ps.setString(5,CPFCandidato);
                ps.setString(6,paisCandidato);
                ps.setString(7,cepCandidato);
                ps.setString(8,descricaoCandidato);
                ps.setString(9,senhaCandidato);
                ps.executeUpdate();

                //Verifica o candidato recem adicionado e insere suas competencias
                ResultSet resultadoUltimoID = ultimoID.executeQuery();
                ResultSet resCompetencia = competencias.executeQuery();
                int ULTIMO_ID_INT = 0;
                while (resultadoUltimoID.next()) {
                    ULTIMO_ID_INT = resultadoUltimoID.getInt(1);
                }
                resCompetencia.last();
                resCompetencia.beforeFirst();
                if (angularCandidato != null && angularCandidato.equals("true")) {
                    arrayCompetencias.add("Angular");
                    salvarCompetencias.setInt(1, ULTIMO_ID_INT);
                    salvarCompetencias.setInt(2,1);
                    salvarCompetencias.executeUpdate();
                }
                if (javaCandidato != null && javaCandidato.equals("true")) {
                    arrayCompetencias.add("Java");
                    salvarCompetencias.setInt(1, ULTIMO_ID_INT);
                    salvarCompetencias.setInt(2,2);
                    salvarCompetencias.executeUpdate();
                }
                if (groovyCandidato != null && groovyCandidato.equals("true")) {
                    arrayCompetencias.add("Groovy");
                    salvarCompetencias.setInt(1, ULTIMO_ID_INT);
                    salvarCompetencias.setInt(2,3);
                    salvarCompetencias.executeUpdate();
                }
                if (pythonCandidato != null && pythonCandidato.equals("true")) {
                    arrayCompetencias.add("Python");
                    salvarCompetencias.setInt(1, ULTIMO_ID_INT);
                    salvarCompetencias.setInt(2,4);
                    salvarCompetencias.executeUpdate();
                }
                if (typescriptCandidato != null && typescriptCandidato.equals("true")) {
                    arrayCompetencias.add("Typescript");
                    salvarCompetencias.setInt(1, ULTIMO_ID_INT);
                    salvarCompetencias.setInt(2,5);
                    salvarCompetencias.executeUpdate();
                }
                String listString = String.join(", ", arrayCompetencias);
                String APLICADOR_COMPETENCIAS =  "UPDATE candidatos SET competencias=? WHERE ID = ?";
                PreparedStatement aplicarCompetencias = con.prepareStatement(APLICADOR_COMPETENCIAS);
                aplicarCompetencias.setString(1, listString);
                aplicarCompetencias.setInt(2, ULTIMO_ID_INT);
                aplicarCompetencias.executeUpdate();

                ultimoID.close();
                salvarCompetencias.close();
                ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(trigger.equals("1")){

            String nomeEmpresa = request.getParameter("nomeSobrenomeEmpresa");
            String emailEmpresa = request.getParameter("emailEmpresa");
            String CNPJEmpresa = request.getParameter("CNPJ");
            String paisEmpresa = request.getParameter("paisEmpresa");
            String cepEmpresa = request.getParameter("CEPempresa");
            String descricaoEmpresa = request.getParameter("descricaoEmpresa");
            String senhaEmpresa = request.getParameter("passwordEmpresa");
            System.out.println(trigger);
            try {
                //Conexão
                Properties props = new Properties();
                props.setProperty("user", "postgres");
                props.setProperty("password ", "paradizo123");
                props.setProperty("ssl", "false");
                String URL_SERVIDOR = "jdbc:postgresql://localhost:5432/linketinder?currentSchema=public&user=postgres&password=paradizo123";
                Class.forName("org.postgresql.Driver");
                Connection con= DriverManager.getConnection(URL_SERVIDOR, props);


                // Declaração de variaveis
                String INSERIR_EMPRESAS = "INSERT INTO empresas(nome, email, cnpj, pais, cep, senha) VALUES(?,?,?,?,?,?)";


                PreparedStatement salvarEmpresa = con.prepareStatement(INSERIR_EMPRESAS);
                salvarEmpresa.setString(1,nomeEmpresa);
                salvarEmpresa.setString(2,emailEmpresa);
                salvarEmpresa.setString(3,CNPJEmpresa);
                salvarEmpresa.setString(4,paisEmpresa);
                salvarEmpresa.setString(5,cepEmpresa);
                salvarEmpresa.setString(6,senhaEmpresa);

                salvarEmpresa.executeUpdate();
                salvarEmpresa.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}

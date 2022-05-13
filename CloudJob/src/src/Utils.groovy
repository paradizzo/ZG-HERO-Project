package src
import java.sql.Connection
import java.sql.Date
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.text.SimpleDateFormat

class Utils {
    static  Scanner teclado = new Scanner(System.in)
    static Scanner tecladoINT = new Scanner(System.in)

    static Connection conexao() {
        Properties props = new Properties()
        props.setProperty("user", "postgres")
        props.setProperty("password ", "paradizo123")
        props.setProperty("ssl", "false")
        String URL_SERVIDOR = "jdbc:postgresql://localhost:5432/linketinder?currentSchema=public&user=postgres&password=paradizo123"


        try {
            Class.forName("org.postgresql.Driver")
            return DriverManager.getConnection(URL_SERVIDOR, props)

        } catch (Exception e) {
            e.printStackTrace()
            if (e instanceof ClassNotFoundException) {
                System.err.println("Verifique o driver de conexão")
            } else {
                System.err.println("Verifique se o servidor está ativo")
            }
            System.exit(-42)
            return null
        }

    }

    static void menuEmpresa() {
        System.out.println("===== ABA DE EMPRESA =====")
        System.out.println("1 - Registrar vaga ")
        System.out.println("2 - Listar Candidatos ")
        System.out.println("3 - Apagar vaga ")
        System.out.println("4 - Atualizar vaga ")
        System.out.println("5 - Retorno ")
        System.out.println("=================== ")
        int opcaoEmpresa = Integer.parseInt(teclado.nextLine())

        if (opcaoEmpresa == 1) {
            criaVaga()
            menuEmpresa()
        }
        else  if (opcaoEmpresa == 2 ) {
            listarCandidatos()
            menuEmpresa()
        }
        else if (opcaoEmpresa == 3) {
            apagarVaga()
            menuEmpresa()
        } else if (opcaoEmpresa == 5 ) {
            menu()
        }else if (opcaoEmpresa == 4 ) {
            atualizarVaga()
            menuEmpresa()
        }
        else  {
            System.out.println("INSIRA UMA OPÇAO VALIDA")
            menuEmpresa()
        }
    }

    static void menuCandidato() {
        System.out.println("====== ABA DE CANDIDATO ===== ")
        System.out.println("1 - Listar Vagas ")
        System.out.println("2 - Retorno  ")
        int opcaoCandidato = Integer.parseInt(teclado.nextLine())
        if ( opcaoCandidato == 1) {
            listarVagas()
            menuCandidato()
        }
        else  if (opcaoCandidato == 2) {
            menu()
            menuCandidato()
        } else {
            System.out.println("INSIRA UMA OPÇÃO VALIDA ")
            menuCandidato()

        }
    }

    static void menu() {
        System.out.println(" ========= MENU DE OPÇÕES =========")
        System.out.println("Selecione uma opção: ")
        System.out.println("1 - Entrar como candidato ")
        System.out.println("2 - Entrar como empresa ")
        System.out.println("3 - Registrar candidatos ")
        System.out.println("4 - Registrar empresas  ")
        System.out.println("0 - Fechar programa  ")
        int opcaoMenu = Integer.parseInt(teclado.nextLine())

        if (opcaoMenu == 1) {
            menuCandidato()

        }
        else if (opcaoMenu == 2) {
            menuEmpresa()
        }
        else if (opcaoMenu == 3 ){
            inserirCandidatos()
            menu()
        }
        else if (opcaoMenu == 4) {
            inserirEmpresas()
            menu()
        }else if(opcaoMenu == 0 ) {
            System.exit(-42)

        }
        else  {
            System.out.println("INSIRA UMA OPÇÃO VALIDA")
            menu()
        }
    }



    static void listarCompetencias(int ULTIMO_ID_INT , String callerString) {
        String BUSCAR_COMPETENCIAS = "SELECT * FROM competencias"
        String INSERIR_CANDIDATOS_HAS_COMPETENCIAS = callerString
        try {
            Connection conn = conexao()
            PreparedStatement competencias = conn.prepareStatement(BUSCAR_COMPETENCIAS, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
            PreparedStatement salvarCandidatoHasCompetencias = conn.prepareStatement(INSERIR_CANDIDATOS_HAS_COMPETENCIAS)
            ResultSet resCompetencia = competencias.executeQuery()
            resCompetencia.last()
            resCompetencia.beforeFirst()
            System.out.println("LISTANDO COMPETÊNCIAS:")
            System.out.println("----------------")
            while (resCompetencia.next() ) {
                System.out.println("ID: ${resCompetencia.getInt(1)}" + "- ${resCompetencia.getString(2)}")
            }
            println("Selecione o id da competência que se encaixa com a sua requisição, 0 fecha a seleção: ")
            int opcaoCompetencias = Integer.parseInt(teclado.nextLine())
            if (opcaoCompetencias == 1) {
                salvarCandidatoHasCompetencias.setInt(1,ULTIMO_ID_INT)
                salvarCandidatoHasCompetencias.setInt(2,1)
                salvarCandidatoHasCompetencias.executeUpdate()

                listarCompetencias(ULTIMO_ID_INT, callerString)
            }
            else if (opcaoCompetencias == 2) {
                salvarCandidatoHasCompetencias.setInt(1,ULTIMO_ID_INT)
                salvarCandidatoHasCompetencias.setInt(2,2)
                salvarCandidatoHasCompetencias.executeUpdate()

                listarCompetencias(ULTIMO_ID_INT, callerString)
            }
            else if (opcaoCompetencias == 3 ){
                salvarCandidatoHasCompetencias.setInt(1,ULTIMO_ID_INT)
                salvarCandidatoHasCompetencias.setInt(2,3)
                salvarCandidatoHasCompetencias.executeUpdate()

                listarCompetencias(ULTIMO_ID_INT, callerString)
            }
            else if (opcaoCompetencias == 4) {
                salvarCandidatoHasCompetencias.setInt(1,ULTIMO_ID_INT)
                salvarCandidatoHasCompetencias.setInt(2,4)
                salvarCandidatoHasCompetencias.executeUpdate()

                listarCompetencias(ULTIMO_ID_INT, callerString)

            }else if(opcaoCompetencias == 5 ) {
                salvarCandidatoHasCompetencias.setInt(1,ULTIMO_ID_INT)
                salvarCandidatoHasCompetencias.setInt(2,5)
                salvarCandidatoHasCompetencias.executeUpdate()

                listarCompetencias(ULTIMO_ID_INT, callerString)
            } else if(opcaoCompetencias == 0) {
                salvarCandidatoHasCompetencias.close()

            } else  {
                println("Insira uma opção válida")
                listarCompetencias(ULTIMO_ID_INT, callerString)
            }
        }
        catch(Exception e){
            e.printStackTrace()
            System.err.println("Erro buscando Competências")
            System.exit(-42)
        }
    }

    static void listarCandidatos() {
        String BUSCAR_CANDIDATOS = "SELECT * FROM candidatos"
        try {
            Connection conn = conexao()
            PreparedStatement candidatos = conn.prepareStatement(BUSCAR_CANDIDATOS, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
            ResultSet resCandidato = candidatos.executeQuery()
            resCandidato.last()
            int quantidadeCandidatos = resCandidato.getRow()
            resCandidato.beforeFirst()
            System.out.println("LISTANDO CANDIDATOS:")
            System.out.println("----------------")

            if (quantidadeCandidatos == 0) {
                System.out.println("Não existem candidatos")
            }
            while (resCandidato.next() ) {
                System.out.println("ID: " + resCandidato.getInt(1))
                System.out.println("Nome: " + resCandidato.getString(2))
                System.out.println("Competências: " + resCandidato.getString(11))
                System.out.println("----------------")
            }

        } catch(Exception e){
            e.printStackTrace()
            System.err.println("Erro buscando candidatos")
            System.exit(-42)
        }
    }

    static void inserirCandidatos() {
        System.out.println("Nome do candidato: ")
        String nomeCandidato = teclado.nextLine()
        System.out.println("Sobrenome do candidato: ")
        String sobrenomeCandidato = teclado.nextLine()
        System.out.println("Data de nascimento do candidato: dd-MM-YYYY ")
        String dataCandidato = teclado.nextLine()
        Date dataCandidatoFormatada = new java.sql.Date(new SimpleDateFormat("dd-mm-yyyy").parse(dataCandidato).getTime())
        System.out.println("Email do candidato: ")
        String emailCandidato = teclado.nextLine()
        System.out.println("CPF do candidato: ")
        String cpfCandidato = teclado.nextLine()
        System.out.println("pais do candidato: ")
        String paisCandidato = teclado.nextLine()
        System.out.println("cep do candidato: ")
        String cepCandidato = teclado.nextLine()
        System.out.println("descricao do candidato: ")
        String descricaoCandidato = teclado.nextLine()
        System.out.println("senha do candidato: ")
        String senhaCandidato = teclado.nextLine()

        // Declaração de variaveis
        String LAST_CANDIDATO = "SELECT MAX(id) FROM candidatos;"
        String INSERIR_CANDIDATOS = "INSERT INTO candidatos(nome, sobrenome, data_de_nascimento, email, cpf, pais, cep, descricao, senha) VALUES(?,?,?,?,?,?,?,?,?) "
        ArrayList arrayCompetencias = []
        try {
            Connection conn = conexao();
            PreparedStatement salvarCandidato = conn.prepareStatement(INSERIR_CANDIDATOS)
            salvarCandidato.setString(1,nomeCandidato)
            salvarCandidato.setString(2,sobrenomeCandidato)
            salvarCandidato.setDate(3, dataCandidatoFormatada)
            salvarCandidato.setString(4,emailCandidato)
            salvarCandidato.setString(5,cpfCandidato)
            salvarCandidato.setString(6,paisCandidato)
            salvarCandidato.setString(7,cepCandidato)
            salvarCandidato.setString(8,descricaoCandidato)
            salvarCandidato.setString(9,senhaCandidato)



            /* Inserção de competências */
            int ULTIMO_ID_INT = 0
            PreparedStatement ultimoID = conn.prepareStatement(LAST_CANDIDATO)
            salvarCandidato.executeUpdate()
            ResultSet resUltimoID = ultimoID.executeQuery()
            String callerString = "INSERT INTO candidatos_has_competencias(candidatos_id, competencias_id) VALUES(?,?) "
            while (resUltimoID.next()) {
                 ULTIMO_ID_INT = resUltimoID.getInt(1)
            }
            listarCompetencias(ULTIMO_ID_INT, callerString)
            String SELECIONAR_COMPETENCIAS = "SELECT * FROM candidatos_has_competencias WHERE candidatos_id =(SELECT max(candidatos_id) FROM candidatos_has_competencias )"
            PreparedStatement salvarCompetencias = conn.prepareStatement(SELECIONAR_COMPETENCIAS)
            ResultSet resCompetencias = salvarCompetencias.executeQuery()
            while (resCompetencias.next()) {
                int valorCompetencia = resCompetencias.getString(2).toInteger()
                if (valorCompetencia == 1) {
                    arrayCompetencias.add("Angular")
                }
                else if (valorCompetencia == 2) {
                    arrayCompetencias.add("Java")
                }
                else if (valorCompetencia == 3 ) {
                    arrayCompetencias.add("Groovy")
                }
                else if (valorCompetencia == 4 ) {
                    arrayCompetencias.add("Python")
                } else {
                    arrayCompetencias.add("Typescript")
                }
            }
            arrayCompetencias.join(", ")
            String APLICADOR_COMPETENCIAS = "UPDATE candidatos SET competencias='${arrayCompetencias}'WHERE ID = '${ULTIMO_ID_INT}'"
            PreparedStatement aplicarCompetencias = conn.prepareStatement(APLICADOR_COMPETENCIAS)
            aplicarCompetencias.executeUpdate()



            ultimoID.close()
            salvarCandidato.close()
            aplicarCompetencias.close()
            System.out.println("O candidato foi inserido com sucesso")

        } catch(Exception e) {
            e.printStackTrace()
            System.err.println("Erro inserindo candidatos")
            System.exit(-42)
        }

    }

    static void inserirEmpresas() {
        System.out.println("Nome da empresa: ")
        String nomeEmpresa = teclado.nextLine()
        System.out.println("Email da empresa: ")
        String emailEmpresa = teclado.nextLine()
        System.out.println("CNPJ empresa: ")
        String cnpjEmpresa = teclado.nextLine()
        System.out.println("Pais da empresa: ")
        String paisEmpresa = teclado.nextLine()
        System.out.println("CEP da empresa: ")
        String cepEmpresa = teclado.nextLine()
        System.out.println("Senha da empresa: ")
        String senhaEmpresa = teclado.nextLine()

        String INSERIR_EMPRESAS = "INSERT INTO empresas(nome, email, cnpj, pais, cep, senha) VALUES(?,?,?,?,?,?)"
        try {
            Connection conn = conexao();

            PreparedStatement salvarEmpresa = conn.prepareStatement(INSERIR_EMPRESAS)
            salvarEmpresa.setString(1,nomeEmpresa)
            salvarEmpresa.setString(2,emailEmpresa)
            salvarEmpresa.setString(3,cnpjEmpresa)
            salvarEmpresa.setString(4,paisEmpresa)
            salvarEmpresa.setString(5,cepEmpresa)
            salvarEmpresa.setString(6,senhaEmpresa)

            salvarEmpresa.executeUpdate()
            salvarEmpresa.close()
            System.out.println("A empresa foi inserida com sucesso")
        } catch(Exception e) {
            e.printStackTrace()
            System.err.println("Erro inserindo empresa")
            System.exit(-42)
        }

    }

    static void criaVaga() {
        System.out.println("Nome da vaga: ")
        String nomeVaga = teclado.nextLine()
        System.out.println("Descrição da vaga: ")
        String descricaoVaga = teclado.nextLine()
        System.out.println("Estado da vaga: ")
        String estadoVaga = teclado.nextLine()
        System.out.println("Cidade da vaga: ")
        String cidadeVaga = teclado.nextLine()
        listarEmpresas()
        System.out.println("Insira o ID da empresa que se relaciona à vaga: ")
        int idEmpresa = tecladoINT.nextInt()

        String LAST_VAGA = "SELECT MAX(id) FROM vagas;"
        String INSERIR_VAGAS = "INSERT INTO vagas(nome, descricao, estado, cidade, id_empresas) VALUES(?,?,?,?,?)"
        ArrayList arrayCompetencias = []
        try {
            Connection conn = conexao();

            PreparedStatement salvarVaga = conn.prepareStatement(INSERIR_VAGAS)
            salvarVaga.setString(1,nomeVaga)
            salvarVaga.setString(2,descricaoVaga)
            salvarVaga.setString(3,estadoVaga)
            salvarVaga.setString(4,cidadeVaga)
            salvarVaga.setInt(5,idEmpresa)

            /* Inserção de competências */
            int ULTIMO_ID_INT = 0
            PreparedStatement ultimoID = conn.prepareStatement(LAST_VAGA)
            salvarVaga.executeUpdate()
            ResultSet resUltimoID = ultimoID.executeQuery()
            String callerString = "INSERT INTO vagas_has_competencias(vagas_id, competencias_id) VALUES(?,?) "
            while (resUltimoID.next()) {
                ULTIMO_ID_INT = resUltimoID.getInt(1)
            }
            listarCompetencias(ULTIMO_ID_INT, callerString)
            String SELECIONAR_COMPETENCIAS = "SELECT * FROM vagas_has_competencias WHERE vagas_id =(SELECT max(vagas_id) FROM vagas_has_competencias )"
            PreparedStatement salvarCompetencias = conn.prepareStatement(SELECIONAR_COMPETENCIAS)
            ResultSet resCompetencias = salvarCompetencias.executeQuery()
            while (resCompetencias.next()) {
                int valorCompetencia = resCompetencias.getString(2).toInteger()
                if (valorCompetencia == 1) {
                    arrayCompetencias.add("Angular")
                }
                else if (valorCompetencia == 2) {
                    arrayCompetencias.add("Java")
                }
                else if (valorCompetencia == 3 ) {
                    arrayCompetencias.add("Groovy")
                }
                else if (valorCompetencia == 4 ) {
                    arrayCompetencias.add("Python")
                } else {
                    arrayCompetencias.add("Typescript")
                }
            }
            arrayCompetencias.join(", ")
            String APLICADOR_COMPETENCIAS = "UPDATE vagas SET competencias='${arrayCompetencias}'WHERE ID = '${ULTIMO_ID_INT}'"
            PreparedStatement aplicarCompetencias = conn.prepareStatement(APLICADOR_COMPETENCIAS)
            aplicarCompetencias.executeUpdate()

            salvarVaga.close()
            System.out.println("A vaga foi inserida com sucesso")

        } catch(Exception e) {
            e.printStackTrace()
            System.err.println("Erro inserindo vaga")
            System.exit(-42)
        }
    }

    static void listarVagas() {
        String BUSCAR_VAGAS = "SELECT * FROM vagas"
        try {
            Connection conn = conexao()
            PreparedStatement vagas = conn.prepareStatement(BUSCAR_VAGAS, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
            ResultSet resVagas = vagas.executeQuery()
            resVagas.last()
            int quantidadeVagas = resVagas.getRow()
            resVagas.beforeFirst()
            System.out.println("LISTANDO VAGAS:")
            System.out.println("----------------")

            if (quantidadeVagas == 0) {
                System.out.println("Não existem vagas no momento")
            }
            while (resVagas.next() ) {
                System.out.println("ID: " + resVagas.getInt(1))
                System.out.println("Nome: " + resVagas.getString(2))
                System.out.println("Competências: " + resVagas.getString(7))
                System.out.println("----------------")


            }

        } catch(Exception e){
            e.printStackTrace()
            System.err.println("Erro buscando vagas")
            System.exit(-42)
        }
    }

    static void listarEmpresas() {
        String BUSCAR_EMPRESAS = "SELECT * FROM empresas"
        try {
            Connection conn = conexao()
            PreparedStatement empresas = conn.prepareStatement(BUSCAR_EMPRESAS, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
            ResultSet resEmpresas = empresas.executeQuery()
            resEmpresas.last()
            int quantidadeEmpresas = resEmpresas.getRow()
            resEmpresas.beforeFirst()
            System.out.println("LISTANDO EMPRESAS:")
            System.out.println("----------------")

            if (quantidadeEmpresas == 0) {
                System.out.println("Não existem empresas no momento")
            }
            while (resEmpresas.next() ) {
                System.out.println("ID: " + resEmpresas.getInt(1))
                System.out.println("Nome: " + resEmpresas.getString(2))
                System.out.println("----------------")
            }

        } catch(Exception e){
            e.printStackTrace()
            System.err.println("Erro buscando empresas")
            System.exit(-42)
        }
    }


    static void apagarVaga(){
        listarVagas()
        String DELETAR_VAGA  = "DELETE FROM vagas WHERE id=?"
        String BUSCA_ID_VAGA = "SELECT * FROM vagas WHERE id=?"
        System.out.println("Informe o id da vaga: ")
        int idVaga = tecladoINT.nextInt()
        String DELETAR_PARENTES = "DELETE  FROM vagas_has_competencias WHERE vagas_id = ${idVaga}"
        try {
            Connection conn = conexao()
            PreparedStatement vagas = conn.prepareStatement(BUSCA_ID_VAGA,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
            PreparedStatement deletarParente = conn.prepareStatement(DELETAR_PARENTES)
            vagas.setInt(1, idVaga)
            ResultSet resDeleteVaga = vagas.executeQuery()
            resDeleteVaga.last()
            resDeleteVaga.beforeFirst()

            while (resDeleteVaga.next()){
                PreparedStatement del = conn.prepareStatement(DELETAR_VAGA)
                del.setInt(1,idVaga)
                deletarParente.executeUpdate()
                del.executeUpdate()
                deletarParente.close()
                del.close()
                System.out.println("A vaga foi deletada")
            }
            if (resDeleteVaga.next() ==! false) {
                System.out.println("A VAGA NÃO FOI ENCONTRADA")
            }
        } catch(Exception e) {
            e.printStackTrace()
            System.err.println("Erro ao deletar vaga")
            System.exit(-42)
        }
    }


    static void atualizarVaga() {
        listarVagas()
        System.out.println("Digite o ID da vaga:")
        int idEmpresa = tecladoINT.nextInt()
        int idVaga = idEmpresa
        String BUSCAR_ID_VAGA = "SELECT * FROM vagas WHERE id=?"
        String DELETAR_PARENTES = "DELETE  FROM vagas_has_competencias WHERE vagas_id = ${idVaga}"
        ArrayList arrayCompetencias = []
        try{
            Connection conn = conexao()
            PreparedStatement vaga = conn.prepareStatement(BUSCAR_ID_VAGA, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
            vaga.setInt(1, idEmpresa)
            ResultSet resVaga = vaga.executeQuery()
            resVaga.last()
            resVaga.beforeFirst()
            while (resVaga .next()) {
                System.out.println("Nome da vaga: ")
                String nomeVaga = teclado.nextLine()
                System.out.println("Descrição da vaga: ")
                String descricaoVaga = teclado.nextLine()
                System.out.println("Estado da vaga: ")
                String estadoVaga = teclado.nextLine()
                System.out.println("Cidade da vaga: ")
                String cidadeVaga = teclado.nextLine()
                listarEmpresas()
                System.out.println("Insira o ID da empresa que se relaciona à vaga: ")
                idEmpresa = tecladoINT.nextInt()

                PreparedStatement deletarParente = conn.prepareStatement(DELETAR_PARENTES)
                deletarParente.executeUpdate()
                deletarParente.close()
                String callerString = "INSERT INTO vagas_has_competencias(vagas_id, competencias_id) VALUES(?,?) "
                listarCompetencias(idVaga, callerString)
                String SELECIONAR_COMPETENCIAS = "SELECT * FROM vagas_has_competencias WHERE vagas_id =(SELECT max(vagas_id) FROM vagas_has_competencias )"
                PreparedStatement salvarCompetencias = conn.prepareStatement(SELECIONAR_COMPETENCIAS)
                ResultSet resCompetencias = salvarCompetencias.executeQuery()
                while (resCompetencias.next()) {
                    int valorCompetencia = resCompetencias.getString(2).toInteger()
                    if (valorCompetencia == 1) {
                        arrayCompetencias.add("Angular")
                    }
                    else if (valorCompetencia == 2) {
                        arrayCompetencias.add("Java")
                    }
                    else if (valorCompetencia == 3 ) {
                        arrayCompetencias.add("Groovy")
                    }
                    else if (valorCompetencia == 4 ) {
                        arrayCompetencias.add("Python")
                    } else {
                        arrayCompetencias.add("Typescript")
                    }
                }
                arrayCompetencias.join(", ")
                String APLICADOR_COMPETENCIAS = "UPDATE vagas SET competencias='${arrayCompetencias}'WHERE ID = '${idVaga}'"
                PreparedStatement aplicarCompetencias = conn.prepareStatement(APLICADOR_COMPETENCIAS)
                aplicarCompetencias.executeUpdate()

                String ATUALIZAR_VAGA = "UPDATE vagas SET nome=?, descricao=?, estado=?, cidade=?, id_empresas=? WHERE ID=?"
                PreparedStatement update_vaga = conn.prepareStatement(ATUALIZAR_VAGA)
                update_vaga.setString(1,nomeVaga)
                update_vaga.setString(2,descricaoVaga)
                update_vaga.setString(3,estadoVaga)
                update_vaga.setString(4,cidadeVaga)
                update_vaga.setInt(5,idEmpresa)
                update_vaga.setInt(6,idVaga)
                update_vaga.executeUpdate()
                update_vaga.close()
                System.out.println("A vaga foi atualizada")
            }
            if (resVaga.next() ==!  false) {
                System.out.println("Não existe vaga com o id informado")
            }

        }catch(Exception e) {
            e.printStackTrace()
            System.err.println("Não foi possivel atualizar a vaga")
            System.exit(-42)
        }
    }

}

package com.cloudjob.view
import com.cloudjob.model.Utils

class menus {
    static  Scanner teclado = new Scanner(System.in)
    static Scanner tecladoINT = new Scanner(System.in)

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
            Utils.criaVaga()
            menuEmpresa()
        }
        else  if (opcaoEmpresa == 2 ) {
            Utils.listarCandidatos()
            menuEmpresa()
        }
        else if (opcaoEmpresa == 3) {
            Utils.apagarVaga()
            menuEmpresa()
        } else if (opcaoEmpresa == 5 ) {
            menu()
        }else if (opcaoEmpresa == 4 ) {
            Utils.atualizarVaga()
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
            Utils.listarVagas()
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
            Utils.inserirCandidatos()
            menu()
        }
        else if (opcaoMenu == 4) {
            Utils.inserirEmpresas()
            menu()
        }else if(opcaoMenu == 0 ) {
            System.exit(-42)

        }
        else  {
            System.out.println("INSIRA UMA OPÇÃO VALIDA")
            menu()
        }
    }
}

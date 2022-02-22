import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import org.junit.Test;
import pessoas.CandidatosTest;
import pessoas.EmpresasTest;

public class AplicaçãoTest {

    @Test
    public void main() {
        //Listagem

        //Given
        ArrayList<CandidatosTest> arrayCandidatosTest = new ArrayList<CandidatosTest>();
        ArrayList<EmpresasTest> arrayEmpresasTest = new ArrayList<EmpresasTest>();
        ArrayList<String> tecnologiasTest = new ArrayList<>();


        //when



        Scanner scanner = new Scanner(System.in);
        Scanner scannerNum = new Scanner((System.in));


        System.out.println("Selecione uma opção, 0 fecha o programa: ");
        System.out.println("1.ADICIONAR EMPRESAS ");
        System.out.println("2.ADICIONAR CANDIDATOS ");
        System.out.println("3.LISTAR CANDIDATOS ");
        System.out.println("4.LISTAR EMPRESAS ");

        switch (1) {
            case 1:
                System.out.println("----------------");
                System.out.println("Digite o nome da empresa: ");
                String nomeEmpresa = "Empresa teste";
                System.out.println("Digite o email da empresa: ");
                String emailEmpresa = "EmailTesteEmpresa@";
                System.out.println("Digite o CNPJ da empresa: ");
                int CNPJempresa = 654654564;
                System.out.println("Digite o pais da empresa: ");
                String paisEmpresa = "Brasil";
                System.out.println("Digite o estado da empresa: ");
                String estadoEmpresa = "Espirito Santo";
                System.out.println("Digite o CEP da empresa: ");
                int CEPempresa = 29160778;
                System.out.println("Digite a descrição da empresa: ");
                String descriçãoEmpresa = "descrição teste";
                System.out.println("Digite as tecnologias procuradas: 0 encerra a seleção  ");
                int chDois;
                ArrayList<String> tecnologiasCandidatos = new ArrayList<>();

                    System.out.println("1.PYTHON");
                    System.out.println("2.ANGULAR");
                    System.out.println("3.METODOLOGIAS AGEIS");
                    System.out.println("4.JAVA");
                    System.out.println("5.GROOVY");
                    chDois = 1;

                    switch (chDois){
                        case 1:
                            tecnologiasCandidatos.add("python");

                        case 2:
                            tecnologiasCandidatos.add("Angular");

                        case 3:
                            tecnologiasCandidatos.add("Metodologias Ageis");

                        case 4:
                            tecnologiasCandidatos.add("Java");

                        case 5:
                            tecnologiasCandidatos.add("Groovy");
                    }


                arrayEmpresasTest.add(new EmpresasTest(nomeEmpresa, emailEmpresa, CNPJempresa, paisEmpresa, estadoEmpresa, CEPempresa,descriçãoEmpresa,tecnologiasCandidatos));
                System.out.println("Etapa 1 Completa");
                System.out.println("----------------");


            case 2:
                System.out.println("----------------");;
                System.out.println("Digite o nome do candidato: ");
                String nomeCandidato = "Candidato teste";
                System.out.println("Digite o email do candidato:  ");
                String emailCandidato = "Empresa teste";
                System.out.println("Digite o cpf do candidato: ");
                int cpfCandidato = 123;
                System.out.println("Digite a idade do candidato: ");
                int idadeCandidato = 123;
                System.out.println("Digite o estado do candidato: ");
                String estadoCandidato = "Espirito Santo";
                System.out.println("Digite o cep do candidato: ");
                int CEPcandidato = 123;
                System.out.println("Digite a descrição do candidato: ");
                String descriçãoCandidato = "Amar amar e amar";
                System.out.println("Selecione suas competências, 0 encerra a seleção  ");
                tecnologiasCandidatos = new ArrayList<String>();


                System.out.println("1.PYTHON");
                System.out.println("2.ANGULAR");
                System.out.println("3.METODOLOGIAS AGEIS");
                System.out.println("4.JAVA");
                System.out.println("5.GROOVY");
                chDois = 1;

                switch (chDois){
                    case 1:

                        tecnologiasCandidatos.add("Python");

                    case 2:
                        tecnologiasCandidatos.add("Angular");

                    case 3:
                        tecnologiasCandidatos.add("Metodologias Ageis");

                    case 4:
                        tecnologiasCandidatos.add("Java");

                    case 5:
                        tecnologiasCandidatos.add("Groovy");

                }


                arrayCandidatosTest.add(new CandidatosTest(nomeCandidato, emailCandidato, cpfCandidato, idadeCandidato, estadoCandidato, CEPcandidato, descriçãoCandidato, tecnologiasCandidatos));
                System.out.println("ETAPA 2 COMPLETA");
                ;

            case 3:
                System.out.println("----------------");

                Iterator i = arrayCandidatosTest.stream().iterator();
                while (i.hasNext()){
                    CandidatosTest e = (CandidatosTest) i.next();
                    System.out.println(e);
                    System.out.println("ETAPA 3 CONCLUIDA");

                }
                System.out.println("----------------");

            case 4:
                System.out.println("----------------");

                i = arrayEmpresasTest.stream().iterator();
                while (i.hasNext()){
                    EmpresasTest e = (EmpresasTest) i.next();
                    System.out.println(e);
                    System.out.println("ETAPA 4 COMPLETA");

                }
                System.out.println("----------------");




        }
    }
}



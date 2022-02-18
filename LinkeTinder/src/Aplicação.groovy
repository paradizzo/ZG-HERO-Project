

import pessoas.Candidatos
import pessoas.Empresas

class Aplicação {
    static void main(String[] args) {
        ArrayList<Candidatos> arrayCandidatos = new ArrayList<Candidatos>()
        ArrayList<Empresas> arrayEmpresas = new ArrayList<Empresas>()



        arrayCandidatos.add(new Candidatos("Mauricio Stelmacheck","Stelmacheck@gmail.com", 789456123, 20, "Espirito Santo", 29160882, "Gosto de viver", ["Python", "Java", "HTML","CSS", "alo"]))
        arrayCandidatos.add(new Candidatos("Rafaelus Minoxidilus","Minoxus@gmail.com", 7894654654, 25, "São Paulo", 29160878, "Gosto de cabelo", ["HTML", "CSS"]))
        arrayCandidatos.add(new Candidatos("Pedros Testosteronvz","carequinha@gmail.com", 789454653, 28, "Espirito Santo", 29156882, "Gosto de maça", ["Java", "Groovy", "Angular"]))
        arrayCandidatos.add(new Candidatos("Allans NeyMey","Neymey@gmail.com", 789565123, 18, "Rio de Janeiro", 556565682, "Gosto de escorregar", ["Python"]))
        arrayCandidatos.add(new Candidatos("Lucas Paradizos","paradizok@gmail.com", 7878886123, 20, "Bahia", 29550882, "Gosto de correr", ["Angular", "Java", "Groovy", "CSS", "HTML", "JavaScript"]))

        arrayEmpresas.add(new Empresas("Concrevit", "concrevix@gmail.com", 465465464654, "Brasil", "Mato grosso", 65465465132, "Somos uma empresa de concreto",["Metodologias ageis", "Python", "Java"]))
        arrayEmpresas.add(new Empresas("Cimentoss", "cimentoss@gmail.com", 465454544444654, "Brasil", "Bahia", 6556565165132, "Somos uma empresa de cimento", ["Metodologias ageis", "Python", "Java", "groovy"]))
        arrayEmpresas.add(new Empresas("Nervoso games", "Nervosogames@gmail.com", 7898798954, "Brasil", "São Paulo", 65454221165132, "Somos uma empresa de jogos", ["Metodologias ageis", "Python", "Java", "Angular", "HTML", "CSS"]))
        arrayEmpresas.add(new Empresas("Metallux", "metallux@gmail.com", 45422222264654, "Brasil", "Rio de Janeiro", 11111111132, "Somos uma empresa de metal",["Metodologias ageis", "Python", "Java"]))
        arrayEmpresas.add(new Empresas("DesaceleraZG", "DesaceleraZG@gmail.com", 123456789, "Brasil", "Goias", 123456789, "Somos uma empresa de carros", ["Metodologias ageis", "Python", "Java", "Git", "GitHub"]))





        Scanner scanner = new Scanner(System.in);
        Scanner scannerNum = new Scanner((System.in));
        int ch;
        do {
            println("Selecione uma opção, 0 fecha o programa: ")
            println("1. LISTAR CANDIDATOS ")
            println("2. LISTAR EMPRESAS ")

            ch = scannerNum.nextInt()
            switch (ch) {
                case 1:
                    System.out.println("----------------");

                    Iterator i = arrayCandidatos.stream().iterator();
                    while (i.hasNext()){
                        Candidatos e = (Candidatos) i.next();
                        System.out.println(e);

                    }
                    System.out.println("----------------");
                    break;
                case 2:
                    System.out.println("----------------");

                    Iterator i = arrayEmpresas.stream().iterator();
                    while (i.hasNext()){
                        Empresas e = (Empresas) i.next();
                        System.out.println(e);

                    }
                    System.out.println("----------------");
                    break;
            }

        }while (ch != 0 )
    }

}
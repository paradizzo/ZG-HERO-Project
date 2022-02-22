package pessoas;

import java.util.ArrayList;

public class EmpresasTest {
    String nomeEmpresa;
    String emailEmpresa;
    Long CNPJ;
    String paisEmpresa;
    String estadoEmpresa;
    Long CEPempresa;
    String descriçãoEmpresa;
    String tecnologias = String.valueOf(new ArrayList<TecnologiasTest>());

    @Override
    public String toString() {
        return "" +
                "Nome da Empresa= " + nomeEmpresa + '\'' +
                ", Email da Empresa= " + emailEmpresa + '\'' +
                ", CNPJ= " + CNPJ +
                ", Pais da Empresa= " + paisEmpresa + '\'' +
                ", Estado Empresa= " + estadoEmpresa + '\'' +
                ", CEP da empresa= " + CEPempresa +
                ", Descrição da Empresa= " + descriçãoEmpresa + '\'' +
                ", Tecnologias desejadas= " + tecnologias +
                '}';
    }

    public EmpresasTest(String nomeEmpresa, String emailEmpresa, int CNPJ, String paisEmpresa, String estadoEmpresa, int CEPempresa, String descriçãoEmpresa, ArrayList<String> tecnologias) {
        this.nomeEmpresa = nomeEmpresa;
        this.emailEmpresa = emailEmpresa;
        this.CNPJ = Long.valueOf(CNPJ);
        this.paisEmpresa = paisEmpresa;
        this.estadoEmpresa = estadoEmpresa;
        this.CEPempresa = Long.valueOf(CEPempresa);
        this.descriçãoEmpresa = descriçãoEmpresa;
        this.tecnologias = String.valueOf(tecnologias);
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getEmailEmpresa() {
        return emailEmpresa;
    }

    public void setEmailEmpresa(String emailEmpresa) {
        this.emailEmpresa = emailEmpresa;
    }

    public Long getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(Long CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getPaisEmpresa() {
        return paisEmpresa;
    }

    public void setPaisEmpresa(String paisEmpresa) {
        this.paisEmpresa = paisEmpresa;
    }

    public String getEstadoEmpresa() {
        return estadoEmpresa;
    }

    public void setEstadoEmpresa(String estadoEmpresa) {
        this.estadoEmpresa = estadoEmpresa;
    }

    public Long getCEPempresa() {
        return CEPempresa;
    }

    public void setCEPempresa(Long CEPempresa) {
        this.CEPempresa = CEPempresa;
    }

    public String getDescriçãoEmpresa() {
        return descriçãoEmpresa;
    }

    public void setDescriçãoEmpresa(String descriçãoEmpresa) {
        this.descriçãoEmpresa = descriçãoEmpresa;
    }

    public String getTecnologias() {
        return tecnologias;
    }

    public void setTecnologias(String tecnologias) {
        this.tecnologias = tecnologias;
    }
}
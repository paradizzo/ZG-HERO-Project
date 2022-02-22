package pessoas;

import java.util.ArrayList;

public class CandidatosTest {
    String nomeCandidato;
    String emailCandidato;
    long CPFCandidato;
    Integer idadeCandidato;
    String estadoCandidato;
    long CEPCandidato;
    String descriçãoCandidato;
    String tecnologias;

    @Override
    public String toString() {
        return "" +
                "Nome do Candidato= " + nomeCandidato + '\'' +
                ", Email do Candidato= " + emailCandidato + '\'' +
                ", CPF Candidato= " + CPFCandidato +
                ", Idade do Candidato= " + idadeCandidato +
                ", Estado do Candidato= " + estadoCandidato + '\'' +
                ", CEP do Candidato= " + CEPCandidato +
                ", Descrição do Candidato= " + descriçãoCandidato + '\'' +
                ", Tecnologias= " + tecnologias +
                '}';
    }

    public CandidatosTest(String nomeCandidato, String emailCandidato, long CPFCandidato, Integer idadeCandidato, String estadoCandidato, long CEPCandidato, String descriçãoCandidato, ArrayList<String> tecnologias) {
        this.nomeCandidato = nomeCandidato;
        this.emailCandidato = emailCandidato;
        this.CPFCandidato = CPFCandidato;
        this.idadeCandidato = idadeCandidato;
        this.estadoCandidato = estadoCandidato;
        this.CEPCandidato = CEPCandidato;
        this.descriçãoCandidato = descriçãoCandidato;
        this.tecnologias = String.valueOf(tecnologias);
    }

    public String getNomeCandidato() {
        return nomeCandidato;
    }

    public void setNomeCandidato(String nomeCandidato) {
        this.nomeCandidato = nomeCandidato;
    }

    public String getEmailCandidato() {
        return emailCandidato;
    }

    public void setEmailCandidato(String emailCandidato) {
        this.emailCandidato = emailCandidato;
    }

    public Long getCPFCandidato() {
        return CPFCandidato;
    }

    public void setCPFCandidato(Long CPFCandidato) {
        this.CPFCandidato = CPFCandidato;
    }

    public Integer getIdadeCandidato() {
        return idadeCandidato;
    }

    public void setIdadeCandidato(Integer idadeCandidato) {
        this.idadeCandidato = idadeCandidato;
    }

    public String getEstadoCandidato() {
        return estadoCandidato;
    }

    public void setEstadoCandidato(String estadoCandidato) {
        this.estadoCandidato = estadoCandidato;
    }

    public Long getCEPCandidato() {
        return CEPCandidato;
    }

    public void setCEPCandidato(Long CEPCandidato) {
        this.CEPCandidato = CEPCandidato;
    }

    public String getDescriçãoCandidato() {
        return descriçãoCandidato;
    }

    public void setDescriçãoCandidato(String descriçãoCandidato) {
        this.descriçãoCandidato = descriçãoCandidato;
    }

    public String getTecnologias() {
        return tecnologias;
    }

    public void setTecnologias(String tecnologias) {
        this.tecnologias = tecnologias;
    }
}
package pessoas

class Candidatos {
    String nomeCandidato
    String emailCandidato
    Long CPFCandidato
    Integer idadeCandidato
    String estadoCandidato
    Long CEPCandidato
    String descriçãoCandidato
    ArrayList <String> tecnologias = new ArrayList<String>()

    Candidatos(String nomeCandidato, String emailCandidato, Long CPFCandidato, Integer idadeCandidato, String estadoCandidato, Long CEPCandidato, String descriçãoCandidato, ArrayList<String> tecnologias) {
        this.nomeCandidato = nomeCandidato
        this.emailCandidato = emailCandidato
        this.CPFCandidato = CPFCandidato
        this.idadeCandidato = idadeCandidato
        this.estadoCandidato = estadoCandidato
        this.CEPCandidato = CEPCandidato
        this.descriçãoCandidato = descriçãoCandidato
        this.tecnologias = tecnologias
    }

    String getNomeCandidato() {
        return nomeCandidato
    }

    void setNomeCandidato(String nomeCandidato) {
        this.nomeCandidato = nomeCandidato
    }

    String getEmailCandidato() {
        return emailCandidato
    }

    void setEmailCandidato(String emailCandidato) {
        this.emailCandidato = emailCandidato
    }

    Long getCPFCandidato() {
        return CPFCandidato
    }

    void setCPFCandidato(Long CPFCandidato) {
        this.CPFCandidato = CPFCandidato
    }

    Integer getIdadeCandidato() {
        return idadeCandidato
    }

    void setIdadeCandidato(Integer idadeCandidato) {
        this.idadeCandidato = idadeCandidato
    }

    String getEstadoCandidato() {
        return estadoCandidato
    }

    void setEstadoCandidato(String estadoCandidato) {
        this.estadoCandidato = estadoCandidato
    }

    Long getCEPCandidato() {
        return CEPCandidato
    }

    void setCEPCandidato(Long CEPCandidato) {
        this.CEPCandidato = CEPCandidato
    }

    String getDescriçãoCandidato() {
        return descriçãoCandidato
    }

    void setDescriçãoCandidato(String descriçãoCandidato) {
        this.descriçãoCandidato = descriçãoCandidato
    }

    ArrayList<String> getTecnologias() {
        return tecnologias
    }

    void setTecnologias(ArrayList<String> tecnologias) {
        this.tecnologias = tecnologias
    }


    @Override
    public String toString() {
        return "Candidato: " +
                "nome= " + nomeCandidato +
                ", email= " + emailCandidato +
                ", CPF= " + CPFCandidato +
                ", idade= " + idadeCandidato +
                ", estado= " + estadoCandidato +
                ", CEP= " + CEPCandidato +
                ", descrição= '" + descriçãoCandidato +
                ", tecnologias= " + tecnologias +
                '';
    }
}

package pessoas
//Lucas Paradizo



class Empresas {
    String nomeEmpresa
    String emailEmpresa
    Long CNPJ
    String paisEmpresa
    String estadoEmpresa
    Long CEPempresa
    String descriçãoEmpresa
    ArrayList<String> tecnologias = new ArrayList<String>()

    Empresas(String nomeEmpresa, String emailEmpresa, Long CNPJ, String paisEmpresa, String estadoEmpresa, Long CEPempresa, String descriçãoEmpresa, ArrayList<String> tecnologias) {
        this.nomeEmpresa = nomeEmpresa
        this.emailEmpresa = emailEmpresa
        this.CNPJ = CNPJ
        this.paisEmpresa = paisEmpresa
        this.estadoEmpresa = estadoEmpresa
        this.CEPempresa = CEPempresa
        this.descriçãoEmpresa = descriçãoEmpresa
        this.tecnologias = tecnologias
    }

    String getNomeEmpresa() {
        return nomeEmpresa
    }

    void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa
    }

    String getEmailEmpresa() {
        return emailEmpresa
    }

    void setEmailEmpresa(String emailEmpresa) {
        this.emailEmpresa = emailEmpresa
    }

    Long getCNPJ() {
        return CNPJ
    }

    void setCNPJ(Long CNPJ) {
        this.CNPJ = CNPJ
    }

    String getPaisEmpresa() {
        return paisEmpresa
    }

    void setPaisEmpresa(String paisEmpresa) {
        this.paisEmpresa = paisEmpresa
    }

    String getEstadoEmpresa() {
        return estadoEmpresa
    }

    void setEstadoEmpresa(String estadoEmpresa) {
        this.estadoEmpresa = estadoEmpresa
    }

    Long getCEPempresa() {
        return CEPempresa
    }

    void setCEPempresa(Long CEPempresa) {
        this.CEPempresa = CEPempresa
    }

    String getDescriçãoEmpresa() {
        return descriçãoEmpresa
    }

    void setDescriçãoEmpresa(String descriçãoEmpresa) {
        this.descriçãoEmpresa = descriçãoEmpresa
    }

    ArrayList<String> getTecnologias() {
        return tecnologias
    }

    void setTecnologias(ArrayList<String> tecnologias) {
        this.tecnologias = tecnologias
    }

    @Override
    public String toString() {
        return "Empresas: " +
                "nome da empresa= " + nomeEmpresa +
                ", email da empresa= " + emailEmpresa +
                ", CNPJ= " + CNPJ +
                ", pais= " + paisEmpresa +
                ", estado= " + estadoEmpresa +
                ", CEP= " + CEPempresa +
                ", descrição= " + descriçãoEmpresa +
                ", tecnologias procuradas= " + tecnologias +
                '';
    }
}

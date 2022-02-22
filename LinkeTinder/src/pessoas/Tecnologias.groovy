package pessoas

class Tecnologias {
    String primeiraTec
    String segundaTec
    String terceiraTec
    String quartaTec
    String quintaTec

    Tecnologias(String primeiraTec, String segundaTec, String terceiraTec, String quartaTec, String quintaTec) {
        this.primeiraTec = primeiraTec
        this.segundaTec = segundaTec
        this.terceiraTec = terceiraTec
        this.quartaTec = quartaTec
        this.quintaTec = quintaTec
    }

    String getPrimeiraTec() {
        return primeiraTec
    }

    void setPrimeiraTec(String primeiraTec) {
        this.primeiraTec = primeiraTec
    }

    String getSegundaTec() {
        return segundaTec
    }

    void setSegundaTec(String segundaTec) {
        this.segundaTec = segundaTec
    }

    String getTerceiraTec() {
        return terceiraTec
    }

    void setTerceiraTec(String terceiraTec) {
        this.terceiraTec = terceiraTec
    }

    String getQuartaTec() {
        return quartaTec
    }

    void setQuartaTec(String quartaTec) {
        this.quartaTec = quartaTec
    }

    String getQuintaTec() {
        return quintaTec
    }

    void setQuintaTec(String quintaTec) {
        this.quintaTec = quintaTec
    }

    @Override
    public String toString() {
        return "Tecnologias{" +
                "primeiraTec='" + primeiraTec + '\'' +
                ", segundaTec='" + segundaTec + '\'' +
                ", terceiraTec='" + terceiraTec + '\'' +
                ", quartaTec='" + quartaTec + '\'' +
                ", quintaTec='" + quintaTec + '\'' +
                '}';
    }
}

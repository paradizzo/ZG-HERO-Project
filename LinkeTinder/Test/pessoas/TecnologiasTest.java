package pessoas;

import static org.junit.Assert.*;

public class TecnologiasTest {
        String primeiraTec;
        String segundaTec;
        String terceiraTec;
        String quartaTec;
        String quintaTec;

    @Override
    public String toString() {
        return "TecnologiasTest{" +
                "primeiraTec='" + primeiraTec + '\'' +
                ", segundaTec='" + segundaTec + '\'' +
                ", terceiraTec='" + terceiraTec + '\'' +
                ", quartaTec='" + quartaTec + '\'' +
                ", quintaTec='" + quintaTec + '\'' +
                '}';
    }

    public String getPrimeiraTec() {
        return primeiraTec;
    }

    public void setPrimeiraTec(String primeiraTec) {
        this.primeiraTec = primeiraTec;
    }

    public String getSegundaTec() {
        return segundaTec;
    }

    public void setSegundaTec(String segundaTec) {
        this.segundaTec = segundaTec;
    }

    public String getTerceiraTec() {
        return terceiraTec;
    }

    public void setTerceiraTec(String terceiraTec) {
        this.terceiraTec = terceiraTec;
    }

    public String getQuartaTec() {
        return quartaTec;
    }

    public void setQuartaTec(String quartaTec) {
        this.quartaTec = quartaTec;
    }

    public String getQuintaTec() {
        return quintaTec;
    }

    public void setQuintaTec(String quintaTec) {
        this.quintaTec = quintaTec;
    }

    public TecnologiasTest(String primeiraTec, String segundaTec, String terceiraTec, String quartaTec, String quintaTec) {
        this.primeiraTec = primeiraTec;
        this.segundaTec = segundaTec;
        this.terceiraTec = terceiraTec;
        this.quartaTec = quartaTec;
        this.quintaTec = quintaTec;
    }
}
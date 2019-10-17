package com.jsonapp.doadoresamigos.gestaodoadores;

final class DadosSanguineos {
    private String fatorRh;
    private String tipoDeSangue;

    public DadosSanguineos(String fatorRh, String tipoDeSangue) {
        this.fatorRh = fatorRh;
        this.tipoDeSangue = tipoDeSangue;
    }

    public String getFatorRh() {
        return fatorRh;
    }

    public String getTipoDeSangue() {
        return tipoDeSangue;
    }
}

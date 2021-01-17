package com.clases;

import javax.swing.*; //Proporciona un conjunto de componentes "ligeros" (totalmente en lenguaje Java) que, en la mayor medida posible, funcionan igual en todas las plataformas.

public class Empresas {
    private String tipDoc;
    private String documento;
    private String representante;

    public Empresas() {
    }
    
    public String getTipDoc() {
        return tipDoc;
    }

    public void setTipDoc(String tipDoc) {
        this.tipDoc = tipDoc;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }
    
    public Empresas(String tipoDoc, String documento) {
        this.tipDoc = tipoDoc;
        this.documento = documento;
    }
}

package org.example;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
@Data
@Builder
public class DadosPlanilha {
    //Pegando os dadas da planilha
    String código;
    String categoria;
    String valor;
    String origem;
    String tipo;
    String obs;
    String ncm;
    String cfop;
    String cest;
    String cst;
    String pisC;
    String icms;
    String pisA;
    String cofinsC;
    String cofinsA;

   /* public DadosPlanilha(String codigo, String categoria, int valor, int origem, String tipo, String obs, int ncm, int cfop, int cest, int cst, int icms, int pisC, int pisA, int cofinsC, int cofinsA) {
        this.codigo = codigo;
        this.categoria = categoria;
        this.valor = valor;
        this.origem = origem;
        this.tipo = tipo;
        this.obs = obs;
        this.ncm = ncm;
        this.cfop = cfop;
        this.cest = cest;
        this.cst = cst;
        this.icms = icms;
        this.pisC = pisC;
        this.pisA = pisA;
        this.cofinsC = cofinsC;
        this.cofinsA = cofinsA;
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public int getValor() {
        return valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }
    public int getOrigem() {
        return origem;
    }
    public void setOrigem(int origem) {
        this.origem = origem;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getObs() {
        return obs;
    }
    public void setObs(String obs) {
        this.obs = obs;
    }
    public int getNcm() {
        return ncm;
    }
    public void setNcm(int ncm) {
        this.ncm = ncm;
    }
    public int getCfop() {
        return cfop;
    }
    public void setCfop(int cfop) {
        this.cfop = cfop;
    }
    public int getCest() {
        return cest;
    }
    public void setCest(int cest) {
        this.cest = cest;
    }
    public int getCst() {
        return cst;
    }
    public void setCst(int cst) {
        this.cst = cst;
    }
    public int getIcms() {
        return icms;
    }
    public void setIcms(int icms) {
        this.icms = icms;
    }
    public int getPisC() {
        return pisC;
    }
    public void setPisC(int pisC) {
        this.pisC = pisC;
    }
    public int getPisA() {
        return pisA;
    }
    public void setPisA(int pisA) {
        this.pisA = pisA;
    }
    public int getCofinsC() {
        return cofinsC;
    }
    public void setCofinsC(int cofinsC) {
        this.cofinsC = cofinsC;
    }
    public int getCofinsA() {
        return cofinsA;
    }
    public void setCofinsA(int cofinsA) {
        this.cofinsA = cofinsA;
    }*/
}

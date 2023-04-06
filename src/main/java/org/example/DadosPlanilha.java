package org.example;
import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class DadosPlanilha {
    //Pegando os dadas da planilha
    int codigo;
    String categoria;
    int valor;
    int origem;
    int tipo;
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
}

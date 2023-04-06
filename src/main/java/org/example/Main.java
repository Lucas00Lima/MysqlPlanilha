package org.example;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        PercorrerPlanilha percorrerPlanilha =  new PercorrerPlanilha();
        List<DadosPlanilha> dados = percorrerPlanilha.criar();
        percorrerPlanilha.imprimir(dados);
    }
}
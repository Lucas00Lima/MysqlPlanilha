package org.example;

import lombok.Cleanup;
import org.apache.commons.collections4.IteratorUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PercorrerPlanilha {
    public List<DadosPlanilha> criar() throws IOException {

        List<DadosPlanilha> dados = new ArrayList<>();

        //Recuperando o arquivo
        @Cleanup FileInputStream file = new FileInputStream("C:\\Users\\lukin\\OneDrive\\Área de Trabalho\\Nova pasta\\planilha1.xlsx");
        Workbook workbook = new XSSFWorkbook(file);

        //Setando a aba
        Sheet sheet = workbook.getSheetAt(0);

        //Setando as linhas e removendo o cabeçalho
        List<Row> rows = (List<Row>) toList(sheet.iterator());
        rows.remove(0);

        rows.forEach(row ->{
            //Setando as celulas
            List<Cell> cells = (List<Cell>) toList(row.cellIterator());
            DataFormatter formatter =  new DataFormatter();
            //Atribuindo os valores
            DadosPlanilha dado = DadosPlanilha.builder()
                .codigo(formatter.formatCellValue(cells.get(0)))
                .categoria(formatter.formatCellValue(cells.get(1)))
                .valor(formatter.formatCellValue(cells.get(2)))
                .origem(formatter.formatCellValue(cells.get(3)))
                .tipo(formatter.formatCellValue(cells.get(4)))
                .obs(formatter.formatCellValue(cells.get(5)))
                .ncm(formatter.formatCellValue(cells.get(6)))
                .cfop(formatter.formatCellValue(cells.get(7)))
                .cest(formatter.formatCellValue(cells.get(8)))
                .cst(formatter.formatCellValue(cells.get(9)))
                .icms(formatter.formatCellValue(cells.get(10)))
                .pisC(formatter.formatCellValue(cells.get(11)))
                .pisA(formatter.formatCellValue(cells.get(12)))
                .cofinsC(formatter.formatCellValue(cells.get(13)))
                .cofinsA(formatter.formatCellValue(cells.get(14)))
                .build();
                dados.add(dado);
        });
        return dados;
    }
    public List<?> toList(Iterator<?> iterator)
    {
        return IteratorUtils.toList(iterator);
    }
    //Percorre a array e imprime
    public void imprimir(List<DadosPlanilha> dado)
    {
        dado.forEach(System.out::println);
    }

    public static void main(String[] args) throws IOException {
        PercorrerPlanilha percorrerPlanilha = new PercorrerPlanilha();
        List<DadosPlanilha> dado = percorrerPlanilha.criar();
        percorrerPlanilha.imprimir(dado);
    }
}


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
        @Cleanup FileInputStream file = new FileInputStream("C:\\Users\\lukin\\OneDrive\\Área de Trabalho\\Nova Pasta\\planilha.xlsx");
        Workbook workbook = new XSSFWorkbook(file);

        //Setando a aba
        Sheet sheet = workbook.getSheetAt(0);

        //Setando as linhas
        List<Row> rows = (List<Row>) toList(sheet.iterator());

        int rowcount = sheet.getLastRowNum();
        System.out.println("Total Row " + rowcount);
/*
        for(int i=0;i<rowcount;i++) {
            String data0 = Cell .setCellType(CellType.NUMERIC);
            System.out.println("Test Data From Excel" + data0);
        }


*/

        rows.remove(0);
        rows.remove(1);
        rows.remove(2);

        rows.forEach(row ->{
            //Setando as celulas
            List<Cell> cells = (List<Cell>) toList(row.cellIterator());

            //Atribuindo os valores
            DadosPlanilha dado = DadosPlanilha.builder()
                    .código(String.valueOf(cells.get(0).getCellType()))
                    .categoria(String.valueOf(cells.get(1).getCellType()))
                    .valor(String.valueOf(cells.get(2).getCellType()))
                    .origem(String.valueOf(cells.get(3).getCellType()))
                    .tipo(String.valueOf(cells.get(4).getCellType()))
                    .obs(String.valueOf(cells.get(5).getCellType()))
                    .ncm(String.valueOf(cells.get(6).getCellType()))
                    .cfop(String.valueOf(cells.get(7).getCellType()))
                    .cest(String.valueOf(cells.get(8).getCellType()))
                    .cst(String.valueOf(cells.get(9).getCellType()))
                    .icms(String.valueOf(cells.get(10).getCellType()))
                    .pisA(String.valueOf(cells.get(11).getCellType()))
                    .pisC(String.valueOf(cells.get(12).getCellType()))
                    .cofinsC(String.valueOf(cells.get(13).getCellType()))
                    .cofinsA(String.valueOf(cells.get(14).getCellType()))
                    .build();
            dados.add(dado);
        });
        return dados;
    }
    public List<?> toList(Iterator<?> iterator) {
        return IteratorUtils.toList(iterator);
    }
    public void imprimir(List<DadosPlanilha> dado) {
        dado.forEach(System.out::println);
    }
}


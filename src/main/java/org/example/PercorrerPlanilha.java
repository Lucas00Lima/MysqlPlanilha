package org.example;

import lombok.Cleanup;
import org.apache.commons.collections4.IteratorUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
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
        @Cleanup FileInputStream file = new FileInputStream("LOCAL ARQUIVO");
        Workbook workbook = new XSSFWorkbook(file);

        //Setando a aba
        Sheet sheet = workbook.getSheetAt(0);

        //Setando as linhas e removendo o cabeçalho
        List<Row> rows = (List<Row>) toList(sheet.iterator());
        rows.remove(0);

        rows.forEach(row ->{
            //Setando as celulas
            List<Cell> cells = (List<Cell>) toList(row.cellIterator());

            //Atribuindo os valores
            DadosPlanilha dado = DadosPlanilha.builder()
                .codigo((int)cells.get(0).getNumericCellValue())
                .categoria(cells.get(1).getStringCellValue())
                .valor(Integer.parseInt(Integer.toString((int)cells.get(2).getNumericCellValue())))
                .origem((int)cells.get(3).getNumericCellValue())
                .tipo((int)cells.get(4).getNumericCellValue())
                .obs(cells.get(5).getStringCellValue())
                .ncm(cells.get(6).getStringCellValue())
                .cfop(cells.get(7).getStringCellValue())
                .cest(cells.get(8).getStringCellValue())
                .cst(cells.get(9).getStringCellValue())
                .icms(cells.get(10).getStringCellValue())
                .pisC(cells.get(11).getStringCellValue())
                .pisA(cells.get(12).getStringCellValue())
                .cofinsC(cells.get(13).getStringCellValue())
                .cofinsA(cells.get(14).getStringCellValue())
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
}



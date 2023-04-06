package org.example;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        String url = "jdbc:mysql://localhost:3306/db090";
        String user = "root";
        String pass = "@soma+";

        //Estabelece uma conexao com o mysql
        try (Connection conexao = DriverManager.getConnection(url, user, pass)) {
            //Comanda Mysql
            String sql = "INSERT INTO produtos (codigo,nome) VALUES (?,?)";
            PreparedStatement ps = conexao.prepareStatement(sql);

            //Driver Mysql
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Cria a conexão com a planilha e seleciona a primeira aba
            FileInputStream inputStream = new FileInputStream("C:\\Users\\lukin\\OneDrive\\Área de Trabalho\\Nova Pasta\\planilha.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(0);

            //Percorre toda a planilha e transfere os dados
            for (Row row : sheet) {
                Cell cell1 = row.getCell(0);
                Cell cell2 = row.getCell(1);
                ps.setInt(1, (int) cell1.getNumericCellValue());
                ps.setString(2, cell2.getStringCellValue());
                ps.executeUpdate();
            }
            System.out.println("Dados inserido");
        } catch (ClassCastException | ClassNotFoundException ex) {
            System.out.println("Erro de Conexão");
        }
    }
}

package Cyber_Cafe_Management.Server;

import static Cyber_Cafe_Management.DatabaseClass.Connection;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExportData {

    public static void main(String[] args) throws Exception {
        //connecting to the database
        Connection con = Connection();

        // Getting data from the tavke emp_tbl
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from tickettable");

        //Creating a work book
        XSSFWorkbook workbook = new XSSFWorkbook();

        //creating a Spread Sheets
        XSSFSheet spreadsheet = workbook.createSheet("Ticket db");
        XSSFRow row = spreadsheet.createRow(1);
        XSSFCell cell;

        cell = row.createCell(1);
        cell.setCellValue("Ticket ID");

        cell = row.createCell(2);
        cell.setCellValue("Ticket Login");

        cell = row.createCell(3);
        cell.setCellValue("Ticket Password");

        cell = row.createCell(4);
        cell.setCellValue("Ticket Minute");

        cell = row.createCell(5);
        cell.setCellValue("Ticket Price");

        int i = 2;

        while (rs.next()) {
            row = spreadsheet.createRow(i);

            cell = row.createCell(1);
            cell.setCellValue(rs.getString("TicketID"));

            cell = row.createCell(2);
            cell.setCellValue(rs.getString("TicketLogin"));

            cell = row.createCell(3);
            cell.setCellValue(rs.getString("TicketPassword"));

            cell = row.createCell(4);
            cell.setCellValue(rs.getString("TicketPeriod"));

            cell = row.createCell(5);
            cell.setCellValue(rs.getString("Price"));

            i++;

        }

        try (FileOutputStream out = new FileOutputStream(new File("D:\\xcell.xlsx"))) {
            workbook.write(out);
        }

        System.out.print("File created successfully");
    }
}

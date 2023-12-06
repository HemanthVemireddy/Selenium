package org.example.Selenium;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class XLWORKBOOK_Read {
    public static void main(String[] args) throws IOException {

        FileInputStream fs = new FileInputStream(".\\DataSet\\Hemanth.xlsx");


        //Creating Workbook
        XSSFWorkbook workbook = new XSSFWorkbook(fs);

        XSSFSheet sheet = workbook.getSheetAt(0);

        int totalrows = sheet.getLastRowNum();

        int column = sheet.getRow(1).getLastCellNum();

        for(int r =0; r<=totalrows;r++)
        {
            XSSFRow rows = sheet.getRow(r);
            for(int c = 0; c<=column; c++)
            {
                XSSFCell cell = rows.getCell(c);
                System.out.print("\t"+cell + "\t");
            }
            System.out.println();
        }

    }
}

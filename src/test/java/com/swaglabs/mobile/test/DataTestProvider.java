package com.swaglabs.mobile.test;

import org.testng.annotations.DataProvider;
import com.swaglabs.mobile.utils.ExcelUtil;

public class DataTestProvider {

    @DataProvider(name = "loginDataProvider")
    public Object[][] loginDataProvider() {

        String excelPath = "src/test/resources/DataTestProvider.xlsx";
        String sheetName = "Sheet1"; // ganti jika nama sheet berbeda

        ExcelUtil excel = new ExcelUtil(excelPath, sheetName);

        int rowCount = excel.getRowCount();
        int colCount = excel.getColCount(); // = 3 kolom

        Object[][] data = new Object[rowCount - 1][colCount];

        for (int i = 1; i < rowCount; i++) { // mulai dari row ke-1 (skip header)
            for (int j = 0; j < colCount; j++) {
                data[i - 1][j] = excel.getCellData(i, j);
            }
        }

        return data;
    }
}

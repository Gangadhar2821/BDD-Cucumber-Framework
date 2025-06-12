package cogmentoCRM.Web.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {
	private static final String EXCEL_FILE_PATH = "./testdata/Cogmento-CRM_Web.xlsx";

	public Map<String, String> getTestDataForMethod(String methodName) {
		List<Map<String, String>> dataList = getExcelDataAsList(EXCEL_FILE_PATH, methodName);
		if (dataList.isEmpty()) {
			throw new RuntimeException("No data found in Excel sheet for: " + methodName);
		}
		return dataList.get(0); // Return only first row
	}

	public static List<Map<String, String>> getExcelDataAsList(String filePath, String sheetName) {
		List<Map<String, String>> dataList = new ArrayList<>();

		try (FileInputStream fis = new FileInputStream(new File(filePath))) {
			Workbook workbook = WorkbookFactory.create(fis);
			Sheet sheet = workbook.getSheet(sheetName);
			if (sheet == null)
				throw new RuntimeException("Sheet not found: " + sheetName);

			Row headerRow = sheet.getRow(0);
			if (headerRow == null)
				throw new RuntimeException("Header row missing in sheet: " + sheetName);

			int colCount = headerRow.getLastCellNum();
			int rowCount = sheet.getPhysicalNumberOfRows();

			for (int i = 1; i < rowCount; i++) {
				Row row = sheet.getRow(i);
				if (row == null)
					continue;

				Map<String, String> rowMap = new LinkedHashMap<>();

				for (int j = 0; j < colCount; j++) {
					Cell headerCell = headerRow.getCell(j);
					Cell valueCell = row.getCell(j);

					String key = headerCell != null ? headerCell.getStringCellValue().trim() : "Column" + j;
					String value = valueCell != null ? getCellValueAsString(valueCell) : "";

					rowMap.put(key, value);
				}

				dataList.add(rowMap);
			}
		} catch (Exception e) {
			throw new RuntimeException("Error reading Excel data: " + e.getMessage());
		}

		return dataList;
	}

	private static String getCellValueAsString(Cell cell) {
		if (cell == null)
			return "";

		switch (cell.getCellType()) {
		case STRING:
			return cell.getStringCellValue();
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				return cell.getDateCellValue().toString();
			} else {
				double value = cell.getNumericCellValue();
				long longVal = (long) value;
				return (value == (double) longVal) ? String.valueOf(longVal) : String.valueOf(value);
			}
		case BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue());
		case BLANK:
		default:
			return "";
		}
	}
}

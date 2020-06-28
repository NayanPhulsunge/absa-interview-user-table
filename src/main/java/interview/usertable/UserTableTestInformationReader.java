package interview.usertable;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import interview.TestInformation;
import interview.TestInformationReader;
import jdk.internal.util.xml.impl.Input;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class UserTableTestInformationReader implements TestInformationReader {

	private Properties properties;
	private String testName;

	@Override
	public String getTestName() {
		return testName;
	}


	public UserTableTestInformationReader() {
		properties = new Properties();
		properties.setProperty("keywordSheet","Absa2_KeywordSheetForTestCases.xlsx");
		properties.setProperty("dataSheet","Absa2_DataSheet.xlsx");
	}

	@Override
	public TestInformation readData() throws IOException
	{
		XSSFSheet testCaseKeywordSheet = getWorksheet(properties.getProperty("keywordSheet"), "Sheet1");
		XSSFSheet testCaseDataSheet = getWorksheet(properties.getProperty("dataSheet"), "Sheet1");
		List<HashMap<String, String>> testDataMaps = loadTestData(testCaseDataSheet);
		List<String> testKeywords = loadTestSteps(testCaseKeywordSheet);
		return new TestInformation(testDataMaps, testKeywords, UserTable.FIRST_NAME);
	}

	private List<String> loadTestSteps(XSSFSheet testCaseKeywordSheet) {
		List<String> testKeywords = new ArrayList<>();
		for (int i = 1; i < testCaseKeywordSheet.getLastRowNum(); i++) {
			testName = testCaseKeywordSheet.getRow(i).getCell(3).toString();
			testKeywords.add(testCaseKeywordSheet.getRow(i).getCell(2).toString());
		}
		return testKeywords;
	}

	private XSSFSheet getWorksheet(String workbookName, String sheetName) throws IOException {
		InputStream stream= ClassLoader.getSystemResourceAsStream(workbookName);
		XSSFWorkbook book=new XSSFWorkbook(stream);
		return book.getSheet(sheetName);
	}

	private List<HashMap<String, String>> loadTestData(XSSFSheet testCaseDataSheet) {
		List<HashMap<String, String>> dataMaps = new ArrayList<>();
		for (int i = 1; i < testCaseDataSheet.getLastRowNum(); i++) {
			HashMap<String, String> map = new HashMap<>();
			map.put(UserTable.FIRST_NAME, testCaseDataSheet.getRow(i).getCell(0).toString());
			map.put(UserTable.LAST_NAME, testCaseDataSheet.getRow(i).getCell(1).toString());
			map.put(UserTable.USER_NAME, testCaseDataSheet.getRow(i).getCell(2).toString());
			map.put(UserTable.PASSWORD, testCaseDataSheet.getRow(i).getCell(3).toString());
			map.put(UserTable.CUSTOMER, testCaseDataSheet.getRow(i).getCell(4).toString());
			map.put(UserTable.ROLE, testCaseDataSheet.getRow(i).getCell(5).toString());
			map.put(UserTable.EMAIL, testCaseDataSheet.getRow(i).getCell(6).toString());
			map.put(UserTable.CELL, testCaseDataSheet.getRow(i).getCell(7).toString());
			dataMaps.add(map);
		}
		return dataMaps;
	}
}



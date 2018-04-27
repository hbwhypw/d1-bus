package com.tmtc.utils;

import com.tmtc.po.User;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Creater: hbwhypw Date: 2015/8/26 18:18 Function:
 */
public class ReadExcel {
	/**
	 * �����ṩ��ȡexcel �ķ���
	 */
	public static List<List<Object>> readExcel(File file) throws IOException {
		String fileName = file.getName();
		String extension = fileName.lastIndexOf(".") == -1 ? "" : fileName.substring(fileName.lastIndexOf(".") + 1);
		if ("xls".equals(extension)) {
			return read2003Excel(file);
		} else if ("xlsx".equals(extension)) {
			return read2007Excel(file);
		} else if ("txt".equals(extension)) {
			return readTxt(file);
		} else {
			throw new IOException("文件格式错误！");
		}
	}

	private static List<List<Object>> readTxt(File file) throws IOException {
		List<List<Object>> list = new LinkedList<List<Object>>();
		BufferedReader bufferedReader = null;
		try {
			if (file.isFile() && file.exists()) { // 判断文件是否存在
				bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
				String lineTxt = null;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					String[] lineTxtArr = lineTxt.split("\t");
					List<Object> lineList = new ArrayList<Object>();
					for (String s : lineTxtArr) {
						lineList.add(s);
					}
					list.add(lineList);
				}
			} else {
				System.out.println("找不到指定的文件");
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		} finally {
			if (null != bufferedReader) {
				bufferedReader.close();
				bufferedReader = null;
			}
		}
		return list;
	}

	/**
	 * ��ȡ office 2003 excel
	 *
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	private static List<List<Object>> read2003Excel(File file) throws IOException {
		List<List<Object>> list = new LinkedList<List<Object>>();
		FileInputStream fis = new FileInputStream(file);
		HSSFWorkbook hwb = new HSSFWorkbook(fis);
		HSSFSheet sheet = hwb.getSheetAt(0);
		Object value = null;
		HSSFRow row = null;
		HSSFCell cell = null;
		int counter = 0;
		// ������
		for (int i = sheet.getFirstRowNum(); counter < sheet.getPhysicalNumberOfRows(); i++) {
			row = sheet.getRow(i);
			if (row == null) {
				continue;
			} else {
				counter++;
			}
			List<Object> linked = new LinkedList<Object>();
			// ������
			for (int j = row.getFirstCellNum(); j <= row.getLastCellNum(); j++) {
				cell = row.getCell(j);
				if (cell == null) {
					value = "";
					linked.add(value);
					continue;
				}
				DecimalFormat df = new DecimalFormat("0");// ��ʽ�� number String
				// �ַ�
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// ��ʽ�������ַ�
				DecimalFormat nf = new DecimalFormat("0.00");// ��ʽ������
				switch (cell.getCellType()) {
				case XSSFCell.CELL_TYPE_STRING:
					// System.out.println(i + "��" + j + " �� is String type");
					value = cell.getStringCellValue();
					break;
				case XSSFCell.CELL_TYPE_NUMERIC:
					// System.out.println(i + "行" + j + " 列 is Number type ;
					// DateFormt:" + cell.getCellStyle().getDataFormatString());
					if ("@".equals(cell.getCellStyle().getDataFormatString())) {
						value = df.format(cell.getNumericCellValue());
					} else if ("General".equals(cell.getCellStyle().getDataFormatString())) {
						value = df.format(cell.getNumericCellValue());
					} else {
						value = sdf.format(HSSFDateUtil.getJavaDate(cell.getNumericCellValue()));
					}
					break;
				case XSSFCell.CELL_TYPE_BOOLEAN:
					// System.out.println(i + "��" + j + " �� is Boolean type");
					value = cell.getBooleanCellValue();
					break;
				case XSSFCell.CELL_TYPE_BLANK:
					// System.out.println(i + "��" + j + " �� is Blank type");
					value = "";
					break;
				default:
					// System.out.println(i + "��" + j + " �� is default type");
					value = cell.toString();
				}
				linked.add(value);
			}
			list.add(linked);
		}
		fis.close();
		return list;
	}

	/**
	 * ��ȡOffice 2007 excel
	 */
	private static List<List<Object>> read2007Excel(File file) throws IOException {
		List<List<Object>> list = new LinkedList<List<Object>>();
		// ���� XSSFWorkbook ����strPath �����ļ�·��
		XSSFWorkbook xwb = new XSSFWorkbook(new FileInputStream(file));
		// ��ȡ��һ�±������
		XSSFSheet sheet = xwb.getSheetAt(0);
		Object value = null;
		XSSFRow row = null;
		XSSFCell cell = null;
		int counter = 0;
		for (int i = sheet.getFirstRowNum(); counter < sheet.getPhysicalNumberOfRows(); i++) {
			row = sheet.getRow(i);
			if (row == null) {
				continue;
			} else {
				counter++;
			}
			List<Object> linked = new LinkedList<Object>();
			for (int j = row.getFirstCellNum(); j <= row.getLastCellNum(); j++) {
				cell = row.getCell(j);
				if (cell == null) {
					continue;
				}
				DecimalFormat df = new DecimalFormat("0");// ��ʽ�� number String
				// �ַ�
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// ��ʽ�������ַ�
				DecimalFormat nf = new DecimalFormat("0.00");// ��ʽ������
				switch (cell.getCellType()) {
				case XSSFCell.CELL_TYPE_STRING:
					// System.out.println(i + "��" + j + " �� is String type");
					value = cell.getStringCellValue();
					break;
				case XSSFCell.CELL_TYPE_NUMERIC:
					if ("@".equals(cell.getCellStyle().getDataFormatString())) {
						value = df.format(cell.getNumericCellValue());
					} else if ("General".equals(cell.getCellStyle().getDataFormatString())) {
						value = nf.format(cell.getNumericCellValue());
					} else {
						value = sdf.format(HSSFDateUtil.getJavaDate(cell.getNumericCellValue()));
					}
					break;
				case XSSFCell.CELL_TYPE_BOOLEAN:
					// System.out.println(i + "��" + j + " �� is Boolean type");
					value = cell.getBooleanCellValue();
					break;
				case XSSFCell.CELL_TYPE_BLANK:
					// System.out.println(i + "��" + j + " �� is Blank type");
					value = "";
					break;
				default:
					// System.out.println(i + "��" + j + " �� is default type");
					value = cell.toString();
				}
				if (value == null || "".equals(value)) {
					continue;
				}
				linked.add(value);
			}
			list.add(linked);
		}
		return list;
	}

	// public static void main(String[] args) {
	//// try {
	////// readExcel(new File("E:\\test.xlsx"));
	//// long t1 = System.currentTimeMillis();
	//// List<List<Object>> list = readExcel(new File("E:\\�û���Ϣ.xls"));
	//// long t2 = System.currentTimeMillis();
	//// System.out.println(t2-t1);
	////
	//// for (int i = 0; i < list.size(); i++) {
	//// List<Object> objectList = list.get(i);
	////
	//// }
	//// } catch (IOException e) {
	//// e.printStackTrace();
	//// }
	// System.out.println(Pattern.matches("[0-9a-zA-Z]{4,23}", "1231 "));
	// }

	public static void readList(List<List<Object>> list, String FORMATTER) {
		SimpleDateFormat sdf = new SimpleDateFormat(FORMATTER);
		StringBuilder errorInfo = new StringBuilder();
		for (int i = 1; i < list.size(); i++) {
			List<Object> objectList = list.get(i);
			User user = new User();

		}
	}
}

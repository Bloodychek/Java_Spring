package egorov.com.salesdepartmentsystem.excel;

import egorov.com.salesdepartmentsystem.models.Application;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class ApplicationExcelGeneration {
    private List<Application> applicationList;
    private Workbook workbook;
    private Sheet sheet;

    private CreationHelper createHelper;

    public ApplicationExcelGeneration(List<Application> applicationList) {
        this.applicationList = applicationList;
        workbook = new HSSFWorkbook();
    }

    private void writeHeader() {
        sheet = workbook.createSheet("applications");
        Row row = sheet.createRow(0);
        createHelper = workbook.getCreationHelper();
        CellStyle style = workbook.createCellStyle();
        style.setDataFormat(createHelper.createDataFormat().getFormat("dd-M-yyyy hh:mm:ss"));
        createCell(row, 0, "Id", style);
        createCell(row, 1, "uploadDate", style);
        createCell(row, 2, "unloadingDate", style);
        createCell(row, 3, "paymentDayTime", style);
        createCell(row, 4, "currency", style);
        createCell(row, 5, "applicationsNumber", style);
        createCell(row, 6, "routeId", style);
        createCell(row, 7, "transportId", style);
        createCell(row, 8, "customerId", style);
        createCell(row, 9, "orderExecutorId", style);
    }

    private void createCell(Row row, int columnCount, Object valueOfCell, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        cell.setCellValue(new Date());
        if (valueOfCell instanceof Integer) {
            cell.setCellValue((Integer) valueOfCell);
        } else if (valueOfCell instanceof Date) {
            cell.setCellValue(new Date());
        } else if (valueOfCell instanceof String) {
            cell.setCellValue((String) valueOfCell);
        }
        cell.setCellStyle(style);
    }

    private void write() {
        int rowCount = 1;
        CellStyle style = workbook.createCellStyle();
        for (Application record : applicationList) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            createCell(row, columnCount++, record.getId(), style);
            createCell(row, columnCount++, record.getUploadDate(), style);
            createCell(row, columnCount++, record.getUnloadingDate(), style);
            createCell(row, columnCount++, record.getPaymentDayTime(), style);
            createCell(row, columnCount++, record.getCurrency(), style);
            createCell(row, columnCount++, record.getApplicationsNumber(), style);
            createCell(row, columnCount++, record.getRouteId(), style);
            createCell(row, columnCount++, record.getTransportId(), style);
            createCell(row, columnCount++, record.getCustomerId(), style);
            createCell(row, columnCount++, record.getOrderExecutorId(), style);
        }
    }

    public void generateExcelFile(HttpServletResponse response) throws IOException {
        writeHeader();
        write();
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}

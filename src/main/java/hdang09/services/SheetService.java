/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hdang09.services;

import hdang09.entities.Student;
import hdang09.repositories.StudentRepository;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;


/**
 * @author Admin
 */
@Service
public class SheetService {

    @Autowired
    StudentRepository studentRepository;

    public void exportSheet(HttpServletResponse response) throws IOException {
        ArrayList<Student> students = studentRepository.getAllStudent();

        // Create a new workbook
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Students");

        // Create headers
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("ID");
        headerRow.createCell(1).setCellValue("First Name");
        headerRow.createCell(2).setCellValue("Last Name");
        headerRow.createCell(3).setCellValue("Major");
        headerRow.createCell(4).setCellValue("Student ID");
        headerRow.createCell(5).setCellValue("Semester");
        headerRow.createCell(6).setCellValue("Personal Email");
        headerRow.createCell(7).setCellValue("Phone");

        // Populate data
        int rowNum = 1;
        populateData(students, sheet, rowNum);

        // Set the response headers
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=[F-CODE]%20F19%20Accounts.xlsx");

        // Write the workbook data to the response output stream
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }

    public static void populateData(ArrayList<Student> students, Sheet sheet, int rowNum) {
        for (Student student : students) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(student.getId());
            row.createCell(1).setCellValue(student.getFirstName());
            row.createCell(2).setCellValue(student.getLastName());
            row.createCell(3).setCellValue(student.getMajor());
            row.createCell(4).setCellValue(student.getStudentId());
            row.createCell(5).setCellValue(student.getSemester());
            row.createCell(6).setCellValue(student.getPersonalEmail());
            row.createCell(7).setCellValue(student.getPhone());
        }
    }
}

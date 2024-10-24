/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tech.fcode.recruitment.services.impl;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import tech.fcode.recruitment.entities.Student;
import tech.fcode.recruitment.repositories.StudentRepository;
import tech.fcode.recruitment.services.SheetService;

@Service
@RequiredArgsConstructor
public class SheetServiceImpl implements SheetService{
    private final StudentRepository studentRepository;

    public void exportSheet(HttpServletResponse response) throws IOException {
        ArrayList<Student> students = studentRepository.getAllStudent();
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
        int rowNum = 1;
        populateData(students, sheet, rowNum);
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=[F-CODE]%20F19%20Accounts.xlsx");
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

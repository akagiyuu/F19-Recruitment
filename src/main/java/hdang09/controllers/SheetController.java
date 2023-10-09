/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hdang09.controllers;

import hdang09.services.SheetService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 *
 * @author Admin
 */

@RestController
@CrossOrigin
@RequestMapping("/sheet")
@Tag(name = "Sheet")
public class SheetController {

    @Autowired
    SheetService service = new SheetService();

    @GetMapping
    @Operation(summary = "Export all account to a sheet")
    public void exportSheet(HttpServletResponse response) throws IOException {
        service.exportSheet(response);
    }
}
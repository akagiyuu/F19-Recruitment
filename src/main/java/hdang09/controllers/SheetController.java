/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hdang09.controllers;

import hdang09.entities.Student;
import hdang09.services.SheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */

@RestController
@CrossOrigin
@RequestMapping("/sheet")
public class SheetController {

    @Autowired
    SheetService service = new SheetService();

    @GetMapping("/")
    public void exportSheet() {
        service.exportSheet();
    }
}
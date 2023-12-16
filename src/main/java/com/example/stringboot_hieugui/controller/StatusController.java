package com.example.stringboot_hieugui.controller;

import com.example.stringboot_hieugui.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/v1/status"})
@CrossOrigin("*")
public class StatusController {

    private StatusService statusService;
    @Autowired
    public void setStatusService(StatusService statusService) {
        this.statusService = statusService;
    }

    @GetMapping("/getAllStatusName")
    public ResponseEntity<?> findAllStatusName() {
        return ResponseEntity.ok(statusService.findAllStatusName());
    }
}

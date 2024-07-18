package com.azbj.qc.det.frm.controller;

import com.azbj.qc.det.frm.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticateUser(@RequestParam String supervisorId, @RequestParam String password) {
        if (supervisorId == null || supervisorId.isEmpty() || password == null || password.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Supervisor ID and Password are required");
        }

        boolean isAuthenticated = authenticationService.authenticate(supervisorId, password);
        if (isAuthenticated) {
            return ResponseEntity.ok("Authentication successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed");
        }
    }

    @PostMapping("/authenticateSupervisor")
    public ResponseEntity<String> authenticateSupervisor(@RequestParam String supervisorId, @RequestParam String password) {
        if (supervisorId == null || supervisorId.isEmpty() || password == null || password.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Supervisor ID and Password are required");
        }

        boolean isAuthenticated = authenticationService.authenticate(supervisorId, password);
        if (isAuthenticated) {
            // Additional logic for setting approval flag, inserting into approval log, etc.
            // This is a simplified version for demonstration purposes.
            return ResponseEntity.ok("Supervisor authenticated and approved");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Supervisor ID or Password");
        }
    }
}

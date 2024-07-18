package com.azbj.qc.det.frm.service;

import com.azbj.qc.det.frm.repository.AuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private AuthenticationRepository authenticationRepository;

    public boolean authenticate(String supervisorId, String password) {
        // Fetch supervisor details from repository
        var supervisor = authenticationRepository.findBySupervisorId(supervisorId);

        // Validate password
        if (supervisor != null && supervisor.getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}

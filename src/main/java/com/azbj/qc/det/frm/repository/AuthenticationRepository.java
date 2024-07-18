package com.azbj.qc.det.frm.repository;

import com.azbj.qc.det.frm.model.Supervisor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthenticationRepository extends JpaRepository<Supervisor, Long> {

    /**
     * Find a supervisor by their ID and password.
     *
     * @param supervisorId the supervisor ID
     * @param password the password
     * @return the matching supervisor record if found, otherwise null
     */
    Supervisor findBySupervisorIdAndPassword(String supervisorId, String password);

    /**
     * Find a supervisor by their ID.
     *
     * @param supervisorId the supervisor ID
     * @return the supervisor details if found, else null
     */
    Supervisor findBySupervisorId(String supervisorId);
}

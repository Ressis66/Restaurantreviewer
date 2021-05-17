package com.restorauntreviewer.repository;


import com.restorauntreviewer.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Repository interface that extends {@link JpaRepository} for class {@link Role}.
 *
 * @author Eugene Suleimanov
 * @version 1.0
 */

public interface RoleRepository extends JpaRepository<Role, Long> {
    @Transactional (readOnly = true)
    Role findByName(String name);
}

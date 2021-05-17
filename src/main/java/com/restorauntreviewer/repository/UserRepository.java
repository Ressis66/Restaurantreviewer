package com.restorauntreviewer.repository;


import com.restorauntreviewer.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Repository interface that extends {@link JpaRepository} for class {@link User}.
 *
 * @author Eugene Suleimanov
 * @version 1.0
 */

public interface UserRepository extends JpaRepository<User, Long> {
    @Transactional (readOnly = true)
    User findByUsername(String username);
}

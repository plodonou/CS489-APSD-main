package edu.miu.adsAppSecurity.repository;

import edu.miu.adsAppSecurity.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByRoleName(String name);
}

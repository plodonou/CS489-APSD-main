package edu.miu.adsAppSecurity.repository;

import edu.miu.adsAppSecurity.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}

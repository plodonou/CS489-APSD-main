package edu.miu.adsApp.repository;

import edu.miu.adsApp.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}

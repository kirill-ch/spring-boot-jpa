package ru.kirillch.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kirillch.springdata.entity.Address;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    List<Address> findByCity(String city);
}

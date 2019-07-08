package ru.kirillch.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kirillch.springdata.entity.Passport;

public interface PassportRepository extends JpaRepository<Passport, Integer> {
    Passport findByNumber(String number);
}

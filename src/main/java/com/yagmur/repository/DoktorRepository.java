package com.yagmur.repository;

import com.yagmur.entity.Doktor;
import com.yagmur.utility.enums.EStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DoktorRepository extends JpaRepository<Doktor, Long> {
    Optional<Doktor> findByAdSoyad(String adSoyad);
    List<Doktor> findByStatus(EStatus status);



}

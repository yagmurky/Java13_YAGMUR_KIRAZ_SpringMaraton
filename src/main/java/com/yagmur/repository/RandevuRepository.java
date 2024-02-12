package com.yagmur.repository;

import com.yagmur.entity.Randevu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface RandevuRepository extends JpaRepository<Randevu, Long> {

    List<Randevu> findAllByDoktorIdAndTarih(Long id, LocalDate tarih);
    // Belirli bir gün için belirli bir doktorun randevularını getir
    List<Randevu> findRandevuByDoktorIdAndTarih(Long doktorId, LocalDate tarih);

}

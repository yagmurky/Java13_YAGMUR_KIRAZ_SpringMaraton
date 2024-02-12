package com.yagmur.repository;

import com.yagmur.entity.Hasta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HastaRepository extends JpaRepository <Hasta,Long> {
    Optional<Hasta> findByTcKimlikNo(Long hastaTcKimlikNo);

}

package com.yagmur.entity;

import com.yagmur.utility.enums.EStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_randevu")
public class Randevu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "doktor_id")
    private Long doktorId;
    private Long hastaId;
    private LocalDate tarih;
    @Enumerated
    @Builder.Default
    private EStatus durum = EStatus.AKTIF;


}

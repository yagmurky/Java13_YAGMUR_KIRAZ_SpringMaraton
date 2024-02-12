package com.yagmur.entity;

import com.yagmur.utility.enums.EBrans;
import com.yagmur.utility.enums.EStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_doktor")
public class Doktor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ad_soyad", nullable = false)
    private String adSoyad;
    @Enumerated(EnumType.STRING)
    private EBrans brans;
    @NotNull
    private String unvan;
    @Builder.Default
    private EStatus status = EStatus.AKTIF;
}

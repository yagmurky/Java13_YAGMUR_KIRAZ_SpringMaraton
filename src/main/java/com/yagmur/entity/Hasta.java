package com.yagmur.entity;

import com.yagmur.utility.enums.ECinsiyet;
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
@Table(name = "tbl_hasta")
public class Hasta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ad_soyad", nullable = false)
    private String adSoyad;
    private String telefon;
    private String adres;
    private int yas;
    @NotNull
    @Column(unique = true)
    private Long tcKimlikNo;
    @Enumerated
    private ECinsiyet cinsiyet;

}

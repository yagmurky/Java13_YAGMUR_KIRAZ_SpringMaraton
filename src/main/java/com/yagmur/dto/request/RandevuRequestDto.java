package com.yagmur.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RandevuRequestDto {
    private LocalDate tarih;
    private Long hastaTcKimlikNo;
    private String hastaAdi;
    private String doktorAdi;
}

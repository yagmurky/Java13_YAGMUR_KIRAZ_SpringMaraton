package com.yagmur.dto.response;

import com.yagmur.utility.enums.EBrans;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DoktorSaveResponseDto {
    private String adSoyad;
    private EBrans brans;
    private String unvan;
}

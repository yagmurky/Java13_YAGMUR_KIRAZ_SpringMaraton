package com.yagmur.dto.request;

import com.yagmur.utility.enums.EBrans;
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
public class DoktorSaveRequestDto {
    private String adSoyad;
    @Enumerated
    private EBrans brans;
    @NotNull
    private String unvan;
}

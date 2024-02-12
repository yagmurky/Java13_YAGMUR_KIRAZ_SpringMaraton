package com.yagmur.mapper;

import com.yagmur.dto.request.RandevuRequestDto;
import com.yagmur.dto.response.RandevuResponseDto;
import com.yagmur.entity.Randevu;
import org.mapstruct.factory.Mappers;

public interface RandevuMapper {
    RandevuMapper INSTANCE = Mappers.getMapper(RandevuMapper.class);

    Randevu fromRandevuRequestDtoToRandevu (final RandevuRequestDto randevuSaveRequestDto);
    RandevuResponseDto fromRandevuToRandevuResponseDto (final Randevu randevu);
}

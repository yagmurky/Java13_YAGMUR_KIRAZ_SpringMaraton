package com.yagmur.mapper;

import com.yagmur.dto.request.HastaSaveRequestDto;
import com.yagmur.dto.response.HastaResponseDto;
import com.yagmur.entity.Hasta;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface HastaMapper {
    HastaMapper INSTANCE = Mappers.getMapper(HastaMapper.class);

    Hasta fromHastaRequestDtoToHasta(HastaSaveRequestDto dto);

    HastaResponseDto fromHastaToHastaResponseDto (Hasta hasta);

}

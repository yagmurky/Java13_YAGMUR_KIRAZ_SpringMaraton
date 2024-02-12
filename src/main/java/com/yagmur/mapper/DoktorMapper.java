package com.yagmur.mapper;


import com.yagmur.dto.request.DoktorSaveRequestDto;
import com.yagmur.dto.response.DoktorSaveResponseDto;
import com.yagmur.entity.Doktor;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DoktorMapper {

    DoktorMapper INSTANCE = Mappers.getMapper(DoktorMapper.class);

    Doktor toRequestDto(DoktorSaveRequestDto dto);

    DoktorSaveResponseDto toDoktor(Doktor doktor);

}

package com.yagmur.service;

import com.yagmur.dto.request.HastaSaveRequestDto;
import com.yagmur.dto.response.HastaResponseDto;
import com.yagmur.entity.Hasta;
import com.yagmur.exception.ErrorType;
import com.yagmur.exception.RandevuSistemiException;
import com.yagmur.mapper.HastaMapper;
import com.yagmur.repository.HastaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class HastaService {
    private final HastaRepository hastaRepository;

    // Hasta oluşturma

    public HastaResponseDto save(HastaSaveRequestDto hastaSaveRequestDto) {
        Hasta hasta = HastaMapper.INSTANCE.fromHastaRequestDtoToHasta(hastaSaveRequestDto);
        hastaRepository.save(hasta);
        try {
            return HastaMapper.INSTANCE.fromHastaToHastaResponseDto(hasta);
        } catch (Exception exception) {
            throw new RandevuSistemiException(ErrorType.BAD_REQUEST);
        }
    }
    public Hasta saveHasta (Hasta hasta){
        return hastaRepository.save(hasta);
    }

    // Tüm hastaları listeleme
    public List<Hasta> getAllHasta() {
        return hastaRepository.findAll();
    }

    // ID'ye göre hasta bulma
    public Hasta getHastaById(Long id) {
        return hastaRepository.findById(id).orElseThrow(() -> new RandevuSistemiException(ErrorType.HASTA_BULUNAMADI));
    }

    // Id ile hasta silme
    public void deleteHasta(Long id) {
        hastaRepository.deleteById(id);
    }


    public Optional<Hasta> findByTcKimlikNo(Long hastaTcKimlikNo) {
        return hastaRepository.findByTcKimlikNo(hastaTcKimlikNo);
    }
}

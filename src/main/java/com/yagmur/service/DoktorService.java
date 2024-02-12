package com.yagmur.service;

import com.yagmur.dto.request.DoktorSaveRequestDto;
import com.yagmur.dto.response.DoktorSaveResponseDto;
import com.yagmur.entity.Doktor;
import com.yagmur.exception.ErrorType;
import com.yagmur.exception.RandevuSistemiException;
import com.yagmur.mapper.DoktorMapper;
import com.yagmur.repository.DoktorRepository;
import com.yagmur.utility.enums.EStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DoktorService {

    private final DoktorRepository doktorRepository;

    public DoktorSaveResponseDto save(DoktorSaveRequestDto dto) {
        Doktor doktor = DoktorMapper.INSTANCE.toRequestDto(dto);
        doktorRepository.save(doktor);
        try {
            return DoktorMapper.INSTANCE.toDoktor(doktor);
        } catch (Exception exception) {
            throw new RandevuSistemiException(ErrorType.BAD_REQUEST);
        }
    }

    public List<Doktor> doktorlariListele() {
        return doktorRepository.findAll();
    }

    public Optional<Doktor> findById(Long id) {
        Optional<Doktor> optionalDoktor=doktorRepository.findById(id);
        if (optionalDoktor.isPresent()){
            return optionalDoktor;
        }
        throw new RandevuSistemiException(ErrorType.DOKTOR_BULUNAMADI);
    }

    public Optional<Doktor> findByAdSoyad(String ad) {
        Optional<Doktor> optionalDoktor = doktorRepository.findByAdSoyad(ad);
        if (optionalDoktor.isPresent()){
            return optionalDoktor;
        }
        throw new RandevuSistemiException(ErrorType.DOKTOR_BULUNAMADI);
    }

    public void deleteById(Long id) {
        doktorRepository.deleteById(id);
    }


    public  List<Doktor> findByStatus(EStatus status){
        return doktorRepository.findByStatus(status);
    }



}

package com.yagmur.service;

import com.yagmur.dto.request.RandevuRequestDto;
import com.yagmur.dto.response.HastaResponseDto;
import com.yagmur.dto.response.RandevuResponseDto;
import com.yagmur.entity.Doktor;
import com.yagmur.entity.Hasta;
import com.yagmur.entity.Randevu;
import com.yagmur.exception.ErrorType;
import com.yagmur.exception.RandevuSistemiException;
import com.yagmur.mapper.RandevuMapper;
import com.yagmur.repository.RandevuRepository;
import com.yagmur.utility.enums.EStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class RandevuService {

    private final RandevuRepository randevuRepository;
    private final DoktorService doktorService;
    private final HastaService hastaService;

    // Randevu oluşturma //Çalışmaması sebebiyle bu kodu yoruma alıyorum.

    /*
    public String addRandevu (RandevuRequestDto randevuSaveRequestDto){
        Optional<Doktor> optionalDoktor = doktorService.findByAdSoyad(randevuSaveRequestDto.getDoktorAdi());
        Optional<Hasta> optionalHasta = hastaService.findByTcKimlikNo(randevuSaveRequestDto.getHastaTcKimlikNo());
        Randevu randevu = RandevuMapper.INSTANCE.fromRandevuRequestDtoToRandevu(randevuSaveRequestDto);
        if (optionalHasta.isEmpty()){
            Hasta hasta = Hasta.builder().adSoyad(randevuSaveRequestDto.getHastaAdi()).tcKimlikNo(randevuSaveRequestDto.getHastaTcKimlikNo()).build();
            hastaService.saveHasta(hasta);
            randevu.setHastaId(hasta.getId());
            }
        if (optionalDoktor.isEmpty()){
            throw new RandevuSistemiException(ErrorType.BAD_REQUEST, "Doktor bulunamadı. Lütfen doktorları görüntülerek, geçerli bir doktor adı giriniz.");
        }
        Doktor doktor = optionalDoktor.get();
        doktor.setStatus(EStatus.DOLU);
        randevuRepository.save(randevu);
        RandevuResponseDto randevuResponseDto = RandevuMapper.INSTANCE.fromRandevuToRandevuResponseDto(randevu);
            return "Randevu oluşturuldu. Randevu numarası: " + randevu.getId();
    }
     */
    public Randevu saveRandevu (Randevu randevu){
        Optional<Doktor> optionalDoktor = doktorService.findById(randevu.getDoktorId());
        if (optionalDoktor.isEmpty()){
            throw new RandevuSistemiException(ErrorType.DOKTOR_BULUNAMADI);
        }
        Doktor doktor = optionalDoktor.get();
        doktor.setStatus(EStatus.DOLU);
        return randevuRepository.save(randevu);
    }

    // Tüm randevuları listeleme
    public List<Randevu> getAllRandevu() {
        return randevuRepository.findAll();
    }

    // ID'ye göre randevu bulma
    public Optional<Randevu> getRandevuById(Long id) {
        return randevuRepository.findById(id);
    }

    // Randevu silme
    public void deleteRandevu(Long id) {
        Optional<Randevu> randevuOptional = getRandevuById(id);
        randevuRepository.delete(randevuOptional.get());
    }
    public List<Randevu> findRandevularByDoktorIdAndTarih(Long doktorId, LocalDate tarih){
        return randevuRepository.findRandevuByDoktorIdAndTarih(doktorId,tarih);
    }
}


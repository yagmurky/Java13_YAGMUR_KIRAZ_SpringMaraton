package com.yagmur.controller;

import com.yagmur.dto.request.DoktorSaveRequestDto;
import com.yagmur.dto.response.DoktorSaveResponseDto;
import com.yagmur.entity.Doktor;
import com.yagmur.entity.Randevu;
import com.yagmur.service.DoktorService;
import com.yagmur.service.RandevuService;
import com.yagmur.utility.enums.EStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static com.yagmur.constans.RestApiUrls.*;

@RequestMapping(HASTANE)
@RequiredArgsConstructor
@RestController
public class HastaneController {
    private final RandevuService randevuService;
    private final DoktorService doktorService;



    @PostMapping(DOKTOR_EKLE)
    public ResponseEntity<DoktorSaveResponseDto> doktorEkle(@RequestBody DoktorSaveRequestDto dto){
        return ResponseEntity.ok(doktorService.save(dto));
    }

    //tüm doktorları listele
    @GetMapping(GET_ALL_DOKTOR)
    public ResponseEntity<List<Doktor>> doktorlariListele(){
        return ResponseEntity.ok(doktorService.doktorlariListele());
    }

    //randevuları listele
    @GetMapping(GET_ALL_RANDEVU)
    public ResponseEntity<List<Randevu>> randevulariListele(){
        return ResponseEntity.ok(randevuService.getAllRandevu());
    }


    //id ile doktor bul
    @GetMapping(DELETE_DOKTOR_BY_ID)
    public ResponseEntity<Optional<Doktor>> idIleDoktorBul(Long id){
        return ResponseEntity.ok(doktorService.findById(id));
    }

    //id ile doktor sil
    @DeleteMapping(DELETE_DOKTOR)
    public ResponseEntity<Void> doktorSil(Long id){
        doktorService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(FIND_BY_STATUS)
    public  ResponseEntity<List<Doktor>> findByStatus(EStatus status){
        return ResponseEntity.ok(doktorService.findByStatus(status));
    }

    @GetMapping(FIND_RANDEVU_BY_DOKTOR_ID_AND_TARIH)
    public ResponseEntity<List<Randevu>> findRandevularByDoktorIdAndTarih(Long doktorId, LocalDate tarih){
        return ResponseEntity.ok(randevuService.findRandevularByDoktorIdAndTarih(doktorId,tarih));
    }

}

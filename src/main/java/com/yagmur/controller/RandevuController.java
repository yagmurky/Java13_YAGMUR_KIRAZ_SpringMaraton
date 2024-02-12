package com.yagmur.controller;

import com.yagmur.dto.request.RandevuRequestDto;
import com.yagmur.dto.response.RandevuResponseDto;
import com.yagmur.entity.Randevu;
import com.yagmur.service.RandevuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import  static  com.yagmur.constans.RestApiUrls.*;

@RequestMapping(RANDEVU)
@RequiredArgsConstructor
@RestController
public class RandevuController {
    private final RandevuService randevuService;

    // Randevu oluşturma
    /*
    @PostMapping(ADD_RANDEVU)
    public ResponseEntity<RandevuResponseDto> addRandevu(@RequestBody RandevuRequestDto randevuRequestDto) {
        randevuService.addRandevu(randevuRequestDto);
        return ResponseEntity.ok().build();
    }
    /*
        İlgili metodu kullanırken hata aldığım için kodu yoruma aldım.

     */
    // Tüm randevuları listeleme
    @GetMapping(GET_ALL_RANDEVU)
    public ResponseEntity<List<Randevu>> getAllRandevu() {
        return ResponseEntity.ok(randevuService.getAllRandevu());
    }
    // ID'ye göre randevu bulma
    @GetMapping(GET_BY_ID)
    public ResponseEntity<Optional<Randevu>> getRandevuById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(randevuService.getRandevuById(id));
    }
    // Randevu silme
    @DeleteMapping(DELETE_BY_ID)
    public void deleteRandevu(@PathVariable(value = "id") Long id) {
        randevuService.deleteRandevu(id);
    }

    @PostMapping("/save")
    public ResponseEntity<Boolean> save (@RequestBody Randevu randevu){
        randevuService.saveRandevu(randevu);
        return ResponseEntity.ok().build();
    }

}

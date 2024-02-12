package com.yagmur.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
@AllArgsConstructor
public enum ErrorType {
    INTERNAL_ERROR_SERVER(5100,"Server error",HttpStatus.INTERNAL_SERVER_ERROR),
    BAD_REQUEST(4100,"Parameter error",HttpStatus.BAD_REQUEST),
    RANDEVU_BULUNAMADI(4101,"Randevu bulunamadı",HttpStatus.NOT_FOUND),
    HASTA_BULUNAMADI(4202,"Hasta bulunamadı",HttpStatus.NOT_FOUND),
    DOKTOR_BULUNAMADI(4302,"Doktor bulunamadı",HttpStatus.NOT_FOUND);
    private  int code;
    private String message;
    HttpStatus httpStatus;
}
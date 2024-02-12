package com.yagmur.constans;

public class RestApiUrls {
    private static final String VERSION = "/v1";
    private static final String API = "/api";
    private static final String TEST = "/test";
    private static final String DEV = "/dev";
    private static final String PROD = "/prod";

    private static final String ROOT = DEV + VERSION;

    public static final String DOKTOR = ROOT + "/doktor";
    public static final String HASTA = ROOT + "/hasta";
    public static final String HASTANE = ROOT + "/hastane";
    public static final String RANDEVU = ROOT + "/randevu";


    public static final String DOKTOR_EKLE = ROOT + "/doktorekle";
    public static final String ADD_RANDEVU = ROOT + "/add-randevu";
    public static final String GET_ALL_RANDEVU = "/get-all-randevu";
    public static final String GET_ALL_DOKTOR = "/get-all-doktor";
    public static final String GET_BY_ID = "/get-by-id";
    public static final String FIND_BY_STATUS = "/find-by-status";
    public static final String FIND_RANDEVU_BY_DOKTOR_ID_AND_TARIH = "/find-randevu-by-doktor-id-and-tarih";
    public static final String UPDATE_BY_ID = "/update-by-id";
    public static final String DELETE_BY_ID = "/delete-by-id";
    public static final String DELETE_DOKTOR_BY_ID = "/delete-doktor-by-id";
    public static final String DELETE_DOKTOR = "/delete-doktor";



}
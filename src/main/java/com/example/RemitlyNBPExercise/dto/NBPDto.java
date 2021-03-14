package com.example.RemitlyNBPExercise.dto;

import lombok.Getter;

@Getter
public class NBPDto {

    // Both classes (NBPDto and NBPgbpDto) from this package represents JSON fields in API
    // I used them to create Java object and get values

    public NBPgbpDto[] rates;
}

package com.example.rh.Models.Enum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {
    CEO_READ("ceo::read"),
    CEO_UPDATE("ceo::update"),
    CEO_DELETE("ceo::delete"),
    CEO_CREATE("ceo::create"),


    CHRO_READ("chro::read"),
    CHRO_UPDATE("chro::update"),
    CHRO_DELETE("chro::delete"),
    CHRO_CREATE("chro::create"),

    PROJECT_MANAGER_READ("Project Manager::read"),
    PROJECT_MANAGER_UPDATE("Project Manager::update"),
    PROJECT_MANAGER_DELETE("Project Manager::delete"),
    PROJECT_MANAGER_CREATE("Project Manager::create"),

    STANDARD_EMPLOYER_READ("standard employer::read"),
    STANDARD_EMPLOYER_UPDATE("standard employer::update"),
    STANDARD_EMPLOYER_DELETE("standard employer::delete"),
    STANDARD_EMPLOYER_CREATE("standard employer::create"),






    ;





    @Getter
    private final String permission ;






}
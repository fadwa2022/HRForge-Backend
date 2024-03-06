package com.example.rh.Models.suppl;

import com.example.rh.Models.Dtos.Reponse.AbsenceResponseDTO;

import java.util.List;

public class AbsenceResponse {
    private List<AbsenceResponseDTO> responseDtos;
    private long daysBetween;

    public AbsenceResponse(List<AbsenceResponseDTO> responseDtos, long daysBetween) {
        this.responseDtos = responseDtos;
        this.daysBetween = daysBetween;
    }

    public List<AbsenceResponseDTO> getResponseDtos() {
        return responseDtos;
    }

    public long getDaysBetween() {
        return daysBetween;
    }
}


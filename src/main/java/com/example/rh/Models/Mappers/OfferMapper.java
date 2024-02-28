package com.example.rh.Models.Mappers;

import com.example.rh.Models.Dtos.Reponse.OfferResponseDTO;
import com.example.rh.Models.Dtos.Request.OfferRequestDTO;
import com.example.rh.Models.Entities.Offer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OfferMapper implements IMapper<Offer, OfferRequestDTO, OfferResponseDTO> {

    private final ModelMapper modelMapper;

    @Autowired
    public OfferMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public OfferResponseDTO toRes(Offer offer) {
        return this.modelMapper
                .map(offer, OfferResponseDTO.class);
    }

    @Override
    public OfferRequestDTO toReq(Offer offer) {
        return this.modelMapper
                .map(offer, OfferRequestDTO.class);
    }

    @Override
    public Offer resToEntity(OfferResponseDTO offerResponseDTO) {
        return this.modelMapper
                .map(offerResponseDTO, Offer.class);
    }

    @Override
    public Offer reqToEntity(OfferRequestDTO offerRequestDTO) {
        return this.modelMapper
                .map(offerRequestDTO, Offer.class);
    }
}

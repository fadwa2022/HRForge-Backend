package com.example.rh.Models.Mappers;

import com.example.rh.Models.Dtos.Reponse.AdvantageResponseDTO;
import com.example.rh.Models.Dtos.Reponse.DemandeResponse;
import com.example.rh.Models.Dtos.Request.AdvantageRequestDTO;
import com.example.rh.Models.Dtos.Request.Demanderequest;
import com.example.rh.Models.Entities.Advantage;
import com.example.rh.Models.Entities.Demande;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DemandeMapper implements IMapper<Demande, Demanderequest, DemandeResponse>{
    private final ModelMapper modelMapper;

    @Autowired
    public DemandeMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    @Override
    public DemandeResponse toRes(Demande demande) {

        return this.modelMapper.map(demande, DemandeResponse.class);
    }

    @Override
    public Demanderequest toReq(Demande demande) {

        return this.modelMapper.map(demande,Demanderequest.class);
    }

    @Override
    public Demande resToEntity(DemandeResponse demandeResponse) {

        return this.modelMapper.map(demandeResponse,Demande.class );
    }

    @Override
    public Demande reqToEntity(Demanderequest demanderequest) {

        return this.modelMapper.map(demanderequest,Demande.class);

    }
}

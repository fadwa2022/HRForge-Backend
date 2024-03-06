package com.example.rh.Services;

import com.example.rh.Models.Dtos.Request.HrAdministrationRequestDTO;
import org.springframework.data.domain.Page;

public interface Service<Entity, pk, Req, Res>  {
    Res getById(pk id);
    Page<Res> getAll(int page, int size);
    Res create(Req request);
    Res update(String id, Req request);
    void deleteById(pk id);

}

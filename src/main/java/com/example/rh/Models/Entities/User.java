package com.example.rh.Models.Entities;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
@Data
@MappedSuperclass
public class User {
        private String first_name;

        private String last_name;

        private String email;

        private String password;

        private String image;

        private String telephone;

        private String address;
    }

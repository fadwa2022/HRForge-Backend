package com.example.rh.Models.Dtos.Request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Demanderequest {
    private String subject;
      private String content;
         private String statut;
           private String personnel;
    
}

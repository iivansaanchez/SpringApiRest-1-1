package com.vedruna.colegio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentInfoDTO {

    private Integer id;
    private String address;
    private Integer telephone; 
    
}

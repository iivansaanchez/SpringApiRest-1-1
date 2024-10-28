package com.vedruna.colegio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentAllInfo {
    
    private String name;
    private String lastName;
    private String address;
    private Integer telephone;
    
}

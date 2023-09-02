package com.example.cja_inventario.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EmailDTO {

    private String[] toUser;
    private String subject;
    private String massage;


}

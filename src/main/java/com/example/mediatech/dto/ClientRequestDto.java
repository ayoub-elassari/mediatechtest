package com.example.mediatech.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequestDto {

//    private Integer id;
//    @NotNull(message = "le nom est obligatoire")
//    @Size(min = 5, max = 20, message = "le nombre de caractére doit etre compris entre 5 et 20")
    @NotBlank
    @Size(min = 5, message = "ce champ doit avoir au moins 5 caracter")
    @Size(max = 20, message = "ce champ doit avoir au plus 5 caractere")
    private String nom;

//    @NotNull(message = "le prenom est obligatoire")
//    @Size(min = 5, max = 20, message = "le nombre de caractére doit etre compris entre 5 et 20")
    @NotBlank(message = "ce champ est obligatoir")
    @Size(min = 5, message = "ce champ doit avoir au moins 5 caracter")
    @Size(max = 20, message = "ce champ doit avoir au plus 5 caractere")
    private String prenom;

    @NotNull
    @Pattern(regexp = "^(\\+212|0)([ \\-_/]*)(\\d[ \\-_/]*){9}$", message = "format invalid")
    private String telephone;
}

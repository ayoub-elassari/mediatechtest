package com.example.mediatech.service;

import com.example.mediatech.dto.ClientRequestDto;
import com.example.mediatech.dto.ClientResponseDto;

import java.util.List;

public interface ClientService {

    ClientResponseDto save(ClientRequestDto clientRequestDto);

    ClientResponseDto findById(Integer id);

    ClientResponseDto findByNom(String nom);

    void delete(Integer id);

    ClientResponseDto update(ClientRequestDto clientRequestDto, Integer id);

    List<ClientResponseDto> findAll();
}

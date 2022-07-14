package com.example.mediatech.service;

import com.example.mediatech.dao.ClientDao;
import com.example.mediatech.dto.ClientRequestDto;
import com.example.mediatech.dto.ClientResponseDto;
import com.example.mediatech.exception.EntityNotFoundException;
import com.example.mediatech.models.ClientEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service("impl1")
public class ClientServiceImpl implements ClientService{

    private ClientDao clientDao;
    private ModelMapper modelMapper;

    public ClientServiceImpl(ClientDao clientDao, ModelMapper modelMapper) {
        this.clientDao = clientDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public ClientResponseDto save(@RequestBody() ClientRequestDto clientRequestDto) {
        ClientEntity clientEntity = modelMapper.map(clientRequestDto, ClientEntity.class);
        ClientEntity saved = clientDao.save(clientEntity);
        return modelMapper.map(saved, ClientResponseDto.class);
    }

    @Override
    public ClientResponseDto findById(Integer id) {
        ClientEntity clientEntity = clientDao.findById(id).orElseThrow(()->new EntityNotFoundException("client not found"));
        return modelMapper.map(clientEntity, ClientResponseDto.class);
    }

    @Override
    public ClientResponseDto findByNom(String nom) {
        ClientEntity clientEntity = clientDao.findByNom(nom);
        return modelMapper.map(clientEntity, ClientResponseDto.class);
    }

    @Override
    public void delete(Integer id) {
        clientDao.deleteById(id);
//        ClientEntity clientEntity = clientDao.findById(id).get();
//        clientDao.delete(clientEntity);
    }

    @Override
    public ClientResponseDto update(ClientRequestDto clientRequestDto, Integer id) {

        Optional<ClientEntity> clientEntityOptional = clientDao.findById(id);
        if(clientEntityOptional.isPresent()) {
            ClientEntity clientEntity = modelMapper.map(clientRequestDto, ClientEntity.class);
            clientEntity.setId(id);
            ClientEntity updated = clientDao.save(clientEntity);
            return modelMapper.map(updated, ClientResponseDto.class);
        }else {
            throw new EntityNotFoundException("client not found");
        }
    }

    @Override
    public List<ClientResponseDto> findAll() {
        return clientDao.findAll()
                .stream().map(el-> modelMapper.map(el, ClientResponseDto.class))
                .collect(Collectors.toList());
    }
}

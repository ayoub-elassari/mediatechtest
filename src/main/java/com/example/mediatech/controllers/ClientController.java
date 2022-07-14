package com.example.mediatech.controllers;


import com.example.mediatech.dto.ClientRequestDto;
import com.example.mediatech.dto.ClientResponseDto;
import com.example.mediatech.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//@Controller
//@ResponseBody
@RestController
@RequestMapping("clients")
public class ClientController {


    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("")
    public ResponseEntity<List<ClientResponseDto>> getClient() {
//        return clientService.findAll();
        return new ResponseEntity<>(clientService.findAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<ClientResponseDto> save(@Valid @RequestBody() ClientRequestDto clientRequestDto){
//        return clientService.save(clientRequestDto);
        ClientResponseDto clientResponseDto = clientService.save(clientRequestDto);
        return new ResponseEntity<>(clientResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ClientResponseDto> findById(@PathVariable() Integer id) {
            ClientResponseDto clientResponseDto = clientService.findById(id);
            return ResponseEntity.ok(clientResponseDto);
    }


    @GetMapping("/nom/{nom}")
    public ResponseEntity<ClientResponseDto> findByNom(@PathVariable String nom) {
        ClientResponseDto clientResponseDto = clientService.findByNom(nom);
        return ResponseEntity.ok(clientResponseDto);
    }


    @DeleteMapping("id/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("id/{id}")
    public ResponseEntity<ClientResponseDto> update(@Valid @RequestBody ClientRequestDto clientRequestDto,@PathVariable Integer id) {
        ClientResponseDto clientResponseDto = clientService.update(clientRequestDto, id);
        return ResponseEntity.accepted().body(clientResponseDto);
    }
}

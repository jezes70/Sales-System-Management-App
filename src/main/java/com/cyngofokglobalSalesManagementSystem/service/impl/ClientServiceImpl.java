package com.cyngofokglobalSalesManagementSystem.service.impl;

import com.cyngofokglobalSalesManagementSystem.dto.ClientDTO;
import com.cyngofokglobalSalesManagementSystem.entity.Client;
import com.cyngofokglobalSalesManagementSystem.exception.ResourceNotFoundException;
import com.cyngofokglobalSalesManagementSystem.repository.ClientRepository;
import com.cyngofokglobalSalesManagementSystem.service.ClientService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ModelMapper modelMapper;

    public ClientServiceImpl(ClientRepository clientRepository,
                             ModelMapper modelMapper) {
        this.clientRepository = clientRepository;
        this.modelMapper = modelMapper;
    }
    public List<ClientDTO> getAllClients() {
        return clientRepository.findAll().stream()
                .map(client -> modelMapper.map(client, ClientDTO.class))
                .collect(Collectors.toList());
    }
    public ClientDTO createClient(ClientDTO clientDTO) {
        Client client = modelMapper.map(clientDTO, Client.class);
        Client saved = clientRepository.save(client);
        return modelMapper.map(saved, ClientDTO.class);
    }
    public ClientDTO updateClient(Long id, ClientDTO clientDTO) {
        Client existing = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found with id: " + id));

        modelMapper.map(clientDTO, existing);
        Client updated = clientRepository.save(existing);
        return modelMapper.map(updated, ClientDTO.class);
    }
    public void deleteClient(Long id) {
        Client existing = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found with id: " + id));
        clientRepository.delete(existing);
    }
}

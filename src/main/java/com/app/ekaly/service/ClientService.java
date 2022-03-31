package com.app.ekaly.service;

import com.app.ekaly.model.Client;
import com.app.ekaly.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> ListAllClient() {
        return clientRepository.findAll();
    }

    public void saveClient(Client client) {
        clientRepository.save(client);
    }

    public Client getClientById(Long id){
       return clientRepository.findById(id).get();
    }

    public Client getClientByEmail(String email){
        return clientRepository.findByEmail(email);
    }

    public void deleteClient(Long id){
        clientRepository.deleteById(id);
    }
}

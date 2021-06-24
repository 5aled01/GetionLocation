package com.iscae.GetionLocation.service;

import com.iscae.GetionLocation.model.Client;
import com.iscae.GetionLocation.model.Terrain;
import com.iscae.GetionLocation.repo.ClientRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClientService {
    private  final ClientRepo clientRepo;

    public ClientService(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }


    public List<Client> findAllClient(){
        return clientRepo.findAll();
    }

    public  Client findClientById(long id){
        return  clientRepo.findClientById(id);
    }
    public void deleteClient(Long id){
        clientRepo.deleteById(id);
    }

    public Client addClient(Client client){
        return clientRepo.save(client);
    }


    public Client updateClient(Client client){
        return clientRepo.save(client);
    }

    public Optional<Client> findClientByIdd(Long id) {
        return  clientRepo.findById(id);
    }
}

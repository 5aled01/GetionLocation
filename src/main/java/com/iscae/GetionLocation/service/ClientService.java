package com.iscae.GetionLocation.service;

import com.iscae.GetionLocation.model.Client;
import com.iscae.GetionLocation.model.ProC2;
import com.iscae.GetionLocation.repo.ClientRepo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClientService {
    private  final ClientRepo clientRepo;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public ClientService(ClientRepo clientRepo, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.clientRepo = clientRepo;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    public List<Client> findAllClient(){
        return clientRepo.findAll();
    }

    public  Client findClientById(long id){
        return  clientRepo.findClientById(id);
    }

    public boolean findClientNom(String nom, String password) {
        boolean userExists = clientRepo.findClientByNom(nom).isPresent();
        if(!userExists) {
            return false;
        }
        String passCode = clientRepo.findPasswordByNomNative(nom);
        if(bCryptPasswordEncoder.matches(password,passCode)){
            return true;
        }
        return false;

    }

    public Client findUserByUsername2(String nom) {
        return clientRepo.findClientByNom2(nom);
    }


    public void deleteClient(Long id){
        clientRepo.deleteById(id);
    }

    public Client addClient(Client client){
        String encodedPassword = bCryptPasswordEncoder.encode(client.getPassword());
        client.setPassword(encodedPassword);
        return clientRepo.save(client);
    }


    public Client updateClient(Client client){
        return clientRepo.save(client);
    }

    public Optional<Client> findClientByIdd(Long id) {
        return  clientRepo.findById(id);
    }
}

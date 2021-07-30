package com.iscae.GetionLocation.service;

import com.iscae.GetionLocation.model.Client;
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

    public boolean findClientAuthnom(String Authnom, String password) {
        boolean userExists = clientRepo.findClientByAuthnom(Authnom).isPresent();
        if(!userExists) {
            return false;
        }
        String passCode = clientRepo.findPasswordByAuthnomNative(Authnom);
        if(bCryptPasswordEncoder.matches(password,passCode)){
            return true;
        }
        return false;

    }

    public boolean findClientAuthnom3(String Authnom) {
        boolean userExists = clientRepo.findClientByAuthnom(Authnom).isPresent();
        if(userExists) {
            return true;
        }
        return false;

    }



    public Client findUserByAuthnom2(String nom) {
        return clientRepo.findClientByAuthnom2(nom);
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

        String encodedPassword = bCryptPasswordEncoder.encode(client.getPassword());
        client.setPassword(encodedPassword);
        return clientRepo.save(client);
    }

    public Optional<Client> findClientByIdd(Long id) {
        return  clientRepo.findById(id);
    }

    public Client findClientById1(long id) {
        return clientRepo.findById(id);
    }
}

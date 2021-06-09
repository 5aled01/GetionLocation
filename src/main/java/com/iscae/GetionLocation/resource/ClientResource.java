package com.iscae.GetionLocation.resource;

import com.iscae.GetionLocation.model.Client;
import com.iscae.GetionLocation.model.Terrain;
import com.iscae.GetionLocation.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientResource {
    private final ClientService clientService ;

    public ClientResource(ClientService clientService) {
        this.clientService = clientService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<Client>> getAllClient() {
        List<Client> clients = clientService.findAllClient();

        return new ResponseEntity<>(clients, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public Optional<Client> findClientById(@RequestParam("id") Long  id) {
        Optional<Client> client = clientService.findTerrainById(id);

        return client;
    }

    @PostMapping(value = "/add")

    public ResponseEntity<Client> addClient (@RequestBody Client client ) throws IOException {

        clientService.addClient(client);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @PutMapping("/update")
    public ResponseEntity<Client> updateClient(@RequestBody Client client ) throws IOException {

        Client updateClient = clientService.updateClient(client);
        return new ResponseEntity<>(updateClient, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable("id") Long id) {
        clientService.deleteClient(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

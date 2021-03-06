package com.iscae.GetionLocation.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iscae.GetionLocation.model.Client;

import com.iscae.GetionLocation.model.Location;
import com.iscae.GetionLocation.model.Proprietaire;
import com.iscae.GetionLocation.model.User;
import com.iscae.GetionLocation.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

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
        for (Client client : clients) {
            if(client.getImage()!=null)
                client.setImage(decompressBytes(client.getImage()));
        }
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @GetMapping("/findclient/{id}")
    public ResponseEntity<Client> findLocationById(@PathVariable("id") long  id) {
        Client client = clientService.findClientById1(id);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }
    @GetMapping("/find/{username}&{password}")
    public ResponseEntity<Client> getClientByUsernameAndPassword(@PathVariable("username") String username,
                                                                      @PathVariable("password") String password) {

        boolean auth = clientService.findClientAuthnom(username, password);
        if (auth) {
            Client client = clientService.findUserByAuthnom2(username);
            if(!client.getImage().equals(null)) {
                client.setImage(decompressBytes(client.getImage()));
            }

            return new ResponseEntity<>(client, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }

    @PostMapping(value = "/add")

    public ResponseEntity<Client> addClient(@RequestParam("client") String clientst , @RequestParam("imageFile") MultipartFile imageFile ) throws IOException {

        Client client = new ObjectMapper().readValue(clientst, Client.class);
    System.out.print(client);
        boolean is = clientService.findClientAuthnom3(client.getAuthnom());
        if (is) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }

        if(imageFile!=null)
        client.setImage(compressBytes(imageFile.getBytes()));

        clientService.addClient(client);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }
    @PostMapping(value = "/add1")

    public ResponseEntity<Client> addClient1 (@RequestBody Client client) throws IOException {
             Client client1=  clientService.addClient(client);
        return new ResponseEntity<>(client1,HttpStatus.CREATED);

    }



    @PutMapping("/update")
    public ResponseEntity<Client> updateClient(@RequestParam("client") String clientst ) throws IOException {

        Client client = new ObjectMapper().readValue(clientst, Client.class);
        Client client1 = clientService.findClientById(client.getId());
        client.setImage(client1.getImage());
        Client updateClient = clientService.updateClient(client);
        return new ResponseEntity<>(updateClient, HttpStatus.OK);
    }
    @PutMapping("/updatewithimg")
    public ResponseEntity<Client> updateClientwith(@RequestParam("client") String clientst , @RequestParam("imageFile") MultipartFile imageFile ) throws IOException {

        Client client = new ObjectMapper().reader().forType(Client.class).readValue(clientst);

        client.setImage(compressBytes(imageFile.getBytes()));
        Client updateClient = clientService.updateClient(client);
        return new ResponseEntity<>(updateClient, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable("id") Long id) {
        clientService.deleteClient(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
    public static byte[] compressBytes(byte[] data) {

        Deflater deflater = new Deflater();

        deflater.setInput(data);

        deflater.finish();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);

        byte[] buffer = new byte[1024];

        while (!deflater.finished()) {

            int count = deflater.deflate(buffer);

            outputStream.write(buffer, 0, count);
        }

        try {

            outputStream.close();

        } catch (IOException e) {

        }

        //  System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

        return outputStream.toByteArray();

    }

    public static byte[] decompressBytes(byte[] data) {

        Inflater inflater = new Inflater();

        inflater.setInput(data);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);

        byte[] buffer = new byte[1024];

        try {

            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);

                outputStream.write(buffer, 0, count);

            }

            outputStream.close();

        } catch (IOException ioe) {

        } catch (DataFormatException e) {

        }

        return outputStream.toByteArray();

    }

}

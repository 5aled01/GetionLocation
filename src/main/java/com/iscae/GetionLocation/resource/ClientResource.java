package com.iscae.GetionLocation.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iscae.GetionLocation.model.Client;
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

        return new ResponseEntity<>(clients, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public Optional<Client> findClientById(@RequestParam("id") Long  id) {
        Optional<Client> client = clientService.findClientById(id);

        return client;
    }

    @PostMapping(value = "/add")

    public ResponseEntity<Client> addClient (@RequestParam("Client") String clientst , @RequestParam("imageFile") MultipartFile imageFile ) throws IOException {

        Client client = new ObjectMapper().readValue(clientst, Client.class);
        client.setImage(compressBytes(imageFile.getBytes()));

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

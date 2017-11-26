package shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import shop.models.Client;
import shop.models.Product;
import shop.services.ClientService;

import java.util.List;

@RestController
@RequestMapping(value = "/shop/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "/createClient", method = RequestMethod.POST)
    public boolean createClient(@RequestBody Client client){
        return clientService.createClient(client);
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<Client> findAllClients(){
        return clientService.findAllClients();
    }
}

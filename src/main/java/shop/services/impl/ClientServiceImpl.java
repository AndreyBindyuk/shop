package shop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shop.dao.ClientRepository;
import shop.models.Client;
import shop.services.ClientService;

import java.util.List;

@Component
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;


    public boolean createClient(Client client) {
        return clientRepository.insert(client) != null;
    }

    public List<Client> findAllClients() {
        return clientRepository.findAll();
    }
}

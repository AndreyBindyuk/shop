package shop.services;

import shop.models.Client;

import java.util.List;

public interface ClientService {

    boolean createClient(Client client);
    List<Client> findAllClients();
}

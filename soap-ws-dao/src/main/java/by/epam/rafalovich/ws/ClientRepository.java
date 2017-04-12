package by.epam.rafalovich.ws;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClientRepository {

    private static final List<Client> clients = new ArrayList<>();

    @PostConstruct
    public void initData() {

        Client client = new Client();
        client.setAge(18);
        client.setName("Dima");
        client.setSurname("Rafalovich");

        Client client2 = new Client();
        client2.setAge(182);
        client2.setName("Dima2");
        client2.setSurname("Rafalovich2");

        clients.add(client);
        clients.add(client2);
    }

    public Client findClient(String surname) {

        for (Client x : clients) {
            if (x.getSurname().equals(surname)) {
                return x;
            }
        }
        return null;
    }

    public List<Client> findAll() {
        return clients;
    }
}

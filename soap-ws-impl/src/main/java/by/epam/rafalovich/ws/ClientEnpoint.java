package by.epam.rafalovich.ws;

import by.epam.rafalovich.types.ClientType;
import by.epam.rafalovich.types.GetAllClientResponseType;
import by.epam.rafalovich.types.GetClientRequestType;
import by.epam.rafalovich.types.GetClientResponseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class ClientEnpoint {

    private static final String NAMESPACE_URI = "types.rafalovich.epam.by";

    private ClientRepository clientRepository;

    @Autowired
    public ClientEnpoint(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getClientRequestType")
    @ResponsePayload
    public GetClientResponseType getClient(@RequestPayload GetClientRequestType request) {

        GetClientResponseType response = new GetClientResponseType();
        Client client = clientRepository.findClient(request.getSurname());
        ClientType clientType = new ClientType();
        clientType.setName(client.getName());
        clientType.setSurname(client.getSurname());
        clientType.setAge(client.getAge());
        response.setClient(clientType);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "emptyRequestType")
    @ResponsePayload
    public GetAllClientResponseType getAllClients() {
        GetAllClientResponseType response = new GetAllClientResponseType();
        List<Client> clients = clientRepository.findAll();
        List<ClientType> clientTypes = response.getClient();
        for (Client client: clients) {
            ClientType clientType = new ClientType();
            clientType.setName(client.getName());
            clientType.setSurname(client.getSurname());
            clientType.setAge(client.getAge());
            clientTypes.add(clientType);
        }
        return response;
    }
}

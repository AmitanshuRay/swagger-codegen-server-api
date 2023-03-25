package io.swagger.service;

import io.swagger.model.Server;
import io.swagger.repsoitory.ServerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServerService {
    @Autowired
    ServerRepository repository;
    public List<Server> getAllServers(){
        return repository.findAll();
    }

    // Getting a specific book by id
    public Server getById(String id){
        return repository.getById(id);
    }

    public List<Server> getByName(String name){
        return repository.findByName(name);
    }

    public void addServer(Server body){
        Server server = new Server();
        server.setId(body.getId());
        server.setName(body.getName());
        server.setLanguage(body.getLanguage());
        server.setPlatform(body.getPlatform());
        repository.save(server);
    }

    public void deleteServer(String id){
        Server server = repository.getById(id);
        if(server != null){
            repository.delete(server);
        }
    }
}

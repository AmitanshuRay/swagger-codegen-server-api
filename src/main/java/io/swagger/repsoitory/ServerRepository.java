package io.swagger.repsoitory;

import io.swagger.model.Server;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ServerRepository extends MongoRepository<Server, String> {
    List<Server> findByName(String name);
    Server getById(String id);
}

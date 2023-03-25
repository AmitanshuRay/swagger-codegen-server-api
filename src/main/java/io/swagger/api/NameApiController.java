package io.swagger.api;

import io.swagger.model.Server;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.service.ServerService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Generated;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-03-25T01:54:50.682052577Z[GMT]")
@RestController
public class NameApiController implements NameApi {
    private static final Logger log = LoggerFactory.getLogger(NameApiController.class);

    private ServerService serverService;
    private final ObjectMapper objectMapper;
    private final HttpServletRequest request;

    @Autowired
    public NameApiController(ObjectMapper objectMapper, HttpServletRequest request, ServerService serverService) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.serverService = serverService;
    }

    // return servers containing the {name} string in their name
    @GetMapping("/name/{name}")
    @ResponseBody
    public ResponseEntity<List<Server>> returnByName(@Parameter(in = ParameterIn.PATH, description = "server names", required=true, schema=@Schema()) @PathVariable("name") String name) {
        List<Server> servers = new ArrayList<>();
        for(Server s: serverService.getAllServers()){
            if(s.getName().contains(name)){
                servers.add(s);
            }
        }
        if(!servers.isEmpty()){
            return new ResponseEntity<List<Server>>(servers, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

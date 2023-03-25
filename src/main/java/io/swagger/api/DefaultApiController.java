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
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-03-25T01:54:50.682052577Z[GMT]")
@RestController
public class DefaultApiController implements DefaultApi {
    @Autowired
    private ServerService serverService;

    private static final Logger log = LoggerFactory.getLogger(DefaultApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    public DefaultApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }
    
    // add a server object
    @PutMapping("/")
    @ResponseBody
    public ResponseEntity<Void> addServer(@Parameter(in = ParameterIn.DEFAULT, description = "server object", schema=@Schema()) @Valid @RequestBody Server body) {
        String accept = request.getHeader("Accept");
        serverService.addServer(body);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    
    // return all server objects in the collection
    @GetMapping("/")
    @ResponseBody
    public ResponseEntity<List<Server>> returnAllServers(){
        return new ResponseEntity<List<Server>>(serverService.getAllServers(), HttpStatus.OK);
    }

}

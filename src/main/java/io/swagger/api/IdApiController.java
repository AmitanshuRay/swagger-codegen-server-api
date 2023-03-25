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

@Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-03-25T01:54:50.682052577Z[GMT]")
@RestController
public class IdApiController implements IdApi {
    private static final Logger log = LoggerFactory.getLogger(IdApiController.class);

    private final ObjectMapper objectMapper;
    private final HttpServletRequest request;
    private ServerService serverService;
    
    @Autowired
    public IdApiController(ObjectMapper objectMapper, HttpServletRequest request, ServerService serverService) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.serverService = serverService;
    }

    // delete a server using id
    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Void> deleteById(@Parameter(in = ParameterIn.PATH, description = "server with this id to delete", required=true, schema=@Schema()) @PathVariable("id") String id) {
        Server s = serverService.getById(id);
        if(s != null){
            serverService.deleteServer(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    // retun a server using id
    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Server> returnById(@Parameter(in = ParameterIn.PATH, description = "server ID", required=true, schema=@Schema()) @PathVariable("id") String id) {
        Server s = serverService.getById(id);
        if(s != null) {
            return new ResponseEntity<Server>(serverService.getById(id), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

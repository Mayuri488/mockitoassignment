package com.yash.controller;

import com.yash.exception.ClientAlreadyExistsException;
import com.yash.exception.ErrorResponse;
import com.yash.exception.OrganizationNotFoundException;
import com.yash.response.AddClientJson;
import com.yash.response.OrganizationJson;
import com.yash.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by mayuri.patil on 27-09-2017.
 */

@RestController
public class ClientController {


    @ExceptionHandler(ClientAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> exceptionHandlerNotFound(Exception ex) {
        ErrorResponse error = new ErrorResponse();
        error.setErrorCode(HttpStatus.FORBIDDEN.value());
        error.setMessage(ex.getMessage());
        return new ResponseEntity<ErrorResponse>(error, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
        ErrorResponse error = new ErrorResponse();
        error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.setMessage("Something Went Wrong");
        return new ResponseEntity<ErrorResponse>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }




    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "/org/clients",method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
    public ResponseEntity<List<OrganizationJson>> retrieveAllOrgWithClients() throws  Exception, OrganizationNotFoundException {
        System.out.print("************\n");
        List<OrganizationJson> organizationJsonList=clientService.retrieveAllClients();
        System.out.println(organizationJsonList);
        return new ResponseEntity<List<OrganizationJson>>(organizationJsonList,HttpStatus.OK);
    }

    @RequestMapping(value = "/org/client", method = RequestMethod.POST)
    public ResponseEntity addClient(@RequestBody(required = true) AddClientJson client) throws OrganizationNotFoundException,Exception{
            clientService.addClient(client);
            return new ResponseEntity<>("Client Inserted Successfully.",HttpStatus.CREATED);
    }

    @RequestMapping(value = "/org/client/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteClientById(@PathVariable(value="id" ) Integer clientId) throws OrganizationNotFoundException,Exception{
        clientService.deleteClient(clientId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

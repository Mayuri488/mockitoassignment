package com.yash.controller;

import com.yash.jsonclasses.FieldResponseJson;
import com.yash.exception.ErrorResponse;
import com.yash.exception.OrganizationNotFoundException;
import com.yash.model.Organization;
import com.yash.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by mayuri.patil on 19-09-2017.
 */
@RestController
public class OrganizationController {


    @ExceptionHandler(OrganizationNotFoundException.class)
    public ResponseEntity<ErrorResponse> exceptionHandlerNotFound(Exception ex) {
        ErrorResponse error = new ErrorResponse();
        error.setErrorCode(HttpStatus.NOT_FOUND.value());
        error.setMessage(ex.getMessage());
        return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
        ErrorResponse error = new ErrorResponse();
        error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.setMessage("Something Went Wrong");
        return new ResponseEntity<ErrorResponse>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }



    @Autowired
    private OrganizationService organizationService;

    @RequestMapping(value = "/org/{id}",method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
    public ResponseEntity<Organization> getOrgById(@PathVariable(value="id" ) Integer orgId) throws  Exception, OrganizationNotFoundException{

        System.out.print("************\n");

            Organization organization = organizationService.findOrgById(orgId);
            System.out.println(organization);
            return new ResponseEntity<Organization>(organization, HttpStatus.OK);

    }

    @RequestMapping(value = "org/{orgId}/field/{fieldId}/field",method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
    public ResponseEntity<Organization> getFieldsDetails(@PathVariable(value="orgId" ) Integer orgId,@PathVariable(value="fieldId" ) Integer fieldId) throws  OrganizationNotFoundException{
        System.out.println("################");
        FieldResponseJson fieldResponseJson = organizationService.getFieldsDetails(orgId, fieldId);
        return new ResponseEntity(fieldResponseJson, HttpStatus.OK);
    }

    //http://localhost:9090/SpringRequestMappingExample/home/method9?id=20


    @RequestMapping(value = "/fields/{fieldId}/orgs/{orgId}/field",method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
    public ResponseEntity<Organization> getAllDetails(@PathVariable(value="orgId" ) Integer orgId,@PathVariable(value="fieldId" ) Integer fieldId,@RequestParam(value="client") Integer clientId) throws  OrganizationNotFoundException{
        System.out.println("============================");
        Organization organization = organizationService.getAllDetails(orgId, fieldId);
        return new ResponseEntity(organization, HttpStatus.OK);
    }
}

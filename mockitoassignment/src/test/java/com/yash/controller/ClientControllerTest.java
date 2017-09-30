package com.yash.controller;

import com.yash.response.ClientJson;
import com.yash.response.OrganizationJson;
import com.yash.service.ClientService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

/**
 * Created by mayuri.patil on 28-09-2017.
 */

@RunWith(MockitoJUnitRunner.class)
public class ClientControllerTest
{
    @InjectMocks
    private ClientController clientController;

    @Mock
    private ClientService clientService;

    @Test
    public void retrieveAllOrgWithClientsTest() throws Exception {
        List<OrganizationJson> organizationJsonList=getData();
        when(clientService.retrieveAllClients()).thenReturn(organizationJsonList);
        ResponseEntity<List<OrganizationJson>> list= clientController.retrieveAllOrgWithClients();
        Assert.assertNotNull(list);
    }
    @Test
    public void retrieveAllOrgWithEmptyClientsTest() throws Exception {
        when(clientService.retrieveAllClients()).thenReturn(null);
        ResponseEntity<List<OrganizationJson>> list= clientController.retrieveAllOrgWithClients();
        //chk size
    }

    private List<OrganizationJson> getData(){

        ClientJson clientJson1=new ClientJson();
        clientJson1.setClientName("Client1");
        clientJson1.setClientId(1);
        ClientJson clientJson2=new ClientJson();
        clientJson2.setClientName("Client2");
        clientJson2.setClientId(1);
        ClientJson clientJson3=new ClientJson();
        clientJson3.setClientName("Client3");
        clientJson3.setClientId(1);
        List<ClientJson> clientJsons=new ArrayList<>();
        clientJsons.add(clientJson1);
        clientJsons.add(clientJson2);
        clientJsons.add(clientJson3);
        List<OrganizationJson> organizationJsons=new ArrayList<>();
        OrganizationJson organizationJson=new OrganizationJson();
        organizationJson.setOrgName("Yash");
        organizationJson.setOrgId(1);
        organizationJson.setClientJsonList(clientJsons);
        organizationJsons.add(organizationJson);

        return  organizationJsons;
    }
}

package com.yash.controller;

import com.yash.dao.ClientDao;
import com.yash.response.ClientJson;
import com.yash.response.OrganizationJson;
import com.yash.service.ClientServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

/**
 * Created by mayuri.patil on 28-09-2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class ClientServiceTest
{
    @InjectMocks
    private ClientServiceImpl clientService;

    @Mock
    private ClientDao clientDao;

    @Test
    public void retrieveAllOrgwithClientsTest(){

        when(clientDao.retrieveAllClients()).thenReturn(getData());
        Assert.assertNotNull(clientDao.retrieveAllClients());
        clientDao.retrieveAllClients();
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

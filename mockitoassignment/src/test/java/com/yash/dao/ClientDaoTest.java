package com.yash.dao;

import com.yash.exception.ClientAlreadyExistsException;
import com.yash.response.AddClientJson;
import com.yash.response.ClientJson;
import com.yash.response.OrganizationJson;
import com.yash.resultsetextratcor.OrganizationAndClientResultSetExtractor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.when;

/**
 * Created by mayuri.patil on 28-09-2017.
 */

@RunWith(MockitoJUnitRunner.class)
public class ClientDaoTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private ClientDaoImpl clientDao;

    @Test
    public void retrieveAllOrgwithClientsTest(){
        when(jdbcTemplate.query(anyString(),any(Objects[].class),any(OrganizationAndClientResultSetExtractor.class))).thenReturn(getData());
        assertNotNull(jdbcTemplate.query(anyString(),any(Objects[].class),any(OrganizationAndClientResultSetExtractor.class)));
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

    @Test
    public void addClient() {
        AddClientJson addClientJson=new AddClientJson();
        addClientJson.setOrgId(1);
        addClientJson.setClientId(1);
        addClientJson.setClientName("Client111");
        when(jdbcTemplate.update(anyString(),anyInt(),anyString(),anyInt())).thenReturn(1);
        when(jdbcTemplate.update(anyString())).thenReturn(1);
        jdbcTemplate.update(anyString(),anyInt(),anyString(),anyInt());
        int i=clientDao.addClient(addClientJson);
        assertEquals(1,i);
    }

    @Test(expected = ClientAlreadyExistsException.class)
    public void addClientShuoldThrowException() {
        AddClientJson addClientJson=new AddClientJson();
        addClientJson.setOrgId(1);
        addClientJson.setClientId(1);
        addClientJson.setClientName("Client111");
        when(jdbcTemplate.update(anyString(),anyInt(),anyString(),anyInt())).thenThrow(new ClientAlreadyExistsException());
        int i=clientDao.addClient(addClientJson);
        assertEquals(0,1);
    }

    @Test
    public void deleteClientTest(){

        when(jdbcTemplate.update(anyString(),anyInt())).thenReturn(1);
        int i=clientDao.deleteClient(10);
        assertEquals(1,i);
    }

}

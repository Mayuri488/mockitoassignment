package com.yash.service;

import com.yash.dao.ClientDao;
import com.yash.response.AddClientJson;
import com.yash.response.OrganizationJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mayuri.patil on 27-09-2017.
 */

@Service
public class ClientServiceImpl implements  ClientService {

    @Autowired
    private ClientDao clientDao;

    public List<OrganizationJson> retrieveAllClients(){
        List<OrganizationJson> organizationJsons=clientDao.retrieveAllClients();
    return organizationJsons;
    }

    @Override
    public int addClient(AddClientJson clientJson) {
        return clientDao.addClient(clientJson);
    }

    @Override
    public int deleteClient(Integer clientId) {
        return clientDao.deleteClient(clientId);
    }
}

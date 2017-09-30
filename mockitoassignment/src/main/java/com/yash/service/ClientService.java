package com.yash.service;

import com.yash.response.AddClientJson;
import com.yash.response.OrganizationJson;

import java.util.List;

/**
 * Created by mayuri.patil on 27-09-2017.
 */
public interface ClientService {
    public List<OrganizationJson> retrieveAllClients();
    public int addClient(AddClientJson clientJson);
    public int deleteClient(Integer clientId);

}

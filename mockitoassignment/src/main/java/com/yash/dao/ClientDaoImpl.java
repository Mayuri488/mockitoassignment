package com.yash.dao;

import com.yash.exception.ClientAlreadyExistsException;
import com.yash.response.AddClientJson;
import com.yash.response.OrganizationJson;
import com.yash.resultsetextratcor.OrganizationAndClientResultSetExtractor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by mayuri.patil on 27-09-2017.
 */

@Repository
public class ClientDaoImpl implements ClientDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<OrganizationJson> retrieveAllClients() {
        LOGGER.info("In retrieveAllClients Dao...");
        String query="SELECT c.*,o.* FROM client as c inner join organization o on o.orgId = c.orgId";
        List<OrganizationJson> organizationJson = jdbcTemplate.query(query, new Object[]{}, new OrganizationAndClientResultSetExtractor());
        LOGGER.info("organizationJson  :  "+organizationJson);
        return  organizationJson;
    }

    @Override
    public int addClient(AddClientJson clientJson) {
        LOGGER.info("In addClient Dao...");
        try{
            return jdbcTemplate.update(
                    "INSERT INTO CLIENT(clientId, clientName,orgId) VALUES(?,?,?)", new Object[]{
                            clientJson.getClientId(), clientJson.getClientName(),clientJson.getOrgId()});
        }
        catch (DuplicateKeyException d){
            throw new ClientAlreadyExistsException("Client exists with given id");
        }


    }

    @Override
    public int deleteClient(Integer clientId) {
        LOGGER.info("In addClient Dao...");
        int i=0;
        try{
            i= jdbcTemplate.update("DELETE from CLIENT WHERE clientId = ?", new Object[]{clientId});
        }
        catch (Exception e){
            LOGGER.info(e.getMessage());
        }
        return i;
    }
}

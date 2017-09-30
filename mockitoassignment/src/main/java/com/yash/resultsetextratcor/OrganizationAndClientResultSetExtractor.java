package com.yash.resultsetextratcor;

import com.yash.response.ClientJson;
import com.yash.response.OrganizationJson;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mayuri.patil on 27-09-2017.
 */
public class OrganizationAndClientResultSetExtractor implements ResultSetExtractor<List<OrganizationJson>>
{


    List<ClientJson> clientList=null;
    List<OrganizationJson> organizationList=null;
    OrganizationJson organizationJson=null;
    ClientJson clientJson=null;

    @Override
    public List<OrganizationJson> extractData(ResultSet resultSet) throws SQLException, DataAccessException {

        while (resultSet.next()) {
            Integer clientId = resultSet.getInt("clientId");
            String clientName = resultSet.getString("clientName");
            clientJson = new ClientJson();
            clientJson.setClientId(clientId);
            clientJson.setClientName(clientName);
            if (clientList == null) {
                clientList = new ArrayList<>();
            }
            clientList.add(clientJson);
            Integer orgId = resultSet.getInt("orgId");
            String orgName = resultSet.getString("orgName");
            if (organizationList == null) {
                organizationList = new ArrayList<>();
            }
            organizationJson=new OrganizationJson();
            organizationJson.setOrgId(orgId);
            organizationJson.setOrgName(orgName);
            organizationJson.setClientJsonList(clientList);

            organizationList.add(organizationJson);
        }
        return organizationList;
    }
}

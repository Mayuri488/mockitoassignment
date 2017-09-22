package com.yash.resultsetextratcor;

import com.yash.exception.OrganizationNotFoundException;
import com.yash.model.Client;
import com.yash.model.Farm;
import com.yash.model.Field;
import com.yash.model.Organization;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mayuri.patil on 22-09-2017.
 */
public class AllDataExtrator implements ResultSetExtractor<Organization> {

    @Override
    public Organization extractData(ResultSet resultSet) throws SQLException, DataAccessException {

        List<Field> fieldList=new ArrayList<>();
        List<Farm> farmList=new ArrayList<>();
        List<Client> clientList=new ArrayList<>();
        List<Organization> organizationList=new ArrayList<>();
        Organization organization=new Organization();



        while (resultSet.next()) {
            System.out.println("In resultset iterator");
            int filedId = resultSet.getInt("fieldId");
            String filedName = resultSet.getString("fieldName");
            Field field = new Field(filedId, filedName);
            fieldList.add(field);

            Integer farmId = resultSet.getInt("FromId");
            String farmName = resultSet.getString("fromName");
            Farm farm = new Farm(farmId, farmName);
            farm.setFieldList(fieldList);
            farmList.add(farm);

            farm.setFieldList(fieldList);

            Integer clientId = resultSet.getInt("clientId");
            String clientName = resultSet.getString("clientNamr");
            Client client = new Client(clientId, clientName);
            client.setFarmList(farmList);
            clientList.add(client);

            Integer orgId = resultSet.getInt("orgId");
            String orgName = resultSet.getString("orgName");
            organization = new Organization(orgId, orgName);
            organization.setClientList(clientList);
        }


        return organization;
    }

    private void resultSetEntryNullCheck(ResultSet resultSet)  throws  SQLException{
        if(resultSet.next()==false){
            System.out.println("In ResultSet False Checxk");
            throw new OrganizationNotFoundException("Organization Not Found");
        }
    }
}

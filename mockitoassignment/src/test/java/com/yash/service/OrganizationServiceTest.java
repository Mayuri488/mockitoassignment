package com.yash.service;

import com.yash.dao.OrganizationDao;
import com.yash.jsonclasses.FieldResponseJson;
import com.yash.model.Client;
import com.yash.model.Farm;
import com.yash.model.Field;
import com.yash.model.Organization;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Created by mayuri.patil on 20-09-2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class OrganizationServiceTest {

    @InjectMocks
    private OrganizationServiceImpl organizationService;

    @Mock
    private OrganizationDao organizationDao;

    @Test
    public void  findOrgByIdTest()
    {
        when(organizationDao.findOrgById(1)).thenReturn(new Organization(1,"Yash"));
        Organization organization=organizationService.findOrgById(1);
        Assert.assertNotNull(organization);
    }

    @Test
    public void getFieldsDetailsTest(){
        FieldResponseJson fieldResponseJson=new FieldResponseJson();
        Field field=new Field(1,"Field1");
        fieldResponseJson.setField(field);
        when(organizationDao.getFieldsDetails(1,1)).thenReturn(fieldResponseJson);
        FieldResponseJson responseJson=organizationDao.getFieldsDetails(1,1);
        Assert.assertNotNull(responseJson);
    }

    @Test
    public void getAllDetailsTest(){

        Organization organization=getData();
        when(organizationDao.getAllDetails(1,1)).thenReturn(organization);
        Organization org= organizationDao.getAllDetails(1,1);
        Assert.assertNotNull(org);
    }

    public Organization getData(){
        List<Field> fieldList=new ArrayList<>();
        List<Farm> farmList=new ArrayList<>();
        List<Client> clientList=new ArrayList<>();
        List<Organization> organizationList=new ArrayList<>();

        Field field=new Field(1,"Filed1");
        fieldList.add(field);
        Farm farm=new Farm(1,"Farm1");
        farmList.add(farm);
        farm.setFieldList(fieldList);
        Client client=new Client(1,"client1");
        clientList.add(client);
        client.setFarmList(farmList);
        Organization organization=new Organization(1,"Yash");

        organization.setClientList(clientList);
        return organization;


    }
}

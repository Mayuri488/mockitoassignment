package com.yash.service;

import com.yash.dao.OrganizationDao;
import com.yash.response.FieldResponseJson;
import com.yash.model.Client;
import com.yash.model.Farm;
import com.yash.model.Field;
import com.yash.model.Organization;
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
 * Created by mayuri.patil on 20-09-2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class OrganizationServiceTest {

    @InjectMocks
    private OrganizationServiceImpl organizationService;

    @Mock
    private OrganizationDao organizationDao;

    @Test
    public void  testForValidOrgnizationId()
    {

        when(organizationDao.findOrgById(1)).thenReturn(prepareResponseFoValidOrgnizationId());
        Organization organization=organizationService.findOrgById(1);
        Assert.assertNotNull(organization);
    }
    private Organization prepareResponseFoValidOrgnizationId()
    {
        return new Organization(1,"Yash");
    }

    @Test
    public void  testForNullOrgnizationId()
    {

        when(organizationDao.findOrgById(1)).thenReturn(null);
        Organization organization=organizationService.findOrgById(1);
        Assert.assertNull(organization);
    }


    @Test
    public void testForRetrievingFieldsDetailsTest(){
        FieldResponseJson fieldResponseJson=new FieldResponseJson();
        Field field=new Field(1,"Field1");
        fieldResponseJson.setField(field);
        when(organizationDao.getFieldsDetails(1,1)).thenReturn(fieldResponseJson);
        FieldResponseJson responseJson=organizationService.getFieldsDetails(1,1);
        Assert.assertNotNull(responseJson);
    }



    @Test
    public void testForRetrievingEmptyFieldsDetailsTest(){
        when(organizationDao.getFieldsDetails(1,1)).thenReturn(null);
        FieldResponseJson responseJson=organizationService.getFieldsDetails(1,1);
        Assert.assertNull(responseJson);
    }

    @Test
    public void testForRetrievingAllDetailsTest(){

        Organization organization=prepareResonseForOrgnization();
        when(organizationDao.getAllDetails(1,1)).thenReturn(organization);
        Organization org= organizationService.getAllDetails(1,1);
        Assert.assertNotNull(org);
    }
    @Test
    public void testForRetrievingAllDetailsTestEmpty(){

        when(organizationDao.getAllDetails(1,1)).thenReturn(null);
        Organization org= organizationService.getAllDetails(1,1);
        Assert.assertNull(org);
    }

    public Organization prepareResonseForOrgnization(){
        List<Field> fieldList=new ArrayList<>();
        List<Farm> farmList=new ArrayList<>();
        List<Client> clientList=new ArrayList<>();
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

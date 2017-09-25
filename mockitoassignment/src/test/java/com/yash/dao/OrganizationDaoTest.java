package com.yash.dao;

import com.yash.exception.OrganizationNotFoundException;
import com.yash.jsonclasses.FieldResponseJson;
import com.yash.model.Client;
import com.yash.model.Farm;
import com.yash.model.Field;
import com.yash.model.Organization;
import com.yash.resultsetextratcor.AllDataExtrator;
import com.yash.resultsetextratcor.FieldResultSetExtratcor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by mayuri.patil on 20-09-2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class OrganizationDaoTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private OrganizationDaoImpl organizationDao;


    @Mock
    RowMapper<Organization> rowMapper;


    @Test
    public void findOrgById(){
        Organization organization=new Organization(1,"Yahs");
        when(jdbcTemplate.queryForObject(anyString(),anyObject(),any(BeanPropertyRowMapper.class))).thenReturn(organization);
        Organization org=organizationDao.findOrgById(1);
        Assert.assertNotNull(org);
    }

    @Test
    public void fieldAgainstRequestedOrg(){
        FieldResponseJson fieldResponseJson=new FieldResponseJson();
        Field field=new Field(1,"Field1");
        fieldResponseJson.setField(field);
        when(jdbcTemplate.query(anyString(),any(Objects[].class),any(FieldResultSetExtratcor.class))).thenReturn(fieldResponseJson);
        organizationDao.getFieldsDetails(1,1);
        Assert.assertNotNull(organizationDao.getFieldsDetails(1,1));
    }

   @Test
    public void fetchDetailsAgainstReqClient(){
        Organization organization=getData();
       System.out.println(organization);
       when(jdbcTemplate.query(anyString(),any(Objects[].class),any(AllDataExtrator.class))).thenReturn(organization);
       organizationDao.getAllDetails(1,1);
       Assert.assertNotNull(organizationDao.getAllDetails(1,1));
   }

   @Test(expected = OrganizationNotFoundException.class)
   public void fetchDetailsAgainstReqClientThrowException(){
       when(jdbcTemplate.query(anyString(),any(Objects[].class),any(AllDataExtrator.class))).thenThrow(new OrganizationNotFoundException() );
       organizationDao.getAllDetails(3,2);
   }

    @Test(expected = OrganizationNotFoundException.class)
    public void fieldAgainstRequestedOrgThrowException(){
        when(jdbcTemplate.query(anyString(),any(Objects[].class),any(AllDataExtrator.class))).thenThrow(new OrganizationNotFoundException() );
        organizationDao.getAllDetails(1,7);
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


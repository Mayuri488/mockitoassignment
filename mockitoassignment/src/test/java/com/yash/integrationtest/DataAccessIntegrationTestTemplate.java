package com.yash.integrationtest;


import com.yash.dao.OrganizationDaoImpl;
import com.yash.jsonclasses.FieldResponseJson;
import com.yash.model.Organization;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;



public class DataAccessIntegrationTestTemplate {

    private EmbeddedDatabase db;


    OrganizationDaoImpl organizationDao =new OrganizationDaoImpl();

    @Before
    public void setUp() {
        db= new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.HSQL)
                .setScriptEncoding("UTF-8")
                .ignoreFailedDrops(true)
                .addScript("org.sql")
                //.addScript("client.sql")
                .build();
    }

    @Test
    public void testDataAccess() {
        JdbcTemplate template = new JdbcTemplate(db);
        organizationDao.setJdbcTemplate(template);
        Organization org=organizationDao.findOrgById(1);
        Assert.assertNotNull(org);
    }

    @Test
    public void getAllDetailsTestValid() {
        JdbcTemplate template = new JdbcTemplate(db);
        organizationDao.setJdbcTemplate(template);
        Organization org=organizationDao.getAllDetails(1,1);
        Assert.assertNotNull(org);
    }


    @Test
    public void getFieldDetaildByIdValid() {
        JdbcTemplate template = new JdbcTemplate(db);
        organizationDao.setJdbcTemplate(template);
        FieldResponseJson filedJsonResponse=organizationDao.getFieldsDetails(1,1);
        Assert.assertNotNull(filedJsonResponse);
    }

    @After
    public void tearDown() {
        db.shutdown();
    }

}

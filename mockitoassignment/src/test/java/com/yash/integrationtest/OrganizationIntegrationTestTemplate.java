package com.yash.integrationtest;


import com.yash.config.EntityDaoImplTest;
import com.yash.dao.OrganizationDao;
import com.yash.response.FieldResponseJson;
import com.yash.response.OrganizationJson;
import com.yash.model.Organization;
import com.yash.resultsetextratcor.OrganizationAndClientResultSetExtractor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.sql.DataSource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:droptables.sql")
@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:org.sql")
public class OrganizationIntegrationTestTemplate extends EntityDaoImplTest {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private OrganizationDao organizationDao;

    @Autowired
    private DataSource dataSource;


    @Test
    public void test()
    {
        Assert.assertNotNull(jdbcTemplate);
        Assert.assertNotNull(organizationDao);
        Assert.assertNotNull(dataSource);
    }

    @Test
    public void testOrgByID() {
        Organization org=organizationDao.findOrgById(5);
        Assert.assertNotNull(org);
    }

    @Test
    public void getAllDetailsTestValid() {

        Organization org=organizationDao.getAllDetails(1,1);
        Assert.assertNotNull(org);
    }



    @Test
    public void getFieldDetaildByIdValid() {

        FieldResponseJson filedJsonResponse=organizationDao.getFieldsDetails(1,1);
        Assert.assertNotNull(filedJsonResponse);
    }
    @Test
    public void retrieveClientAndOrg() {

        String query="SELECT c.*,o.* FROM client as c inner join organization o on o.orgId = c.orgId";
        List<OrganizationJson> organizationJson = jdbcTemplate.query(query, new Object[]{}, new OrganizationAndClientResultSetExtractor());
        Assert.assertNotNull(organizationJson);
    }

}

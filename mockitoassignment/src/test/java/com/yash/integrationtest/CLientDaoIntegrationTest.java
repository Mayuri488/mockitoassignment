package com.yash.integrationtest;

import com.yash.config.EntityDaoImplTest;
import com.yash.dao.ClientDao;
import com.yash.exception.ClientAlreadyExistsException;
import com.yash.response.AddClientJson;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.sql.DataSource;

/**
 * Created by mayuri.patil on 28-09-2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:droptables.sql")
@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:org.sql")
public class CLientDaoIntegrationTest extends EntityDaoImplTest{



    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ClientDao clientDao;

    @Autowired
    private DataSource dataSource;


    @Test
    public void test()
    {
        Assert.assertNotNull(jdbcTemplate);
        Assert.assertNotNull(clientDao);
        Assert.assertNotNull(dataSource);
    }

    @Test
    public void addClient() {
        AddClientJson addClientJson=new AddClientJson();
        addClientJson.setOrgId(1);
        addClientJson.setClientId(10);
        addClientJson.setClientName("Client111");
        int i=clientDao.addClient(addClientJson);
        Assert.assertEquals(1,i);
    }

    @Test(expected = ClientAlreadyExistsException.class)
    public void addClientShuoldThrowException() {
        AddClientJson addClientJson=new AddClientJson();
        addClientJson.setOrgId(1);
        addClientJson.setClientId(1);
        addClientJson.setClientName("Client111");
        int i=clientDao.addClient(addClientJson);

    }




}

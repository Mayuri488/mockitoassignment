package com.yash.dao;

import com.yash.controller.OrganizationController;
import com.yash.exception.OrganizationNotFoundException;
import com.yash.response.FieldResponseJson;
import com.yash.model.Organization;
import com.yash.resultsetextratcor.AllDataExtrator;
import com.yash.resultsetextratcor.FieldResultSetExtratcor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by mayuri.patil on 20-09-2017.
 */

@Repository
public class OrganizationDaoImpl implements OrganizationDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrganizationDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public Organization findOrgById(Integer id) {
        try {
            Organization org = jdbcTemplate.queryForObject("SELECT * FROM organization where orgID = ? ", new Object[]{id}, new BeanPropertyRowMapper<Organization>(Organization.class));
            LOGGER.info("In findOrgById Dao...");
            return org;
        }
        catch (EmptyResultDataAccessException d){
            LOGGER.error(d.getMessage());
            throw new OrganizationNotFoundException("Organization  not Found");
        }
        catch (DataAccessException d){
            LOGGER.error(d.getMessage());
            throw new OrganizationNotFoundException("Organization  not Found");
        }
        catch (Exception d){
            LOGGER.error(d.getMessage());
            throw new OrganizationNotFoundException("Interanal Server Error");
        }
    }

    public Organization getAllDetails(Integer orgId, Integer fieldId) {

        System.out.println("In Dao");
        String query = "SELECT * FROM ORGANIZATION LEFT OUTER JOIN CLIENT ON ORGANIZATION.orgId=CLIENT.orgId " +
                "LEFT OUTER JOIN FARM ON CLIENT.clientId=FARM.clientId " +
                "LEFT OUTER JOIN FIELD ON FARM.farmId=FIELD.farmId " +
                "WHERE ORGANIZATION.orgId=? and FIELD.fieldId=? and FIELD.fieldId IS NOT NULL";


        try{
            Organization organization = jdbcTemplate.query(query, new Object[]{orgId, fieldId}, new AllDataExtrator());
            System.out.println(organization);
            return organization;

        }catch (Exception d){
            LOGGER.error(d.getMessage());
            throw new OrganizationNotFoundException("Interanal Server Error");
        }
    }

    public FieldResponseJson getFieldsDetails(Integer orgId, Integer fieldId) {

        System.out.println("In Dao");
        String query = "SELECT * FROM ORGANIZATION LEFT OUTER JOIN CLIENT ON ORGANIZATION.orgId=CLIENT.orgId " +
                "LEFT OUTER JOIN FARM ON CLIENT.clientId=FARM.clientId " +
                "LEFT OUTER JOIN FIELD ON FARM.farmId=FIELD.farmId " +
                "WHERE ORGANIZATION.orgId=? and FIELD.fieldId=? and FIELD.fieldId IS NOT NULL";


        try{
            FieldResponseJson fieldResponse = jdbcTemplate.query(query, new Object[]{orgId, fieldId}, new FieldResultSetExtratcor());
            System.out.println(fieldResponse);
            return fieldResponse;

        }catch (Exception d){
            LOGGER.error(d.getMessage());
            throw new OrganizationNotFoundException("Interanal Server Error");
        }
    }



}

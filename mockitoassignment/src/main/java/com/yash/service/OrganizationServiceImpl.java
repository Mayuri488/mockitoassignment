package com.yash.service;

import com.yash.dao.OrganizationDao;
import com.yash.response.FieldResponseJson;
import com.yash.model.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by mayuri.patil on 19-09-2017.
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationDao organizationDao;

    @Override
    public Organization findOrgById(Integer id) {
        Organization organization=organizationDao.findOrgById(id);
        return organization;
    }

    @Override
    public FieldResponseJson getFieldsDetails(Integer orgId, Integer fieldId) {
       return organizationDao.getFieldsDetails(orgId,fieldId);
    }

    @Override
    public Organization getAllDetails(Integer orgId, Integer fieldId) {
        return  organizationDao.getAllDetails(orgId,fieldId);

    }

}

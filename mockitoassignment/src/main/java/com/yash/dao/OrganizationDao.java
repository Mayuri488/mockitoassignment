package com.yash.dao;

import com.yash.response.FieldResponseJson;
import com.yash.model.Organization;

/**
 * Created by mayuri.patil on 20-09-2017.
 */
public interface OrganizationDao {
    public Organization findOrgById(Integer id);
    public FieldResponseJson getFieldsDetails(Integer orgId, Integer fieldId);
    public Organization getAllDetails(Integer orgId, Integer fieldId);
}

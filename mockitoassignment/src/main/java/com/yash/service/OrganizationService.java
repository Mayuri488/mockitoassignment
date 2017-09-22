package com.yash.service;

import com.yash.jsonclasses.FieldResponseJson;
import com.yash.model.Organization;

/**
 * Created by mayuri.patil on 19-09-2017.
 */

public interface OrganizationService {
    public Organization findOrgById(Integer id);
    public FieldResponseJson getFieldsDetails(Integer orgId, Integer fieldId);
    public Organization getAllDetails(Integer orgId,Integer fieldId);
}

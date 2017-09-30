package com.yash.response;

import java.io.Serializable;
import java.util.List;

/**
 * Created by mayuri.patil on 27-09-2017.
 */
public class OrganizationJson implements Serializable {

    private Integer orgId;
    private String orgName;

    public Integer getOrgId() {
        return orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    private List<ClientJson> clientJsonList;

    public List<ClientJson> getClientJsonList() {
        return clientJsonList;
    }

    public void setClientJsonList(List<ClientJson> clientJsonList) {
        this.clientJsonList = clientJsonList;
    }

    @Override
    public String toString() {
        return "OrganizationJson{" +
                "orgId=" + orgId +
                ", orgName='" + orgName + '\'' +
                ", clientJsonList=" + clientJsonList +
                '}';
    }
}

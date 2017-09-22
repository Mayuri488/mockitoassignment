package com.yash.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by mayuri.patil on 19-09-2017.
 */
public class Organization {

    private Integer orgId;
    private String orgName;

    @JsonProperty("client")
    private List<Client> clientList;

    public Organization(Integer orgId, String orgName) {
        this.orgId = orgId;
        this.orgName = orgName;
    }

    public Organization() {
    }


    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

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

    @Override
    public String toString() {
        return "Organization{" +
                "orgId=" + orgId +
                ", orgName='" + orgName + '\'' +
                '}';
    }
}

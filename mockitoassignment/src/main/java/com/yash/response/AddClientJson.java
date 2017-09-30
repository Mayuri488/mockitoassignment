package com.yash.response;

/**
 * Created by mayuri.patil on 28-09-2017.
 */
public class AddClientJson {
    private Integer clientId;
    private String clientName;
    private Integer orgId;

    public Integer getClientId() {
        return clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    @Override
    public String toString() {
        return "AddClientJson{" +
                "clientId=" + clientId +
                ", clientName='" + clientName + '\'' +
                ", orgId=" + orgId +
                '}';
    }
}

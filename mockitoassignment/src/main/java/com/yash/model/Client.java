package com.yash.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by mayuri.patil on 19-09-2017.
 */
public class Client {

    private Integer clientId;
    private String clientName;

    @JsonProperty("farm")
    List<Farm> farmList;

    public List<Farm> getFarmList() {
        return farmList;
    }

    public void setFarmList(List<Farm> farmList) {
        this.farmList = farmList;
    }

    public Client() {
    }

    public Client(Integer clientId, String clientName) {
        this.clientId = clientId;
        this.clientName = clientName;
    }

    public Integer getClientId() {
        return clientId;
    }

    public String getClientName() {
        return clientName;
    }


    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }


    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", clientName='" + clientName + '\'' +
                '}';
    }
}

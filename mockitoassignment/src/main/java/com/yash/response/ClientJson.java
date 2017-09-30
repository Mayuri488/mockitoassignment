package com.yash.response;

import java.io.Serializable;

/**
 * Created by mayuri.patil on 27-09-2017.
 */
public class ClientJson implements Serializable {

    private Integer clientId;
    private String clientName;


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
        return "ClientJson{" +
                "clientId=" + clientId +
                ", clientName='" + clientName + '\'' +
                '}';
    }
}

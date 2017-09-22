package com.yash.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by mayuri.patil on 19-09-2017.
 */
public class Farm {

    private Integer farmId;
    private String farmName;

    @JsonProperty("field")
    List<Field> fieldList;

    public List<Field> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<Field> fieldList) {
        this.fieldList = fieldList;
    }

    public Farm(Integer farmId, String farmName) {
        this.farmId = farmId;
        this.farmName = farmName;
    }

    public Integer getFarmId() {
        return farmId;
    }

    public String getFarmName() {
        return farmName;
    }


    public void setFarmId(Integer farmId) {
        this.farmId = farmId;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    @Override
    public String toString() {
        return "Farm{" +
                "farmId=" + farmId +
                ", farmName='" + farmName + '\'' +
                '}';
    }
}

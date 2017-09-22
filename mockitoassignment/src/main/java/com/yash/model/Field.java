package com.yash.model;

/**
 * Created by mayuri.patil on 19-09-2017.
 */
public class Field {

    private Integer fieldId;
    private String fieldName;


    public Field(Integer fieldId, String fieldName) {
        this.fieldId = fieldId;
        this.fieldName = fieldName;
    }

    public Field() {
    }

    public Integer getFieldId() {
        return fieldId;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldId(Integer fieldId) {
        this.fieldId = fieldId;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    @Override
    public String toString() {
        return "Field{" +
                "fieldId=" + fieldId +
                ", fieldName='" + fieldName + '\'' +
                '}';
    }
}

package com.yash.resultsetextratcor;

import com.yash.response.FieldResponseJson;
import com.yash.model.Field;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by mayuri.patil on 21-09-2017.
 */
public class FieldResultSetExtratcor implements ResultSetExtractor<FieldResponseJson> {

    @Override
    public FieldResponseJson extractData(ResultSet resultSet) throws SQLException, DataAccessException {


                FieldResponseJson fieldResponseJson=new FieldResponseJson();


        while (resultSet.next()) {
                System.out.println("In resultset iterator");
                int filedId = resultSet.getInt("fieldId");
                String filedName = resultSet.getString("fieldName");
                Field field = new Field(filedId, filedName);
                fieldResponseJson.setField(field);
            }


        return fieldResponseJson;
    }


}



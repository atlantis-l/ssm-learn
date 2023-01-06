package com.itheima.handle;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

public class MyTypeHandle extends BaseTypeHandler<LocalDate> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, LocalDate localDate, JdbcType jdbcType) throws SQLException {
        long l = localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
        preparedStatement.setLong(i, l);
    }

    @Override
    public LocalDate getNullableResult(ResultSet resultSet, String s) throws SQLException {
        Instant instant = Instant.ofEpochMilli(resultSet.getLong(s));
        return instant.atZone(ZoneId.systemDefault()).toLocalDate();
    }

    @Override
    public LocalDate getNullableResult(ResultSet resultSet, int i) throws SQLException {
        Instant instant = Instant.ofEpochMilli(resultSet.getLong(i));
        return instant.atZone(ZoneId.systemDefault()).toLocalDate();
    }

    @Override
    public LocalDate getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        Instant instant = Instant.ofEpochMilli(callableStatement.getLong(i));
        return instant.atZone(ZoneId.systemDefault()).toLocalDate();
    }
}

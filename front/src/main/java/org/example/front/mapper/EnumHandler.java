package org.example.front.mapper;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.example.front.model.EnumCodec;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(EnumCodec.class)
@MappedJdbcTypes(JdbcType.TINYINT)
public class EnumHandler<E extends EnumCodec> extends BaseTypeHandler<E> {

    private final Class<E> clazz;

    public EnumHandler(Class<E> clazz) {
        this.clazz = clazz;
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, E parameter, JdbcType jdbcType) throws SQLException {
        if (jdbcType == null) {
            ps.setObject(i, parameter.getCode());
        } else {
            ps.setObject(i, parameter.getCode(), jdbcType.TYPE_CODE);
        }
    }

    @Override
    public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
        Object value = rs.getObject(columnName);
        if (null == value && rs.wasNull()) {
            return null;
        }
        return EnumCodec.value(clazz, value);
    }

    @Override
    public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        Object value = rs.getObject(columnIndex);
        if (null == value && rs.wasNull()) {
            return null;
        }
        return EnumCodec.value(clazz, value);
    }

    @Override
    public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        Object value = cs.getObject(columnIndex);
        if (null == value && cs.wasNull()) {
            return null;
        }
        return EnumCodec.value(clazz, value);
    }
}

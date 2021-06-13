package com.mkamalova.readingisgood.util;


import java.io.IOException;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Properties;

import com.fasterxml.jackson.databind.type.TypeFactory;
import org.hibernate.HibernateException;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.internal.util.ReflectHelper;
import org.hibernate.usertype.DynamicParameterizedType;
import org.hibernate.usertype.UserType;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Define a Jackson Serializer/Deserializer use to persist
 *
 * The implementation is a hibernate custom type
 *
 * @author Marvin H Froeder
 * @author Regis Leray
 */
public class JsonUserType implements UserType, DynamicParameterizedType {

    private Class<?> jsonUserTypeClass;
    private static final int[] SQL_TYPES = {Types.LONGNVARCHAR};

    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
        if (x == y) {
            return true;
        } else if (x == null || y == null) {
            return false;
        } else {
            return x.equals(y);
        }
    }

    @Override
    public int hashCode(Object x) throws HibernateException {
        return null == x ? 0 : x.hashCode();
    }

    @Override
    public boolean isMutable() {
        return true;
    }

    @Override
    public Object nullSafeGet(ResultSet resultSet, String[] strings, SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException, SQLException {
        String content = resultSet.getString(strings[0]);
        if (StringUtils.isNotBlank(content)) {
            return convertJsonToObject(content);
        }
        return null;
    }

    @Override
    public void nullSafeSet(PreparedStatement preparedStatement, Object o, int i, SharedSessionContractImplementor sharedSessionContractImplementor) throws HibernateException, SQLException {
        if (o == null) {
            preparedStatement.setString(i, null);
        } else {
            preparedStatement.setString(i, convertObjectToJson(o));
        }
    }


    Object convertJsonToObject(String content) {
        if ((content == null) || (content.isEmpty())) {
            return null;
        }
        try {
            ObjectMapper mapper = new ObjectMapper();
            JavaType type = createJavaType(mapper);
            if (type == null)
                return mapper.readValue(content, jsonUserTypeClass);

            return mapper.readValue(content, type);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    String convertObjectToJson(Object object) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            return mapper.writeValueAsString(object);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object deepCopy(Object value) throws HibernateException {
        String json = convertObjectToJson(value);
        return convertJsonToObject(json);
    }

    /**
     * Optionnal
     */
    @Override
    public Object replace(Object original, Object target, Object owner)
            throws HibernateException {
        return deepCopy(original);
    }

    /**
     * (optional operation)
     *
     * @param value
     * @throws HibernateException
     */
    @Override
    public Serializable disassemble(Object value) throws HibernateException {
        return (Serializable) deepCopy(value);
    }

    /**
     * (optional operation)
     *
     * @param cached
     * @param owner
     * @return the instance cached
     * @throws HibernateException
     */
    @Override
    public Object assemble(Serializable cached, Object owner)
            throws HibernateException {
        return deepCopy(cached);
    }


    public JavaType createJavaType(ObjectMapper mapper) {
        return TypeFactory.defaultInstance().constructType(returnedClass());
    }



    @Override
    public int[] sqlTypes() {
        return SQL_TYPES;
    }

    @Override
    public void setParameterValues(Properties parameters) {
        String classTypeName = parameters.getProperty("classType");
        try {
            this.jsonUserTypeClass = ReflectHelper.classForName(classTypeName, this.getClass());
        } catch (ClassNotFoundException cnfe) {
            throw new HibernateException("classType not found", cnfe);
        }
    }

    @Override
        public Class<?> returnedClass () {
            return this.jsonUserTypeClass;
        }


}
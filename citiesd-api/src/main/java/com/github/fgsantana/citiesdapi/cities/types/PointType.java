package com.github.fgsantana.citiesdapi.cities.types;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;
import org.postgresql.geometric.PGpoint;
import org.springframework.data.geo.Point;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PointType implements UserType {
    public PointType() {
    }

    public int[] sqlTypes() {
        return new int[]{1111};
    }

    public Class returnedClass() {
        return Point.class;
    }

    public boolean equals(Object x, Object y) throws HibernateException {
        return false;
    }

    public int hashCode(Object x) throws HibernateException {
        return 0;
    }

    public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner) throws HibernateException, SQLException {
        PGpoint value = (PGpoint) rs.getObject(names[0]);
        return new Point(value.x, value.y);
    }

    public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session) throws HibernateException, SQLException {
    }

    public Object deepCopy(Object value) throws HibernateException {
        return null;
    }

    public boolean isMutable() {
        return false;
    }

    public Serializable disassemble(Object value) throws HibernateException {
        return null;
    }

    public Object assemble(Serializable cached, Object owner) throws HibernateException {
        return null;
    }

    public Object replace(Object original, Object target, Object owner) throws HibernateException {
        return null;
    }
}

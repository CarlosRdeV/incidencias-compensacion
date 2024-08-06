package com.totalplay.incidenciascompensacion.entities;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Component
public class StringSequenceIdGenerator implements IdentifierGenerator {

    @Autowired
    private DataSource dataSource;

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT next_val FROM sequence_table WHERE sequence_name='empleado_sequence'");
            if (rs.next()) {
                long seqVal = rs.getLong(1);
                statement.executeUpdate("UPDATE sequence_table SET next_val=" + (seqVal + 1) + " WHERE sequence_name='empleado_sequence'");
                return String.format("%06d", seqVal);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Unable to generate Sequence", e);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}

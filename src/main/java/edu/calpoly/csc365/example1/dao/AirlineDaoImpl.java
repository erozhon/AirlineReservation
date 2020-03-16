package edu.calpoly.csc365.example1.dao;

import edu.calpoly.csc365.example1.entity.Airline;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class AirlineDaoImpl implements Dao<Airline>{
    private Connection conn;

    public AirlineDaoImpl(Connection conn) {
        this.conn = conn;
    }


    public Airline getById(int id) {
        Airline airline = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = this.conn.prepareStatement("SELECT * FROM Airlines WHERE id=?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            Set<Airline> airlines = unpackResultSet(resultSet);
            airline = (Airline)airlines.toArray()[0];
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return airline;
    }

    
    public Set<Airline> getAll() {
        Set<Airline> airlines = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = this.conn.prepareStatement("SELECT * FROM Airlines");
            resultSet = preparedStatement.executeQuery();
            airlines = unpackResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return airlines;
    }


    public Integer update(Airline obj) {
        Integer numRows = 0;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.conn.prepareStatement(
                    "UPDATE Customers SET name=?, abbr=?, country=? WHERE id=?");
            preparedStatement.setString(1, obj.getName());
            preparedStatement.setString(2, obj.getAbbr());
            preparedStatement.setString(3, obj.getCountry());
            preparedStatement.setInt(4, obj.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return numRows;
        } finally{
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return numRows;
    }

    public Integer delete(Airline obj) {
        Integer numRows = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.conn.prepareStatement("DELETE FROM Airline WHERE id = ?");
            preparedStatement.setInt(1, obj.getId());
            numRows = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return numRows;
    }

    private Set<Airline> unpackResultSet(ResultSet rs) throws SQLException {
        Set<Airline> airlines = new HashSet<Airline>();

        while(rs.next()) {
            Airline airline = new Airline(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("abbr"),
                    rs.getString("country"));
            airlines.add(airline);
        }
        return airlines;
    }

    public Integer insert(Airline obj) {
        return 1;
    }
}
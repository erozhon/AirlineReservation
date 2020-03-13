package edu.calpoly.csc365.example1.dao;

import edu.calpoly.csc365.example1.entity.Airport;
import edu.calpoly.csc365.example1.entity.CreditCard;
import edu.calpoly.csc365.example1.entity.Customer;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class AirportDaoImpl implements Dao<Airport>{
    private Connection conn;

    public AirportDaoImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public Airport getById(int id) {
        Airport airport = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = this.conn.prepareStatement("SELECT * FROM Airports WHERE Code = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            Set<Airport> airports = unpackResultSet(resultSet);
            airport = (Airport) airports.toArray()[0];
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return airport;
    }@Override
    public Set<Airport> getAll() {
        Set<Airport> airports = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = this.conn.prepareStatement("SELECT * FROM Airports");
            resultSet = preparedStatement.executeQuery();
            airports = unpackResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return airports;
    }

    @Override
    public Integer insert(Airport obj) {
        Integer id = null;
        String code = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = this.conn.prepareStatement(
                    "INSERT INTO Airports (Code, City, Name, Country, CAbbr) VALUES (?, ?, ?, ?, ?)");
            preparedStatement.setString(1, obj.getCode());
            preparedStatement.setString(2, obj.getCity());
            preparedStatement.setString(3, obj.getName());
            preparedStatement.setString(4, obj.getCountry());
            preparedStatement.setString(3, obj.getCAbbr());
            int numRows = preparedStatement.executeUpdate();
            if (numRows == 1) {
                // get generated id
                resultSet = preparedStatement.getGeneratedKeys();
                if(resultSet.next())
                    code = resultSet.getString(1);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
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
        return id;
    }

    @Override
    public Integer update(Airport obj) {
        Integer numRows = 0;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.conn.prepareStatement(
                    "UPDATE Airports SET City = ?, Name= ?, Country= ?, CAbbr = ? WHERE Code = ?",
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, obj.getCity());
            preparedStatement.setString(2, obj.getName());
            preparedStatement.setString(3, obj.getCountry());
            preparedStatement.setString(4, obj.getCAbbr());
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

    @Override
    public Integer delete(Airport obj) {
        Integer numRows = 0;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.conn.prepareStatement(
                    "DELETE FROM Airports WHERE Code = ?");
            preparedStatement.setString(1, obj.getCode());
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

    private Set<Airport> unpackResultSet(ResultSet rs) throws SQLException {
        Set<Airport> airports = new HashSet<Airport>();

        while(rs.next()) {
            Airport airport = new Airport(
                    rs.getString("Code"),
                    rs.getString("City"),
                    rs.getString("Name"),
                    rs.getString("Country"),
                    rs.getString("CAbbr")
            );
            airports.add(airport);
        }
        return airports;
    }


}
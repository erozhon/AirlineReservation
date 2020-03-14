package edu.calpoly.csc365.example1.dao;

import edu.calpoly.csc365.example1.entity.Passenger;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class PassengerDaoImpl implements Dao<Passenger> {
    private Connection conn;

    public PassengerDaoImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public Passenger getById(int id) {
        Passenger passenger = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = this.conn.prepareStatement("SELECT * FROM Passengers WHERE Id=?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            Set<Passenger> passengers = unpackResultSet(resultSet);
            passenger = (Passenger)passengers.toArray()[0];
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
        return passenger;
    }

    @Override
    public Set<Passenger> getAll() {
        Set<Passenger> passengers = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = this.conn.prepareStatement("SELECT * FROM Passengers");
            resultSet = preparedStatement.executeQuery();
            passengers = unpackResultSet(resultSet);
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
        return passengers;
    }

    @Override
    public Integer insert(Passenger obj) {
        Integer id = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = this.conn.prepareStatement(
                    "INSERT INTO Passengers (Id, name) VALUES (?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, obj.getId());
            preparedStatement.setString(2, obj.getName());
            int numRows = preparedStatement.executeUpdate();
            if (numRows == 1) {
                // get generated id
                resultSet = preparedStatement.getGeneratedKeys();
                if(resultSet.next())
                    id = resultSet.getInt(1);

            }
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
        return id;
    }

    @Override
    public Integer update(Passenger obj) {
        Integer numRows = 0;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.conn.prepareStatement(
                    "UPDATE Passengers SET name=? WHERE Id=?");
            preparedStatement.setString(1, obj.getName());
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

    @Override
    public Integer delete(Passenger obj) {
        Integer numRows = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.conn.prepareStatement("DELETE FROM Passengers WHERE Id = ?");
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

    private Set<Passenger> unpackResultSet(ResultSet rs) throws SQLException {
        Set<Passenger> passengers = new HashSet<Passenger>();

        while(rs.next()) {
            Passenger passenger = new Passenger(
                    rs.getString("name"),
                    rs.getInt("Id"));
            passengers.add(passenger);
        }
        return passengers;
    }
}
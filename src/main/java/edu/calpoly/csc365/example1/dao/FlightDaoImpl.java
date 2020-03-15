package edu.calpoly.csc365.example1.dao;

import edu.calpoly.csc365.example1.entity.Flight;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class FlightDaoImpl implements FlightDao {
    private Connection conn;

    public FlightDaoImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public Flight getById(int id) {
        Flight flight = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = this.conn.prepareStatement("SELECT * FROM Flights WHERE Id=?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            Set<Flight> flights = unpackResultSet(resultSet);
            flight = (Flight) flights.toArray()[0];
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
        return flight;
    }


    @Override
    public Set<Flight> getAll() {
        Set<Flight> flights = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = this.conn.prepareStatement("SELECT * FROM Flights");
            resultSet = preparedStatement.executeQuery();
            flights = unpackResultSet(resultSet);
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
        return flights;
    }

    @Override
    public Integer insert(Flight obj) {
        Integer id = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = this.conn.prepareStatement(
                    "INSERT INTO Flights (Id, Airline, Source, Destination, Takeoff, Arrival, full, Capacity) VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, obj.getId());
            preparedStatement.setInt(2, obj.getAirline());
            preparedStatement.setString(3, obj.getSource());
            preparedStatement.setString(4, obj.getDestination());
            preparedStatement.setDate(5, obj.getTakeoff());
            preparedStatement.setDate(6, obj.getArrival());
            preparedStatement.setBoolean(7, obj.getFull());
            preparedStatement.setInt(8, obj.getCapacity());
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
    public Integer update(Flight obj) {
        Integer numRows = 0;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.conn.prepareStatement(
                    "UPDATE Flights SET Airline=?, Source=?, Destination=?, Takeoff=?, Arrival=?, full=?, Capacity=? WHERE Id=?");
            preparedStatement.setInt(1, obj.getAirline());
            preparedStatement.setString(2, obj.getSource());
            preparedStatement.setString(3, obj.getDestination());
            preparedStatement.setDate(4, obj.getTakeoff());
            preparedStatement.setDate(5, obj.getArrival());
            preparedStatement.setBoolean(6, obj.getFull());
            preparedStatement.setInt(7, obj.getCapacity());
            preparedStatement.setInt(8, obj.getId());
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
    public Integer delete(Flight obj) {
        Integer numRows = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.conn.prepareStatement("DELETE FROM Flights WHERE Id = ?");
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

    private Set<Flight> unpackResultSet(ResultSet rs) throws SQLException {
        Set<Flight> flights = new HashSet<Flight>();

        while(rs.next()) {
            Flight flight = new Flight(
                    rs.getInt("Id"),
                    rs.getInt("Airline"),
                    rs.getString("Source"),
                    rs.getString("Destination"),
                    rs.getDate("Takeoff"),
                    rs.getDate("Arrival"),
                    rs.getBoolean("full"),
                    rs.getInt("Capacity"));
            flights.add(flight);
        }
        return flights;
    }

    public Set<Flight> getBySource(String source){
        Set<Flight> flights = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = this.conn.prepareStatement("SELECT * FROM Flights WHERE Source=?");
            preparedStatement.setString(1, source);
            resultSet = preparedStatement.executeQuery();
            flights = unpackResultSet(resultSet);
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
        return flights;
    }


    public Set<Flight> getByDestination(String destination){
        Set<Flight> flights = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = this.conn.prepareStatement("SELECT * FROM Flights WHERE Destination=?");
            preparedStatement.setString(1, destination);
            resultSet = preparedStatement.executeQuery();
            flights = unpackResultSet(resultSet);
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
        return flights;
    }


    public Set<Flight> getByTakeoff(Date d){
        Set<Flight> flights = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = this.conn.prepareStatement("SELECT * FROM Flights WHERE DATE_FORMAT(Arrival, '%Y-%m-%d')=?");
            preparedStatement.setDate(1, d);
            resultSet = preparedStatement.executeQuery();
            flights = unpackResultSet(resultSet);
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
        return flights;
    }


    public Set<Flight> getByArrival(Date d){
        Set<Flight> flights = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = this.conn.prepareStatement("SELECT * FROM Flights WHERE DATE_FORMAT(Arrival, '%Y-%m-%d')=?");
            preparedStatement.setDate(1, d);
            resultSet = preparedStatement.executeQuery();
            flights = unpackResultSet(resultSet);
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
        return flights;
    }


    public Boolean isFull(Integer id){
        Flight flight = null;
        Boolean f = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = this.conn.prepareStatement("SELECT * FROM Flights WHERE Id=?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            Set<Flight> flights = unpackResultSet(resultSet);
            flight = (Flight) flights.toArray()[0];
            f = flight.getFull();
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
        return f;
    }

}

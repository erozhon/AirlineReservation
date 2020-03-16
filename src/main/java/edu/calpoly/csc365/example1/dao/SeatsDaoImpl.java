package edu.calpoly.csc365.example1.dao;

//import com.sun.org.apache.regexp.internal.RE;
import edu.calpoly.csc365.example1.entity.Seat;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class SeatsDaoImpl implements Dao<Seat> {
    private Connection conn;

    public SeatsDaoImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public Seat getById(int id) {
        return null;
    }

    public Set<Seat> getByFlight(int flightId) {
        Set<Seat> seats = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = this.conn.prepareStatement("SELECT * FROM Seats WHERE flightId = ?");
            preparedStatement.setInt(1, flightId);
            resultSet = preparedStatement.executeQuery();
            seats = unpackResultSet(resultSet);
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
        return seats;
    }

    @Override
    public Set<Seat> getAll() {
        Set<Seat> seats = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = this.conn.prepareStatement("SELECT * FROM Seats");
            resultSet = preparedStatement.executeQuery();
            seats = unpackResultSet(resultSet);
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
        return seats;
    }

    @Override
    public Integer insert(Seat obj) {
        Integer id = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = this.conn.prepareStatement(
                    "INSERT INTO Seats (flightId, seatNo, type, seatClass, taken) VALUES (?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, obj.getFlightId());
            preparedStatement.setInt(2, obj.getSeatNo());
            preparedStatement.setString(3, obj.getType());
            preparedStatement.setString(4, obj.getSeatClass());
            preparedStatement.setBoolean(5, obj.getTaken());
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
    public Integer update(Seat obj) {
        return -1;
    }

    @Override
    public Integer delete(Seat obj) {
        Integer numRows = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.conn.prepareStatement("DELETE FROM Seats WHERE seatNo = ? AND flightId = ?");
            preparedStatement.setInt(1, obj.getSeatNo());
            preparedStatement.setInt(2, obj.getFlightId());
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

    private Set<Seat> unpackResultSet(ResultSet rs) throws SQLException {
        Set<Seat> seats = new HashSet<Seat>();

        while(rs.next()) {
            Seat seat = new Seat(
                    rs.getInt("SeatNo"),
                    rs.getInt("FlightId"),
                    rs.getString("type"),
                    rs.getString("class"),
                    rs.getBoolean("taken"));
            seats.add(seat);
        }
        return seats;
    }
}






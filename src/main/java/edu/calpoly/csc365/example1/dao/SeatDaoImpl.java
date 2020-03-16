package edu.calpoly.csc365.example1.dao;

import edu.calpoly.csc365.example1.entity.Seat;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class SeatDaoImpl implements SeatDao{
    private Connection conn;

    public SeatDaoImpl(Connection conn) {
        this.conn = conn;
    }


    public Seat getByFlightId(int flightId) {
        Seat seat = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = this.conn.prepareStatement("SELECT * FROM Seats WHERE flightId=?");
            preparedStatement.setInt(1, flightId);
            resultSet = preparedStatement.executeQuery();
            Set<Seat> seats = unpackResultSet(resultSet);
            seat = (Seat)seats.toArray()[0];
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
        return seat;
    }

    public Seat getByFlightIdTypeClass(int flightId, String type, String seatClass) {
        Seat seat = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = this.conn.prepareStatement("SELECT * FROM Seats WHERE flightId=? and type=? and seatClass=?");
            preparedStatement.setInt(1, flightId);
            preparedStatement.setString(2, type);
            preparedStatement.setString(3, seatClass);
            resultSet = preparedStatement.executeQuery();
            Set<Seat> seats = unpackResultSet(resultSet);
            seat = (Seat)seats.toArray()[0];
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
        return seat;
    }


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


    private Set<Seat> unpackResultSet(ResultSet rs) throws SQLException {
        Set<Seat> seats = new HashSet<Seat>();

        while(rs.next()) {
            Seat seat = new Seat(
                    rs.getInt("flightId"),
                    rs.getInt("seatNo"),
                    rs.getString("seatClass"),
                    rs.getString("type"));
            seats.add(seat);
        }
        return seats;
    }
}

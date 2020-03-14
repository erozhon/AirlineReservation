package edu.calpoly.csc365.example1.dao;

import edu.calpoly.csc365.example1.entity.Reservation;

import java.sql.*;

public class ReservationDaoCommandImpl implements DaoCommand {
    private Reservation reservation;

    public ReservationDaoCommandImpl(Reservation reservation) {
        this.reservation = reservation;
    }

    @Override
    public Object execute(DaoManager daoManager) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Integer rowsAffected = 0;
        try {
            conn = daoManager.getConnection();
            preparedStatement = conn.prepareStatement(
                    "INSERT INTO Reservations (Id, Passenger_id, Seat_no, Flight_no) VALUES (?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, reservation.getId());
            preparedStatement.setInt(2, reservation.getPassengerId());
            preparedStatement.setInt(3, reservation.getSeatNo());
            preparedStatement.setDouble(4, reservation.getFlightNo());
            //preparedStatement.setDate(5, reservation.getDate());
            rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                resultSet = preparedStatement.getGeneratedKeys();
                if(resultSet.next())
                    reservation.setId(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error occurred during SQL execution!");
        }
        return reservation;
    }
}

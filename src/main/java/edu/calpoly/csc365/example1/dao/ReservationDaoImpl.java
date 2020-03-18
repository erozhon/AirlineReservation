package edu.calpoly.csc365.example1.dao;

//import com.sun.org.apache.regexp.internal.RE;
import edu.calpoly.csc365.example1.entity.Customer;
import edu.calpoly.csc365.example1.entity.Reservation;

import javax.xml.ws.EndpointReference;
import java.sql.*;
import java.util.HashSet;
import java.util.Set;

    public class ReservationDaoImpl implements Dao<Reservation> {
        private Connection conn;

        public ReservationDaoImpl(Connection conn) {
            this.conn = conn;
        }

        @Override
        public Reservation getById(int id) {
            Reservation reservation = null;
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            try {
                preparedStatement = this.conn.prepareStatement("SELECT * FROM Reservations WHERE Id=?");
                preparedStatement.setInt(1, id);
                resultSet = preparedStatement.executeQuery();
                Set<Reservation> reservations = unpackResultSet(resultSet);
                reservation = (Reservation) reservations.toArray()[0];
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
            return reservation;
        }

        public Set<Reservation> getByPassengerId(int id) {
            Set<Reservation> reservations = null;
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            try {
                preparedStatement = this.conn.prepareStatement("SELECT * FROM Reservations WHERE Passenger_id=?");
                preparedStatement.setInt(1, id);
                resultSet = preparedStatement.executeQuery();
                reservations = unpackResultSet(resultSet);
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
            return reservations;
        }

        @Override
        public Set<Reservation> getAll() {
            Set<Reservation> reservations = null;
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            try {
                preparedStatement = this.conn.prepareStatement("SELECT * FROM Reservations");
                resultSet = preparedStatement.executeQuery();
                reservations = unpackResultSet(resultSet);
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
            return reservations;
        }

        @Override
        public Integer insert(Reservation obj) {
            Integer id = null;
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            try {
                preparedStatement = this.conn.prepareStatement(
                        "INSERT INTO Reservations (Id, Passenger_id, Seat_no, Cost, Credit_no, Flight_no, Has_paid, Cancelled) VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                        Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setInt(1, obj.getId());
                preparedStatement.setInt(2, obj.getPassengerId());
                preparedStatement.setInt(3, obj.getSeatNo());
                preparedStatement.setDouble(4, obj.getCost());
                preparedStatement.setLong(5, obj.getCreditNo());
                preparedStatement.setInt(6, obj.getFlightNo());
                preparedStatement.setBoolean(7, obj.getHasPaid());
                preparedStatement.setBoolean(8, obj.getCancelled());
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
        public Integer update(Reservation obj) {
            Integer numRows = 0;
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = this.conn.prepareStatement(
                        "UPDATE Reservations SET Passenger_id=?, Seat_no=?, Cost=?, Credit_no=?, Flight_no=?, Has_paid=?, Cancelled=? WHERE Id=?");
                preparedStatement.setInt(1, obj.getPassengerId());
                preparedStatement.setInt(2, obj.getSeatNo());
                preparedStatement.setDouble(3, obj.getCost());
                preparedStatement.setLong(4, obj.getCreditNo());
                preparedStatement.setInt(5, obj.getFlightNo());
                preparedStatement.setBoolean(6, obj.getHasPaid());
                preparedStatement.setBoolean(7, obj.getCancelled());
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
        public Integer delete(Reservation obj) {
            Integer numRows = null;
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = this.conn.prepareStatement("DELETE FROM Reservations WHERE Id = ?");
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

        private Set<Reservation> unpackResultSet(ResultSet rs) throws SQLException {
            Set<Reservation> reservations = new HashSet<Reservation>();

            while(rs.next()) {
                Reservation reservation = new Reservation(
                        rs.getInt("Id"),
                        rs.getInt("Passenger_id"),
                        rs.getInt("Seat_no"),
                        rs.getDouble("Cost"),
                        rs.getLong("Credit_no"),
                        rs.getInt("Flight_no"),
                        rs.getBoolean("Has_paid"),
                        rs.getBoolean("Cancelled"));
                reservations.add(reservation);
            }
            return reservations;
        }
    }






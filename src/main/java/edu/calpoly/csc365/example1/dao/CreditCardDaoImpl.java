package edu.calpoly.csc365.example1.dao;

import edu.calpoly.csc365.example1.entity.CreditCard;
import edu.calpoly.csc365.example1.entity.Customer;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class CreditCardDaoImpl implements Dao<CreditCard> {

  private Connection conn;

  public CreditCardDaoImpl(Connection conn) {
    this.conn = conn;
  }

  @Override
  public CreditCard getById(int id) {
    CreditCard creditCard = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    try {
      preparedStatement = this.conn.prepareStatement("SELECT * FROM Cards WHERE num = ?");
      preparedStatement.setInt(1, id);
      resultSet = preparedStatement.executeQuery();
      Set<CreditCard> creditCards = unpackResultSet(resultSet);
      creditCard = (CreditCard) creditCards.toArray()[0];
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return creditCard;
  }

  @Override
  public Set<CreditCard> getAll() {
    Set<CreditCard> creditCards = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    try {
      preparedStatement = this.conn.prepareStatement("SELECT * FROM Cards");
      resultSet = preparedStatement.executeQuery();
      creditCards = unpackResultSet(resultSet);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return creditCards;
  }

  @Override
  public Integer insert(CreditCard obj) {
    Integer cardNumber = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    try {
      preparedStatement = this.conn.prepareStatement(
        "INSERT INTO Cards (balance) VALUES (?)");
      preparedStatement.setDouble(1, obj.getBalance());
      int numRows = preparedStatement.executeUpdate();
      if (numRows == 1) {
        // get generated id
        resultSet = preparedStatement.getGeneratedKeys();
        if(resultSet.next())
          cardNumber = resultSet.getInt(1);

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
    return cardNumber;
  }

  @Override
  public Integer update(CreditCard obj) {
    Integer numRows = 0;
    PreparedStatement preparedStatement = null;
    try {
      preparedStatement = this.conn.prepareStatement(
        "UPDATE Cards SET balance = ? WHERE number = ?",
        Statement.RETURN_GENERATED_KEYS);
      preparedStatement.setDouble(1, obj.getBalance());
      preparedStatement.setInt(2, obj.getCardNumber());
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
  public Integer delete(CreditCard obj) {
    Integer numRows = 0;
    PreparedStatement preparedStatement = null;
    try {
      preparedStatement = this.conn.prepareStatement(
        "DELETE FROM Cards WHERE number = ?");
      preparedStatement.setInt(1, obj.getCardNumber());
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

  private Set<CreditCard> unpackResultSet(ResultSet rs) throws SQLException {
    Set<CreditCard> creditCards = new HashSet<CreditCard>();

    while(rs.next()) {
      CreditCard creditCard = new CreditCard(
        rs.getInt("num"),
        rs.getDouble("balance"));
      creditCards.add(creditCard);
    }
    return creditCards;
  }
}

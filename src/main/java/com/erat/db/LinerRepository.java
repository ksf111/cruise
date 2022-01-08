package com.erat.db;

import com.erat.entity.Liner;
import lombok.SneakyThrows;
import lombok.val;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LinerRepository {

    @SneakyThrows
    public List<Liner> getLiners() {
        try (Connection connection = DatabaseConnectionEstablisher.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM liners");
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Liner> liners = new ArrayList<>();
            while (resultSet.next()) {
                Liner liner = new Liner();
                liner.setId(resultSet.getLong("id"));
                liner.setName(resultSet.getString("name"));
                liner.setCrew(resultSet.getInt("crew"));
                liner.setPassengers(resultSet.getInt("passengers"));
                liners.add(liner);
            }
            resultSet.close();
            preparedStatement.close();
            return liners;
        }
    }

    @SneakyThrows
    public Liner addLiner(Liner liner) {
        try (Connection connection = DatabaseConnectionEstablisher.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO liners VALUES (?, ?, ?, 0)", Statement.RETURN_GENERATED_KEYS);
            int k = 1;
            preparedStatement.setString(k++, liner.getName());
            preparedStatement.setInt(k++, liner.getPassengers());
            preparedStatement.setInt(k, liner.getCrew());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                liner.setId(resultSet.getLong(1));
            }
            return liner;
        }
    }

    public static void main(String[] args) {
        val repo = new LinerRepository();
        System.out.println(repo.getLiners());
        System.out.println(repo.addLiner(Liner.builder()
                        .id(-1L)
                        .crew(10)
                        .passengers(100)
                        .name("Augustus")
                .build()));
    }
}

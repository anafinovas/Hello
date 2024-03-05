package com.example.DAO;

import com.example.models.Person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PersonDB {
    public static int insert(Person person) {

        try{
            Class.forName("org.postgresql.Driver");
            try (Connection conn = DriverManager.getConnection("jdbc:postgresql://192.168.100.31:5432/andersen_db", "postgres", "1234")){
                String sql = "INSERT INTO person (name, surname, age) Values (?, ?, ?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, person.getName());
                    preparedStatement.setString(2, person.getSurname());
                    preparedStatement.setInt(3, person.getAge());
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }

    public static void main(String[] args) {
        Person person = new Person("alex", "snow", 20);
        insert(person);
    }
}

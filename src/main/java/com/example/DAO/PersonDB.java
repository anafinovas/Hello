package com.example.DAO;

import com.example.models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDB {
    private static String url = "jdbc:postgresql://192.168.50.142:5432/budapest";
    private static String username = "postgres";
    private static String password = "budapest";
    public static List<Person> select() {

        List<Person> people = new ArrayList<Person>();
        try{
            Class.forName("org.postgresql.Driver");
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                // Set isolation level
                conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM person");
                while(resultSet.next()){
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String surname = resultSet.getString(3);
                    int age = resultSet.getInt(4);
                    Person person = new Person(id, name, surname, age);
                    people.add(person);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return people;
    }
    public static Person selectOne(int id) {

        Person person = null;
        try{
            Class.forName("org.postgresql.Driver");
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "SELECT * FROM person WHERE id=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
                        int personId = resultSet.getInt(1);
                        String name = resultSet.getString(2);
                        String surname = resultSet.getString(3);
                        int age = resultSet.getInt(4);
                        person = new Person(id, name, surname, age);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return person;
    }
    /*public static int add(Person person) {

        try{
            Class.forName("org.postgresql.Driver");
            try (Connection conn = DriverManager.getConnection(url, username, password)){
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
    }*/
    public static int add(Person person) {
        try {
            Class.forName("org.postgresql.Driver");
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                String sql = "INSERT INTO person (name, surname, age) VALUES (?, ?, ?)";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setString(1, person.getName());
                    preparedStatement.setString(2, person.getSurname());
                    preparedStatement.setInt(3, person.getAge());
                    return preparedStatement.executeUpdate();
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return 0;
    }

    public static int update(Person person) {

        try{
            Class.forName("org.postgresql.Driver");
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "UPDATE person SET name = ?, surname = ?, age = ? WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, person.getName());
                    preparedStatement.setString(2, person.getSurname());
                    preparedStatement.setInt(3, person.getAge());
                    preparedStatement.setInt(4, person.getId());

                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
    public static int delete(int id) {

        try{
            Class.forName("org.postgresql.Driver");
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "DELETE FROM person WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
}

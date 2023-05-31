/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package movie;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author PC PRAKTIKUM
 */
public class ModelMovie {
    String DBurl = "jdbc:mysql://localhost/movie_db";
    String DBusername = "root";
    String DBpassword = "";
    Connection koneksi;
    Statement statement;
    static String[] username;
    String data[] = new String[2];

    public ModelMovie() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            koneksi = (Connection) DriverManager.getConnection(DBurl, DBusername, DBpassword);
            System.out.println("Koneksi Berhasil");
        } catch (Exception ex) {
            System.out.println("Koneksi gagal");
        }
    }
    public String[][] readMovie(){
        try{
            int jmlData = 0;

            String data[][] = new String[getBanyakData()][5];

            String query = "SELECT * FROM movie";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("Judul"); //harus sesuai nama kolom di mysql
                data[jmlData][1] = String.valueOf(resultSet.getDouble("Alur"));
                data[jmlData][2] = String.valueOf(resultSet.getDouble("Penokohan"));
                data[jmlData][3] = String.valueOf(resultSet.getDouble("Akting"));
                data[jmlData][4] = String.valueOf(resultSet.getDouble("Nilai"));
                jmlData++;
            }
            return data;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }


    public void insertMovie(String Judul, double Alur, double Penokohan, double Akting, double Nilai){
        int jmlData=0;

        try {
            String query = "SELECT * FROM movie WHERE judul='" + Judul +"'";
            System.out.println(Judul + " " + Alur + " " + Penokohan + " " + Akting);
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                jmlData++;
            }

            if (jmlData==0) {
                query = "INSERT INTO movie(judul,Alur,Penokohan,Akting,Nilai) VALUES('"+ Judul +"','"+ Alur +"','"+ Penokohan +"','"+ Akting +"','"+ Nilai +"')";

                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query); //execute querynya
                System.out.println("Berhasil ditambahkan");
                JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
            }
            else {
                JOptionPane.showMessageDialog(null, "Data sudah ada");
            }
        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    public void updateMovie(String Judul, double Alur, double Penokohan, double Akting, double Nilai){
        int jmlData=0;
        try {
            String query = "SELECT * FROM movie WHERE judul='" + Judul +"'";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                jmlData++;
            }

            if (jmlData==1) {
                query = "UPDATE movie SET alur='" + Alur + "', penokohan='" + Penokohan + "', akting='" + Akting + "', nilai='"+ Nilai + "' WHERE judul='" +Judul +"'";
                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query); //execute querynya
                System.out.println("Berhasil Diupdate");
                JOptionPane.showMessageDialog(null, "Data Berhasil Diupdate");
            }
            else {
                JOptionPane.showMessageDialog(null, "Data Tidak Ada");
            }

        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    public int getBanyakData(){
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "SELECT * FROM movie";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                jmlData++;
            }
            return jmlData;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }

    public void deleteMovie (String Judul) {
        try{
            String query = "DELETE FROM movie WHERE judul = '"+ Judul +"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");

        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }
}

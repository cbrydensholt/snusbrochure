package com.example.snusbrochure.Repositories;


import com.example.snusbrochure.Models.Snus;
import com.example.snusbrochure.Util.DatabaseConnectionManager;
import com.mysql.cj.protocol.Resultset;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SnusRepository implements IcrudRepository.ICrudRepository<Snus> {

    private Connection conn;
    public SnusRepository() {this.conn = DatabaseConnectionManager.getDatabaseConnection();}



    @Override
    public void create(Snus snus) {
        try {
            PreparedStatement createSnus = conn.prepareStatement("INSERT INTO snus(name, brand, price, strength, country)" + "VALUES(?,?,?,?,?) ");
            createSnus.setString(1, snus.getName());
            createSnus.setString(2, snus.getBrand());
            createSnus.setInt(3, snus.getPrice());
            createSnus.setInt(4, snus.getStrength());
            createSnus.setString(5, snus.getCountry());
            createSnus.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<Snus> readAll() {
        ArrayList<Snus> allSnus = new ArrayList<>();
        try{
            PreparedStatement readAllSnus = conn.prepareStatement("SELECT snusId, name, brand, price, strength, country, img FROM snus");
            ResultSet rs = readAllSnus.executeQuery();
            while(rs.next()){
                Snus tempSnus = new Snus();
                tempSnus.setSnusId(rs.getInt(1));
                tempSnus.setName(rs.getString(2));
                tempSnus.setBrand(rs.getString(3));
                tempSnus.setPrice(rs.getInt(4));
                tempSnus.setStrength(rs.getInt(5));
                tempSnus.setCountry(rs.getString(6));
                tempSnus.setImagelink(rs.getString(7));


                allSnus.add(tempSnus);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allSnus;


    }

    @Override
    public Snus read(long id) {
        return null;
    }

    public Snus read2(int snusId) {
        Snus tempsnus = new Snus();
        try{
            PreparedStatement readtemp = conn.prepareStatement("SELECT * from snus WHERE snusId = ?");
            readtemp.setInt(1, snusId);
            ResultSet rs = readtemp.executeQuery();
            while(rs.next()){
                tempsnus = new Snus();
                tempsnus.setSnusId(rs.getInt(1));
                tempsnus.setName(rs.getString(2));
                tempsnus.setBrand(rs.getString(3));
                tempsnus.setPrice(rs.getInt(4));
                tempsnus.setStrength(rs.getInt(5));
                tempsnus.setCountry(rs.getString(6));
                tempsnus.setImagelink(rs.getString(7));

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return tempsnus;
    }

    @Override
    public boolean update(Snus snus) {

        try{
            PreparedStatement updatesnus = conn.prepareStatement("UPDATE snus SET name=?, brand=?, price=?, strength=?, country=? WHERE snusId =?");
            updatesnus.setString(1, snus.getName());
            updatesnus.setString(2, snus.getBrand());
            updatesnus.setInt(3, snus.getPrice());
            updatesnus.setInt(4, snus.getStrength());
            updatesnus.setString(5, snus.getCountry());
            updatesnus.setInt(6, snus.getSnusId());
            updatesnus.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return false;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }


    public boolean delete(int snusId) {
        try {
            PreparedStatement deleteproduct = conn.prepareStatement("DELETE FROM snus WHERE snusId = ?");
            deleteproduct.setLong(1, snusId);
            deleteproduct.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    public String readimage(int snusId){

String imagelink ="";
try{
    PreparedStatement imagegetter = conn.prepareStatement("SELECT img from snus WHERE snusId =?");
    imagegetter.setInt(1, snusId);
    ResultSet rs =imagegetter.executeQuery();
    imagelink = rs.getString(1);
} catch (SQLException e) {
    e.printStackTrace();
}
return imagelink;

    }





}

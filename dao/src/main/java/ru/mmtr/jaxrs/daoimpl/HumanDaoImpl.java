package ru.mmtr.jaxrs.daoimpl;

import ru.mmtr.jaxrs.api.HumanDao;
import ru.mmtr.jaxrs.model.Human;

import javax.ejb.Local;
import javax.enterprise.context.ApplicationScoped;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@ApplicationScoped
@Local(HumanDao.class)
public class HumanDaoImpl implements HumanDao {

    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:tcp://localhost/~/test";
    static final String USER = "sa";
    static final String PASS = "";
    private Connection conn = null;
    private Statement stmt = null;


    public List<Human> getHumans() {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            List<Human> humans = new ArrayList<Human>();
            String sql = "SELECT * FROM HUMAN";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                humans.add(new Human(rs.getString("NAME"), rs.getInt("AGE"), rs.getInt("GROWTH"), rs.getInt("ID")));
            }
            stmt.close();
            conn.close();
            return humans;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public void addHuman(Human human) {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql = "INSERT INTO HUMAN " +
                    "VALUES (NULL,'" + human.getName() + "'," + human.getAge() + "," + human.getGrowth() + ")";
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
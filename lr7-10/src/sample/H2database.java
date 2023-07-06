package sample;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class H2database {

    private final static String SELECT_BY_ID = "Select id, wname, wcost, wcountry FROM WSHOP where id=?";

    private final static String SELECT_ALL = "Select id, wname, wcost, wcountry FROM WSHOP";


    //Controller selectIdforSearch = new Controller();
    //int SelectId = selectIdforSearch._selectId;

    public H2database() {

    }

    public String accessSelectId(int SelectId) {
        String newSelectAccept = null;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            //conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            pst = conn.prepareStatement(SELECT_BY_ID);
            pst.setInt(1, SelectId);
            rs = pst.executeQuery();
            if (rs.next()) {
                newSelectAccept  = ("Id = "+SelectId + "WNAME = " +rs.getString("wname")+ "WCOST = " + rs.getString("wcost")+ "WCOUNTRY = " + rs.getString("wcountry"));
            }
        } catch (Exception e) {
            System.out.println("Oshibka"+e);
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (pst != null)
                    pst.close();
                if (conn != null){
                    conn.close();
                }

            } catch (SQLException e) {
                System.out.println("Oshi11111111bka");
            }
        }return newSelectAccept;
    }

    public List<String>selectAll(){
        List<String>H2List = null;
        //H2database h2database = null;
        //String newSelectAccept = null;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            pst = conn.prepareStatement(SELECT_ALL);
            rs = pst.executeQuery();
            H2List = new ArrayList<String>();
            //int rowCount = rs.getRow();
            while (rs.next()){
                H2List.add((String.valueOf(rs.getInt("id"))+ rs.getString("wname")+
                        rs.getString("wcost")+ rs.getString("wcountry")));
            }
        }catch (Exception e){
            System.out.println("oshibka1"+e);
        }finally {
            try {
                if (rs != null)
                    rs.close();
                if (pst != null)
                    pst.close();
                if (conn != null){
                    conn.close();
                }
            }catch (SQLException e){
                System.out.println("oshibka2"+e);
            }
        }return H2List;
    }

    private final static String SELECT_MAX = "SELECT MAX (WCOST) FROM WSHOP";

    public String selectMax(){
        String selectMax = null;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            pst = conn.prepareStatement(SELECT_MAX);
            rs = pst.executeQuery();
            while (rs.next()){
                selectMax = (rs.getString("MAX(WCOST)"));
            }
        }catch (Exception e){
            System.out.println(" Exception Ошибка : "+e);
        }finally {
            try {
                if (rs != null)
                    rs.close();
                if (pst != null)
                    pst.close();
                if (conn != null){
                    conn.close();
                }
            }catch (SQLException e){
                System.out.println("SQLException Ошибка :"+e);
            }
        }return selectMax;
    }
}


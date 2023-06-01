package ltmck;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class connJDBC {

    static String url = "jdbc:mysql://localhost:3307/students_manager";
    static String user = "root";
    static String password = "";

    public static Connection getCOnnection() { // connection funtion
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return connection;
    }

    public static void closeConnect(Connection con) {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(connJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();
        String query = "select * from students_list";
        try {
            Connection connection = getCOnnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Student st = new Student(rs.getString("id"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("gender"), rs.getString("dateOfBirth"), rs.getString("class"), rs.getString("major"), rs.getString("chat"), rs.getDouble("score"));
                studentList.add(st);
            }
            connJDBC.closeConnect(connection);
        } catch (Exception e) {
            //TODO:...
        }
        return studentList;
    }

    public static File listToFile(List<Student> listS) {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = dateFormat.format(now);
        // Tạo tên tệp
        String fileName = "server" + timestamp + ".txt";
        String text = "";

        try {
            File file = new File(fileName);
            FileWriter writer = new FileWriter(file);
            for (Student student : listS) {
                text = student.toString();
                writer.write(text);
                writer.write("\n");
            }
            System.out.println("Chuyển đổi chuỗi thành tệp " + file.getAbsolutePath() + " thành công.");
            writer.close();
            return file;
        } catch (IOException ex) {
//            ex.printStackTrace();
            return null;
        }
    }

    public static File studentToFile(Student student) {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = dateFormat.format(now);
        // Tạo tên tệp
        String fileName = "server" + timestamp + ".txt";
        String text = "";

        try {
            File file = new File(fileName);
            FileWriter writer = new FileWriter(file);
            text = student.toString();
            writer.write(text);
            writer.write("\n");
//            System.out.println(text);
            System.out.println("Chuyển đổi chuỗi thành tệp " + file.getAbsolutePath() + " thành công.");
            writer.close();
            return file;
        } catch (IOException ex) {
//            ex.printStackTrace();
//            System.out.println("hi");
            return null;
        }
    }

    public static boolean sendFile(File file, InetAddress address, int port) throws IOException {
        if (file == null || !file.exists() || !file.isFile()) {
            return false;
        }

        try (DatagramSocket socket = new DatagramSocket()) {
            // Đọc nội dung file thành byte array và gửi đi
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(file);
            oos.flush();
            byte[] buffer = bos.toByteArray();
// Gửi mảng byte đến client
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, port);
            socket.send(packet);
            System.out.println("File sent to client: " + file.getAbsolutePath());
            socket.close();
            return true;
        } catch (IOException ex) {
            System.err.println("Error sending file: " + ex.getMessage());
            throw ex;
        }
    }

    public static boolean insert(Student st) {
        String query = "insert into students_list(id,firstName,lastName,gender,dateOfBirth,class,major,score,chat) values (?,?,?,?,?,?,?,?,?)";
        try {
            Connection connection = getCOnnection();
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, Integer.toString(getIDFromDB() + 1));
//            System.out.println(Integer.toString(getIDFromDB() + 1));
            pstmt.setString(2, st.getFirstName());
            pstmt.setString(3, st.getLastName());
            pstmt.setString(4, st.getGender());
            pstmt.setString(5, st.getDateOfBirth());
            pstmt.setString(6, st.getStudentClass());
            pstmt.setString(7, st.getMajor());
            pstmt.setDouble(8, st.getScore());
            pstmt.setString(9, st.getChatting());
            pstmt.execute();
            connJDBC.closeConnect(connection);
            return true;
        } catch (SQLException ex) {
            //TODO
            System.out.println(ex.toString());
            return false;
        }
    }

    public static boolean delete(String id) {
        String query = "delete from students_list where id='" + id + "'";
        try {
            Connection connection = getCOnnection();
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.executeUpdate();
            connJDBC.closeConnect(connection);
            return true;
        } catch (Exception ex) {
            //TODO: handle exception
            return false;
        }
    }

    public static boolean update(Student st) {
        String query = "update students_list set firstName=?,lastName=?,gender=?,dateOfBirth=?,class=?,major=?,score=?, chat=? where id ='" + st.getID() + "'";
        try {
            Connection connection = getCOnnection();
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, st.getFirstName());
            pstmt.setString(2, st.getLastName());
            pstmt.setString(3, st.getGender());
            pstmt.setString(4, st.getDateOfBirth());
            pstmt.setString(5, st.getStudentClass());
            pstmt.setString(6, st.getMajor());
            pstmt.setDouble(7, st.getScore());
            pstmt.setString(8, st.getChatting());
            pstmt.executeUpdate();
            connJDBC.closeConnect(connection);
            return true;
        } catch (Exception ex) {
            //TODO: handle exception
            return false;
        }
    }

    public static Student findByID(Student s) {
        String query = "select * from students_list where id='"+s.getID()+"'";
        Student stTemp = new Student();
        try {
            Connection connection = getCOnnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                stTemp = new Student(rs.getString("id"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("gender"), rs.getString("dateOfBirth"), rs.getString("class"), rs.getString("major"), rs.getString("chat"), rs.getDouble("score"));
            }
            connJDBC.closeConnect(connection);
            return stTemp;
        } catch (Exception e) {
            //TODO:...
        }
        return stTemp;
    }

    public static int getIDFromDB() {
        int id = 0;
        String query = "SELECT MAX(CAST(id AS UNSIGNED)) FROM students_list; ";
        try {
            Connection connection = getCOnnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String maxStudentIdStr = rs.getString(1);
                id = Integer.parseInt(maxStudentIdStr);
            }
            connJDBC.closeConnect(connection);
        } catch (Exception e) {
            return 0;
        }
        return id;
    }

//    public static void main(String args[]) {
//        Student st = new Student("2", "", "", "", "", "", "", "", 0);
//        studentToFile(st);
////        System.out.println(connJDBC.findByID(new Student("2", "", "", "", "", "", "", "", 0)));
//    }
}

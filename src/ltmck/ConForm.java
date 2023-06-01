package ltmck;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ConForm {

    private static final int PACKET_SIZE = 1024;
    private static final int HASH_SIZE = 32;

    int port;
    InetAddress iphost;
    DatagramSocket socket;
    File f;
    static File file;

    public DatagramSocket getSocket() {
        return socket;
    }

    public InetAddress getIphost() {
        return iphost;
    }

    public int getPort() {
        return this.port;
    }

    public void setPort(int p) {
        this.port = p;
    }

    public File getF() {
        return f;
    }

    public void setF(File f) {
        this.f = f;
    }

    public void setIphost(InetAddress iphost) {
        this.iphost = iphost;
    }

    public void setSocket(DatagramSocket socket) {
        this.socket = socket;
    }

    public boolean sendPacketToServer(Student student, ConForm cn, String tool) {
        try {
            // Tạo file từ đối tượng student
            Vigenere vi = new Vigenere("hello");
            File file = stringToFile(vi.encode(student.toString()));

            // Kiểm tra file có tồn tại không
            if (file == null || !file.exists() || !file.isFile()) {
                System.err.println("Error: Invalid file!");
                return false;
            }

            // Gửi gói tin đến máy chủ
            int port = 9876;
            InetAddress iphost = cn.getIphost();
            System.out.println(iphost + "" + cn.getIphost());
            if (iphost == null) {
                System.err.println("Error: Invalid server IP!");
                return false;
            }
            if (!sendFile(file, iphost, port, tool)) {
                System.err.println("Error: Failed to send file to server!");
                return false;
            }

            // Hiển thị thông báo gửi dữ liệu thành công
            JOptionPane.showMessageDialog(null, "Data sent to Server!");

            // Đóng tài nguyên
            file.delete();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error sending data to Server: " + ex.getMessage());
            System.err.println("Error: " + ex.getMessage());
            return false;
        }
        return true;
    }

    public void getDB() {
//        List<Student> list = new ArrayList<>();
        try {
            byte[] buffer = "Connected".getBytes();
            DatagramPacket connPacket = new DatagramPacket(buffer, buffer.length, iphost, port);
            socket.send(connPacket);
            socket.send(connPacket);
            socket.send(connPacket);

            byte[] buf = new byte[100000];
            DatagramPacket serverPacket = new DatagramPacket(buf, buf.length);
            socket.receive(serverPacket);

            ByteArrayInputStream bis = new ByteArrayInputStream(serverPacket.getData());
            ObjectInputStream ois = new ObjectInputStream(bis);
            File f;
            try {
                f = (File) ois.readObject();
            } catch (ClassNotFoundException ex) {
                f = null;
                System.err.println(ex);
            }
            setF(f);
            this.f = f;
//            return list;
        } catch (IOException ex) {
//            Logger.getLogger(ConForm.class.getName()).log(Level.SEVERE, null, ex);
        }
//        return list;
    }

    public static boolean sendMessToServer(String m, ConForm cn, String tool) {
        try {
            // Tạo file từ đối tượng student
            Vigenere vi = new Vigenere("hello");
            File file = stringToFile(vi.encode(m));

            // Kiểm tra file có tồn tại không
            if (file == null || !file.exists() || !file.isFile()) {
                System.err.println("Error: Invalid file!");
                return false;
            }

            // Gửi gói tin đến máy chủ
            int port = 9876;
            InetAddress iphost = cn.getIphost();
            System.out.println(iphost + "" + cn.getIphost());
            if (iphost == null) {
                System.err.println("Error: Invalid server IP!");
                return false;
            }
            if (!sendFile(file, iphost, port, tool)) {
                System.err.println("Error: Failed to send file to server!");
                return false;
            }

            // Hiển thị thông báo gửi dữ liệu thành công
            JOptionPane.showMessageDialog(null, "Data sent to Server!");

            // Đóng tài nguyên
            file.delete();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error sending data to Server: " + ex.getMessage());
            System.err.println("Error: " + ex.getMessage());
            return false;
        }
        return true;
    }

    public static boolean sendFile(File file, InetAddress address, int port, String tool) throws IOException {
        if (file == null || !file.exists() || !file.isFile()) {
            return false;
        }

        try (DatagramSocket socket = new DatagramSocket()) {
            // Chuyển đổi tên file thành byte array và gửi đi
            if (tool != "Find by id") {
                String filename = file.getName();
                byte[] filenameBytes = filename.getBytes();
                DatagramPacket packetName = new DatagramPacket(filenameBytes, filenameBytes.length, address, port);
                socket.send(packetName);

                // Đọc nội dung file thành byte array và gửi đi
                byte[] fileContentBytes = Files.readAllBytes(file.toPath());
                DatagramPacket packetContent = new DatagramPacket(fileContentBytes, fileContentBytes.length, address, port);
                socket.send(packetContent);

                byte[] toolBytes = tool.getBytes();
                DatagramPacket packetTool = new DatagramPacket(toolBytes, toolBytes.length, address, port);
                socket.send(packetTool);

                System.out.println("File sent to server: " + file.getAbsolutePath());
                return true;
            } else {
                String filename = file.getName();
                byte[] filenameBytes = filename.getBytes();
                DatagramPacket packetName = new DatagramPacket(filenameBytes, filenameBytes.length, address, port);
                socket.send(packetName);

                // Đọc nội dung file thành byte array và gửi đi
                byte[] fileContentBytes = Files.readAllBytes(file.toPath());
                DatagramPacket packetContent = new DatagramPacket(fileContentBytes, fileContentBytes.length, address, port);
                socket.send(packetContent);

                byte[] toolBytes = tool.getBytes();
                DatagramPacket packetTool = new DatagramPacket(toolBytes, toolBytes.length, address, port);
                socket.send(packetTool);

                System.out.println("File sent to server: " + file.getAbsolutePath());

                byte[] buf = new byte[100000];
                DatagramPacket serverPacket = new DatagramPacket(buf, buf.length);
                socket.receive(serverPacket);

                ByteArrayInputStream bis = new ByteArrayInputStream(serverPacket.getData());
                ObjectInputStream ois = new ObjectInputStream(bis);
                File f;
                try {
                    f = (File) ois.readObject();
                    System.out.println(f.getName() + " here");
                } catch (ClassNotFoundException ex) {
                    f = null;
                    System.err.println(ex);
                }
//                setF(f);
                ConForm.file = f;
                System.out.println(ConForm.file.getName());
                return true;

            }
        } catch (IOException ex) {
            System.err.println("Error sending file: " + ex.getMessage());
            throw ex;
        }
    }

    public static File stringToFile(String text) {
        // Lấy thời gian hiện tại
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = dateFormat.format(now);

        // Tạo tên tệp
        String fileName = "user" + timestamp + ".txt";

        try {
            File file = new File(fileName);
            FileWriter writer = new FileWriter(file);
            writer.write(text);
            System.out.println("Chuyển đổi chuỗi thành tệp " + file.getAbsolutePath() + " thành công.");
            writer.close();
            return file;
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static List<Student> readStudentsFromFile(String fileName) {
        List<Student> studentList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String str1 = line.replace(" ", "");
                str1 = str1.replace("{", "").replace("}", "").replace("Student", "");
                String[] listInfor = str1.split(",");
                String id = "", firstName = "", lastName = "", gender = "", dateOfBirth = "", studentClass = "", major = "", chatting = "";
                Double score = 0.0;
                try {
                    id = listInfor[0].split("=")[1];
                } catch (Exception e) {
                    System.out.println("Error while reading ID: " + e.getMessage());
                }
                try {
                    firstName = listInfor[1].split("=")[1];
                } catch (Exception e) {
                    System.out.println("Error while reading firstName: " + e.getMessage());
                }
                try {
                    lastName = listInfor[2].split("=")[1];
                } catch (Exception e) {
                    System.out.println("Error while reading lastName: " + e.getMessage());
                }
                try {
                    gender = listInfor[3].split("=")[1];
                } catch (Exception e) {
                    System.out.println("Error while reading gender: " + e.getMessage());
                }
                try {
                    dateOfBirth = listInfor[4].split("=")[1];
                } catch (Exception e) {
                    System.out.println("Error while reading dateOfBirth: " + e.getMessage());
                }
                try {
                    studentClass = listInfor[5].split("=")[1];
                } catch (Exception e) {
                    System.out.println("Error while reading studentClass: " + e.getMessage());
                }
                try {
                    major = listInfor[6].split("=")[1];
                } catch (Exception e) {
                    System.out.println("Error while reading major: " + e.getMessage());
                }
                try {
                    chatting = listInfor[7].split("=")[1];
                } catch (Exception e) {
                    System.out.println("Error while reading chatting: " + e.getMessage());
                }
                try {
                    score = Double.parseDouble(listInfor[8].split("=")[1]);
                } catch (Exception e) {
                    System.out.println("Error while reading score: " + e.getMessage());
                }
                Student student = new Student(id, firstName, lastName, gender, dateOfBirth, studentClass, major, chatting, score);
                studentList.add(student);
            }
            System.out.println("done");
//            this.list = studentList;
            System.out.println(studentList.get(0));
            return studentList;
        } catch (IOException ex) {
            System.out.println("Error while reading file: " + ex.getMessage());
        }
        return (studentList);
    }

    void getDBwithID(String id) {
        try {
            byte[] buff = "Find by id".getBytes();
//           
//            System.out.println();
            DatagramPacket connPacket = new DatagramPacket(buff, buff.length, iphost, port);
//            socket.send(connPacket);
//            byte[] idb = ("id="+id).getBytes();
//            DatagramPacket connPacket1 = new DatagramPacket(idb, idb.length, iphost, port);
//            socket.send(connPacket1);
//            socket.send(connPacket);
            File file = stringToFile(id);

            try (DatagramSocket socket = new DatagramSocket()) {

                byte[] buf = new byte[100000];
                DatagramPacket serverPacket = new DatagramPacket(buf, buf.length);
                socket.receive(serverPacket);

                ByteArrayInputStream bis = new ByteArrayInputStream(serverPacket.getData());
                ObjectInputStream ois = new ObjectInputStream(bis);
                File f;
                try {
                    f = (File) ois.readObject();
                    System.out.println(f.getName() + " here");
                } catch (ClassNotFoundException ex) {
                    f = null;
                    System.err.println(ex);
                }
                setF(f);
                this.f = f;
                socket.close();
            } catch (IOException ex) {
                System.err.println("Error sending file: " + ex.getMessage());
                throw ex;
            }

//            return list;
        } catch (IOException ex) {
//            Logger.getLogger(ConForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

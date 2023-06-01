package ltmck;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
//import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.awt.List;

public class UDPServerNew extends JFrame {

    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea messageArea;
    private DatagramSocket socket;
    private Container contentPane;

    public UDPServerNew() throws UnknownHostException, IOException {
        super("UDP Server");

        jScrollPane1 = new javax.swing.JScrollPane();
        messageArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        getContentPane().setBackground(new Color(238, 224, 229));
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        messageArea.setColumns(20);
        messageArea.setRows(5);
        messageArea.setEditable(false);
        jScrollPane1.setViewportView(messageArea);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("WELCOME TO UDP SERVER");

        jLabel2.setText("MADE BY TEAM 5");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Port: 9876");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/TDT_logo.png"))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/people.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(26, 26, 26))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(38, 38, 38)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(153, 153, 153))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(1, 1, 1)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(47, 47, 47)
                        .addComponent(jLabel5)
                        .addGap(59, 59, 59))))
        );

        pack();
//        add(label, BorderLayout.NORTH);
        // Hiển thị JFrame
        setVisible(true);
        setResizable(false);

        // Bắt đầu lắng nghe kết nối từ Client
        startServer();
    }

    private void startServer() throws IOException {
        DatagramSocket socket = null;
        try {
            // Create a DatagramSocket to receive data from clients
            socket = new DatagramSocket(9876);

            System.out.println("Server is listening...");
            byte[] buffer = new byte[2024];
            byte[] sendData;
            DatagramPacket namePacket;
            DatagramPacket contentPacket;
            DatagramPacket toolPacket;
            String message1, message2, message3;
//            DatagramPacket connPacket = new DatagramPacket(buffer, buffer.length);
//            socket.receive(connPacket);
//            String message = new String(connPacket.getData(), 0, connPacket.getLength()).trim();
//            messageArea.append(connPacket.getAddress().getHostAddress() + ": " + message + "\n");
//            connJDBC.sendFile(connJDBC.listToFile(connJDBC.findAll()), connPacket.getAddress(), connPacket.getPort());
            while (true) {
                // Receive data from clients
                namePacket = new DatagramPacket(buffer, buffer.length);
                socket.receive(namePacket);
                contentPacket = new DatagramPacket(buffer, buffer.length);
                socket.receive(contentPacket);
                toolPacket = new DatagramPacket(buffer, buffer.length);
                socket.receive(toolPacket);

                // Get the message content from the received packets
                message1 = new String(namePacket.getData(), 0, namePacket.getLength()).trim();

                message2 = new String(contentPacket.getData(), 0, contentPacket.getLength()).trim();

                message3 = new String(toolPacket.getData(), 0, toolPacket.getLength()).trim();

                // Display the message in the messageArea
                // Handle the message based on the tool
                switch (message3) {
                    case "Add":
                        messageArea.append(namePacket.getAddress().getHostAddress() + ": " + message1 + "\n");
                        messageArea.append(contentPacket.getAddress().getHostAddress() + ": " + message2 + "\n");
                        messageArea.append(toolPacket.getAddress().getHostAddress() + ": " + message3 + "\n");

                        System.out.println("2");
                        if (addStudentToDB(message2)) {
                            JOptionPane.showMessageDialog(null, "Student added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Student added fail.", "Fail", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case "Delete":
                        messageArea.append(namePacket.getAddress().getHostAddress() + ": " + message1 + "\n");
                        messageArea.append(contentPacket.getAddress().getHostAddress() + ": " + message2 + "\n");
                        messageArea.append(toolPacket.getAddress().getHostAddress() + ": " + message3 + "\n");

                        if (deleteStudentToDB(message2)) {
                            JOptionPane.showMessageDialog(null, "Student deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Student deleted fail.", "Fail", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case "Update":
                        messageArea.append(namePacket.getAddress().getHostAddress() + ": " + message1 + "\n");
                        messageArea.append(contentPacket.getAddress().getHostAddress() + ": " + message2 + "\n");
                        messageArea.append(toolPacket.getAddress().getHostAddress() + ": " + message3 + "\n");

                        // code to be executed if expression matches value3
                        if (updateStudentToDB(message2)) {
                            JOptionPane.showMessageDialog(null, "Student update successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Student update fail.", "Fail", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case "Find by id":
                        messageArea.append(namePacket.getAddress().getHostAddress() + ": " + message1 + "\n");
                        System.out.println("chỗ mess");
                        messageArea.append(contentPacket.getAddress().getHostAddress() + ": " + message2 + "\n");
                        System.out.println("mes giữa");
                        messageArea.append(toolPacket.getAddress().getHostAddress() + ": " + message3 + "\n");
                        System.out.println("mes cuói");

//                        try {
//                            System.out.println("ở trên");
//                            Student rs1 = findStudentToDBByID(message2);
//                            if (rs1.getID() != "") {
//                                connJDBC.sendFile(connJDBC.studentToFile(rs1), contentPacket.getAddress(), contentPacket.getPort());
//                                System.out.println("ở đây");
//                                JOptionPane.showMessageDialog(null, "Find student successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
//
//                            } else {
//                                JOptionPane.showMessageDialog(null, "Find student fail. ở trên", "Fail", JOptionPane.INFORMATION_MESSAGE);
//                            }
//                            
//                        } catch (Exception e) {
//
//                        }
                        Student rs = findStudentToDB(message2);
                        if (rs.getID() != "") {
                            connJDBC.sendFile(connJDBC.studentToFile(rs), contentPacket.getAddress(), contentPacket.getPort());
                            System.out.println("dưới này");
                            JOptionPane.showMessageDialog(null, "Find student successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);

                        } else {
                            JOptionPane.showMessageDialog(null, "Find student fail.", "Fail", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    // code to be executed if expression matches value4
                    case "Connected":
                        message2 = new String(contentPacket.getData(), 0, contentPacket.getLength()).trim();
                        messageArea.append(contentPacket.getAddress().getHostAddress() + ": " + message2 + "\n");
                        connJDBC.sendFile(connJDBC.listToFile(connJDBC.findAll()), contentPacket.getAddress(), contentPacket.getPort());
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Unknown tool: " + message3, "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                }

                // Send data back to the client
                sendData = message2.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, contentPacket.getAddress(), contentPacket.getPort());
                socket.send(sendPacket);

                // Close the packets
                namePacket.setLength(buffer.length);
                contentPacket.setLength(buffer.length);
                toolPacket.setLength(buffer.length);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }

    public static boolean addStudentToDB(String st) {
        Student student = new Student();
        Vigenere vi = new Vigenere("hello");
        student = student.stringToStudent(vi.decode(st));
//        System.out.println(vi.decode(st));
        boolean check = true;
        try {
            check = connJDBC.insert(student);
        } catch (Exception e) {
            return false;
        }
        return check;
    }

    public static boolean deleteStudentToDB(String st) {
        Student student = new Student();
        student = student.stringToStudent(st);
        boolean check = true;
        try {
            check = connJDBC.delete(student.getID());
        } catch (Exception e) {
            return false;
        }
        return check;
    }

    public static boolean updateStudentToDB(String st) {
        Student student = new Student();
        Vigenere vi = new Vigenere("hello");
        student = student.stringToStudent(vi.decode(st));
//        System.out.println(vi.decode(st));
        boolean check = true;
        try {
            check = connJDBC.update(student);
        } catch (Exception e) {
            return false;
        }
        return check;
    }

    public static Student findStudentToDB(String st) {
        Student student = new Student();
        Vigenere vi = new Vigenere("hello");
        System.out.println("chính là t");
        student = student.stringToStudent(vi.decode(st));
//        System.out.println(student.getID());
        Student rsStudent = new Student();
//        System.out.println(vi.decode(st));
        boolean check = true;
        try {
            rsStudent = connJDBC.findByID(student);
//            System.out.println(rsStudent);
        } catch (Exception e) {
            return rsStudent;
        }
        return rsStudent;
    }

    public static Student findStudentToDBByID(String st) {
//        System.out.println(student.getID());
        Student rsStudent = new Student();
//        System.out.println(vi.decode(st));
        boolean check = true;
        try {
            rsStudent = connJDBC.findByID(new Student(st, "", "", "", "", "", "", 0.0));
//            System.out.println(rsStudent);
        } catch (Exception e) {
            return rsStudent;
        }
        return rsStudent;
    }

    public static void main(String[] args) throws IOException {
        try {
//            findStudentToDB("Student{id=2, firstName=Duy, lastName=Tran, gender=Male, dateOfBirth=17/06/2003, studentClass=1, major=InformationTechnology, chatting=hello, score=10.0}");
            new UDPServerNew();
        } catch (UnknownHostException ex) {
            Logger.getLogger(UDPServerNew.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

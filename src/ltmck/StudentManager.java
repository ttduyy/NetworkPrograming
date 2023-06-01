package ltmck;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.*;
import javax.swing.table.TableModel;

public final class StudentManager extends JFrame {

    private JPanel contentPane;
    private javax.swing.JLabel bg;
    private JTextField idField;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField dateOfBirthField;
    private JTextField classField;
    private JTextField scoreField;
    private JTextField chatField;
    private static JTable table;
    private JComboBox genderBox;
    private JComboBox majorBox;
    static ConForm cn;
    private List<Student> list;
    JScrollPane scrollPane;
    MyTableModel tmodel;
//    File f;

    /**
     * Launch the application.
     */
//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    StudentManager frame = new StudentManager(cn);
//                    frame.setVisible(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }
    /**
     * Create the frame.
     */
    public StudentManager(ConForm cn) {
        this.cn = cn;
//        this.f = f;
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 998, 581);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
getContentPane().setBackground(new Color(238, 224, 229));
        JLabel lblNewLabel = new JLabel("Student Manager");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblNewLabel.setBounds(363, 11, 212, 44);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("First Name");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_1.setBounds(10, 122, 140, 33);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("ID:");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_1_1.setBounds(10, 79, 140, 33);
        contentPane.add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_2 = new JLabel("Last Name");
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_1_2.setBounds(10, 166, 140, 33);
        contentPane.add(lblNewLabel_1_2);

        JLabel lblNewLabel_1_3 = new JLabel("Gender");
        lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_1_3.setBounds(10, 210, 140, 33);
        contentPane.add(lblNewLabel_1_3);

        JLabel lblNewLabel_1_4 = new JLabel("Date of birth:");
        lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_1_4.setBounds(10, 254, 140, 33);
        contentPane.add(lblNewLabel_1_4);

        JLabel lblNewLabel_1_5 = new JLabel("Class:");
        lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_1_5.setBounds(10, 298, 140, 33);
        contentPane.add(lblNewLabel_1_5);

        JLabel lblNewLabel_1_6 = new JLabel("Major");
        lblNewLabel_1_6.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_1_6.setBounds(10, 342, 140, 33);
        contentPane.add(lblNewLabel_1_6);

        JLabel lblNewLabel_1_7 = new JLabel("Score");
        lblNewLabel_1_7.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_1_7.setBounds(10, 386, 140, 33);
        contentPane.add(lblNewLabel_1_7);

        JLabel lblNewLabel_1_8 = new JLabel("Chat:");
        lblNewLabel_1_8.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_1_8.setBounds(10, 430, 140, 33);
        contentPane.add(lblNewLabel_1_8);

        JButton addButton = new JButton("ADD");
        addButton.addActionListener(this::addButtonActionPerformed);
        addButton.setFont(new Font("Tahoma", Font.BOLD, 22));
        addButton.setBounds(77, 484, 121, 44);
        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add-user.png")));
        contentPane.add(addButton);

        JButton deleteButton = new JButton("DELETE");
        deleteButton.addActionListener(this::deleteButtonActionPerformed);
        deleteButton.setFont(new Font("Tahoma", Font.BOLD, 22));
        deleteButton.setBounds(265, 484, 150, 44);
        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete-user.png")));
        contentPane.add(deleteButton);

        JButton findButton = new JButton("FIND");
        findButton.addActionListener(this::findByIDButtonActionPerform);
        findButton.setFont(new Font("Tahoma", Font.BOLD, 22));
        findButton.setBounds(475, 484, 121, 44);
        findButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/find.png")));
        contentPane.add(findButton);

        JButton updateButton = new JButton("UPDATE");
        updateButton.addActionListener(this::updateButtonActionPerform);
        updateButton.setFont(new Font("Tahoma", Font.BOLD, 22));
        updateButton.setBounds(660, 484, 180, 44);
        updateButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/profile.png")));
        contentPane.add(updateButton);

        idField = new JTextField();
        idField.setBounds(197, 80, 192, 33);
        contentPane.add(idField);
        idField.setColumns(10);

        firstNameField = new JTextField();
        firstNameField.setColumns(10);
        firstNameField.setBounds(197, 122, 192, 33);
        contentPane.add(firstNameField);

        lastNameField = new JTextField();
        lastNameField.setColumns(10);
        lastNameField.setBounds(197, 166, 192, 33);
        contentPane.add(lastNameField);

        dateOfBirthField = new JTextField();
        dateOfBirthField.setColumns(10);
        dateOfBirthField.setBounds(197, 254, 192, 33);
        contentPane.add(dateOfBirthField);

        classField = new JTextField();
        classField.setColumns(10);
        classField.setBounds(197, 298, 192, 33);
        contentPane.add(classField);

        scoreField = new JTextField();
        scoreField.setColumns(10);
        scoreField.setBounds(197, 386, 192, 33);
        contentPane.add(scoreField);

        chatField = new JTextField();
        chatField.setColumns(10);
        chatField.setBounds(197, 430, 192, 33);
        contentPane.add(chatField);

        showTable();

        genderBox = new JComboBox();
        genderBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
        genderBox.setModel(new DefaultComboBoxModel(new String[]{"Other", "Male", "Female"}));
        genderBox.setBounds(197, 210, 192, 33);
        contentPane.add(genderBox);

        majorBox = new JComboBox();
        majorBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
        majorBox.setModel(new DefaultComboBoxModel(new String[]{"Other", "Information Technology", "Biology Technology", "Biomedical Engineering", "Accounting", "Business Administration", "Electrical Engineering", "Finance and Banking", "Human Resource Management", "International Payment", "International Trade", "Marketing", "Materials Science", "Mechanical Engineering"}));
        majorBox.setBounds(197, 342, 192, 33);
        contentPane.add(majorBox);

        bg = new javax.swing.JLabel();
        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bgt.png"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 630));
    }

    public void showTable() {
        cn.getDB();
//        System.out.println(cn.getF().getName());

        this.tmodel = new MyTableModel(showData(ConForm.readStudentsFromFile(cn.f.getName())));

//        this.scrollPane.setVisible(false);
//        contentPane.;
        this.scrollPane = new JScrollPane();
        scrollPane.setBounds(436, 79, 538, 384);
        contentPane.add(scrollPane);
        this.table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][]{
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},},
                new String[]{
                    "ID", "First Name", "Last Name", "Gender", "DateOfBirth", "Class", "Major", "Score", "Chat"
                }
        ) {
            Class[] columnTypes = new Class[]{
                String.class, String.class, String.class, String.class, String.class, String.class, String.class, Double.class, String.class
            };

            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        });
        table.getColumnModel().getColumn(0).setPreferredWidth(62);
        table.getColumnModel().getColumn(1).setPreferredWidth(102);
        table.getColumnModel().getColumn(2).setPreferredWidth(108);
        table.getColumnModel().getColumn(3).setPreferredWidth(56);
        table.getColumnModel().getColumn(4).setPreferredWidth(106);
        table.getColumnModel().getColumn(7).setPreferredWidth(55);
        table.getColumnModel().getColumn(8).setPreferredWidth(55);
        table.setFont(new Font("Tahoma", Font.PLAIN, 14));
        this.table.setModel(tmodel.getTm());
        table.repaint();
        System.out.println(tmodel.getTm().getRowCount());
//        this.scrollPane.setVisible(false);
        scrollPane.setViewportView(table);
        contentPane.add(scrollPane);
        contentPane.setComponentZOrder(scrollPane, 0);
    }

    private void addButtonActionPerformed(ActionEvent e) {
        Student st = new Student();
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String gender = (String) genderBox.getSelectedItem();
        String major = (String) majorBox.getSelectedItem();
        String studentClass = classField.getText();
        double score;
        String scoreText = scoreField.getText().trim();
        String chat = chatField.getText();
        if (!scoreText.isEmpty()) {
            score = Double.parseDouble(scoreText);
            if (score > 10 || score < 0) {
                JOptionPane.showMessageDialog(this, "Your score what you entered, is wrong", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } else {
            // Hiển thị panel thông báo lỗi nếu người dùng không nhập điểm số
            JOptionPane.showMessageDialog(this, "Please enter your score", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            String dateOfBirth = dateOfBirthField.getText();

            // Tạo đối tượng Student với các thông tin vừa lấy được
            st = new Student("", firstName, lastName, gender, dateOfBirth, studentClass, major, chat, score);
        } catch (Exception ex) {
            // Hiển thị panel thông báo lỗi nếu người dùng nhập sai định dạng ngày tháng
            JOptionPane.showMessageDialog(this, "Please enter your date of birth in the format dd/MM/yyyy", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Thêm đối tượng Student mới tạo vào danh sách hoặc cơ sở dữ liệu
        // ...
        // Tạo đối tượng DatagramSocket để gửi và nhận các gói tin UDP
        try {
            DatagramSocket socket = cn.getSocket();
            boolean check = cn.sendPacketToServer(st, cn, "Add");
            if (!check) {
                JOptionPane.showMessageDialog(this, "Add Fail !!!!", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (Exception ex) {
            // Xử lý lỗi ở đây
        }
        showTable();
        clearContent();
    }

    private void deleteButtonActionPerformed(ActionEvent e) {
        String idText = idField.getText().trim();
        String id;
        if (!idText.isEmpty()) {
            id = idText;
        } else {
            // Hiển thị panel thông báo lỗi nếu người dùng không nhập điểm số
            JOptionPane.showMessageDialog(this, "Please enter your id student", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Student st = new Student(id, "", "", "", "", "", "", 0.0);
//        System.out.println(id);
        try {
            DatagramSocket socket = cn.getSocket();
//            System.out.println("Here");
            boolean check = cn.sendPacketToServer(st, cn, "Delete");
            if (!check) {
                JOptionPane.showMessageDialog(this, "Delete Fail !!!!", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (Exception ex) {
            // Xử lý lỗi ở đây
        }
        showTable();
        clearContent();
    }

    private void updateButtonActionPerform(ActionEvent e) {
        Student st = new Student();
        String id = "";
        try {
            id = idField.getText().trim();
            if (id.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter your id", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Please enter your id", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String gender = (String) genderBox.getSelectedItem();
        String major = (String) majorBox.getSelectedItem();
        String studentClass = classField.getText();
        double score;
        String scoreText = scoreField.getText().trim();
        String chat = chatField.getText();
        if (!scoreText.isEmpty()) {
            score = Double.parseDouble(scoreText);
            if (score > 10 || score < 0) {
                JOptionPane.showMessageDialog(this, "Your score what you entered, is wrong", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } else {
            // Hiển thị panel thông báo lỗi nếu người dùng không nhập điểm số
            JOptionPane.showMessageDialog(this, "Please enter your score", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            String dateOfBirth = dateOfBirthField.getText();

            // Tạo đối tượng Student với các thông tin vừa lấy được
            st = new Student(id, firstName, lastName, gender, dateOfBirth, studentClass, major, chat, score);
        } catch (Exception ex) {
            // Hiển thị panel thông báo lỗi nếu người dùng nhập sai định dạng ngày tháng
            JOptionPane.showMessageDialog(this, "Please enter your date of birth in the format dd/MM/yyyy", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Thêm đối tượng Student mới tạo vào danh sách hoặc cơ sở dữ liệu
        // ...
        // Tạo đối tượng DatagramSocket để gửi và nhận các gói tin UDP
        try {
            DatagramSocket socket = cn.getSocket();
            boolean check = cn.sendPacketToServer(st, cn, "Update");
            if (!check) {
                JOptionPane.showMessageDialog(this, "Update Fail !!!!", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (Exception ex) {
            // Xử lý lỗi ở đây
        }
        showTable();
        clearContent();
    }

    private void findByIDButtonActionPerform(ActionEvent e) {
        Student st = new Student();
        String id = "";
        try {
            id = idField.getText().trim();
//            if (!id.isEmpty()) {
//                JOptionPane.showMessageDialog(this, "Please enter your id", "ERROR", JOptionPane.ERROR_MESSAGE);
//            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Please enter your id", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        // Thêm đối tượng Student mới tạo vào danh sách hoặc cơ sở dữ liệu
        // ...
        // Tạo đối tượng DatagramSocket để gửi và nhận các gói tin UDP
        try {
            DatagramSocket socket = cn.getSocket();
            st = new Student(id, "", "", "", "", "", "", "", 0.0);
            
            System.out.println("im here ok");
            boolean check = cn.sendPacketToServer(st, cn, "Find by id");
//            System.out.println(ConForm.file.getName());
            showTableFind();
            clearContent();
//            try {
//                byte[] buf = new byte[100000];
//                DatagramPacket serverPacket = new DatagramPacket(buf, buf.length);
//                cn.socket.receive(serverPacket);
//
//                ByteArrayInputStream bis = new ByteArrayInputStream(serverPacket.getData());
//                ObjectInputStream ois = new ObjectInputStream(bis);
//                File f;
//                try {
//                    f = (File) ois.readObject();
//                } catch (ClassNotFoundException ex) {
//                    f = null;
//                    System.err.println(ex);
//                }
//                cn.setF(f);
////            return list;
//            } catch (IOException ex) {
//                System.out.println("loi");
////            Logger.getLogger(ConForm.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            showTableFind(id);
            System.out.println("imok");
            if (!check) {
                JOptionPane.showMessageDialog(this, "Update Fail !!!!", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (Exception ex) {
            // Xử lý lỗi ở đây
        }
    }

    public void showTableFind() {
//        cn.getDBwithID(id);
//        System.out.println(cn.getF().getName());
        this.tmodel = new MyTableModel(showData(ConForm.readStudentsFromFile(ConForm.file.getName())));
//        this.scrollPane.setVisible(false);
//        contentPane.;
        this.scrollPane = new JScrollPane();
        scrollPane.setBounds(436, 79, 538, 384);
        contentPane.add(scrollPane);
        this.table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][]{
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},},
                new String[]{
                    "ID", "First Name", "Last Name", "Gender", "DateOfBirth", "Class", "Major", "Score", "Chat"
                }
        ) {
            Class[] columnTypes = new Class[]{
                String.class, String.class, String.class, String.class, String.class, String.class, String.class, Double.class, String.class
            };

            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        });
        table.getColumnModel().getColumn(0).setPreferredWidth(62);
        table.getColumnModel().getColumn(1).setPreferredWidth(102);
        table.getColumnModel().getColumn(2).setPreferredWidth(108);
        table.getColumnModel().getColumn(3).setPreferredWidth(56);
        table.getColumnModel().getColumn(4).setPreferredWidth(106);
        table.getColumnModel().getColumn(7).setPreferredWidth(55);
        table.getColumnModel().getColumn(8).setPreferredWidth(55);
        table.setFont(new Font("Tahoma", Font.PLAIN, 14));
        this.table.setModel(tmodel.getTm());
        table.repaint();
        System.out.println(tmodel.getTm().getRowCount());
//        this.scrollPane.setVisible(false);
        scrollPane.setViewportView(table);
        contentPane.add(scrollPane);
        contentPane.setComponentZOrder(scrollPane, 0);
    }

    public TableModel showData(List<Student> students) {
        DefaultTableModel tableModel = null;
//        try {
        List<Student> listS = new ArrayList<>();
        tableModel = new DefaultTableModel(new String[]{
            "ID", "First Name", "Last Name", "Gender", "DateOfBirth", "Class", "Major", "Score", "Chat"
        }, students.size());
        listS = students;
//            DefaultTableModel tableModel;
//            JTable table = new JTable(tableModel); // create new JTable instance
//            table.getModel();
//            tableModel = (DefaultTableModel) this.table.getModel();
        tableModel.setRowCount(0);
//            listS.forEach((Student student) -> {
//                tableModel.addRow(new Object[][]{
//                    student.getID(), student.getFirstName(), student.getLastName(), student.getGender(), student.getDateOfBirth(), student.getClass(), student.getMajor(), student.getScore(), student.getChatting()
//                });
//            });
        for (Student student : listS) {
            tableModel.addRow(new Object[]{
                student.getID(), student.getFirstName(), student.getLastName(), student.getGender(), student.getDateOfBirth(), student.getStudentClass(), student.getMajor(), student.getScore(), student.getChatting()
            });
            System.out.println(student);
        }
//            for(Student i : )
//            System.out.println();
        return tableModel;

    }
    
    public void clearContent(){
        idField.setText("");
        firstNameField.setText("");
        lastNameField.setText("");
        dateOfBirthField.setText("");
        classField.setText("");
        chatField.setText("");
        scoreField.setText("");
        genderBox.setSelectedIndex(0);
        majorBox.setSelectedIndex(0);
    }

}

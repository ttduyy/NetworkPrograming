package ltmck;


import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Student {

    private String id = "";
    private String firstName;
    private String lastName;
    private String gender;
    private String dateOfBirth;
    private String studentClass;
    private String major;
    private String chatting;
    private double score;

    public Student(String firstName, String lastName, String gender, String dateOfBirth, String studentClass, String major, double score) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.studentClass = studentClass;
        this.major = major;
        this.score = score;
    }

    public Student(String id, String firstName, String lastName, String gender, String dateOfBirth, String studentClass, String major, double score) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.studentClass = studentClass;
        this.major = major;
        this.score = score;
    }

    public Student(String id, String firstName, String lastName, String gender, String dateOfBirth, String studentClass, String major, String chatting, double score) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.studentClass = studentClass;
        this.major = major;
        this.chatting = chatting;
        this.score = score;
    }

    public Student() {
        this.id = "";
        this.firstName = "";
        this.lastName = "";
        this.gender = "";
        this.dateOfBirth = "";
        this.studentClass = "";
        this.major = "";
        this.score = 0;
    }

    // Getter, Setter cho các thuộc tính
    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getChatting() {
        return chatting;
    }

    public void setChatting(String chatting) {
        this.chatting = chatting;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth + ", studentClass=" + studentClass + ", major=" + major + ", chatting=" + chatting + ", score=" + score + '}';
    }

    public List<Student> stringToList(String st) {
        List<Student> stList = new ArrayList<>();
        String[] str1 = st.split("\n");
        for (String string : str1) {
            stList.add(stringToStudent(string));
        }
        return stList;
    }

    public Student stringToStudent(String str) {
        String str1 = str.replace(" ", "");
        str1 = str1.replace("{", "").replace("}", "").replace("Student", "");
        String[] listInfor = str1.split(",");
        String id, firstName, lastName, gender, dateOfBirth, studentClass, major, chatting;
//        System.out.println(str1);
//        for(int i =0;i<listInfor.length;i++){
//            System.out.println(listInfor[i]);
//        }
        Double score = 0.0;
        try {
            id = listInfor[0].split("=")[1];
        } catch (Exception e) {
            id = "";
//            System.out.println("minh");
//            System.out.println(e);
        }
        try {
            firstName = listInfor[1].split("=")[1];
        } catch (Exception e) {
            firstName = "";
            System.out.println(e);
        }
        try {
            lastName = listInfor[2].split("=")[1];
        } catch (Exception e) {
            lastName = "";
            System.out.println(e);
        }
        try {
            gender = listInfor[3].split("=")[1];
        } catch (Exception e) {
            gender = "";
            System.out.println(e);
        }
        try {
            dateOfBirth = listInfor[4].split("=")[1];
        } catch (Exception e) {
            dateOfBirth = "";
//            System.out.println("dateOfBirthError");
            System.out.println(e);
        }
        try {
            studentClass = listInfor[5].split("=")[1];
//            System.out.println(studentClass);
        } catch (Exception e) {
            studentClass = "";
            System.out.println(e);
        }
        try {
            major = listInfor[6].split("=")[1];
        } catch (Exception e) {
            major = "";
//            System.out.println("minh");
            System.out.println(e);
        }
        try {
            chatting = listInfor[7].split("=")[1];
        } catch (Exception e) {
            chatting = "";
            System.out.println(e);
        }
        try {
            score = Double.parseDouble(listInfor[8].split("=")[1]);
        } catch (Exception e) {
            score = 0.0;
            System.out.println(e);
        }

        return new Student(id, firstName, lastName, gender, dateOfBirth, studentClass, major, chatting, score);
    }

//    public static void main(String args[]) {
//        Student st = new Student();
//        List<Student> lt = st.stringToList("Student{id=1, firstName=Minh, lastName=Nguyen, gender=Male, dateOfBirth=26/03/2003, studentClass=1, major=InformationTechnology, chatting=hello, score=8.0}\n"
//                + "Student{id=2, firstName=jjj, lastName=jjjj, gender=Male, dateOfBirth=9, studentClass=3, major=InformationTechnology, chatting=9999, score=7.0}\n"
//                + "Student{id=3, firstName=Duy, lastName=Tran, gender=Male, dateOfBirth=8, studentClass=8, major=InformationTechnology, chatting=helloworld, score=8.0}");
//        System.out.println(lt.get(1).toString());
//    }

}
//System.out.println(id);
//            firstName = listInfor[1].split("=")[1];
//            lastName = listInfor[2].split("=")[1];
//            gender = listInfor[3].split("=")[1];
//            dateOfBirth = listInfor[4].split("=")[1];
//            studentClass = listInfor[5].split("=")[1];
//            major = listInfor[6].split("=")[1];
//            chatting = listInfor[7].split("=")[1];
//            score = Double.parseDouble(listInfor[8].split("=")[1]);
//
//firstName = "";
//            lastName = "";
//            gender = "";
//            dateOfBirth = "";
//            studentClass = "";
//            major = "";
//            chatting = "";
//            score = 0.0;

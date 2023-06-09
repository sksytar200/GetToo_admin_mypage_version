package Group2.capstone_project.domain;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class  Client {
    private String id;
    private String name;
    private String age;
    private String studentNumber;
    private String pwd;
    private String department;
    private String joinCheck;

    private String adminCheck;

    private String imagePath;
    private String question;
    private static String answer;

    private String question2;
    private static String answer2;

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getAdminCheck() {
        return adminCheck;
    }

    public void setAdminCheck(String adminCheck) {
        this.adminCheck = adminCheck;
    }

    public String getJoinCheck() {
        return joinCheck;
    }

    public void setJoinCheck(String joinCheck) {
        this.joinCheck = joinCheck;
    }

    private String Leader;

    public String getLeader() {
        return Leader;
    }

    public void setLeader(String leader) {
        Leader = leader;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    private String school;

    private String email;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setQuestion(String question) {this.question = question;}

    public void setAnswer(String answer){ this.answer = answer;}

    public String getQuestion() {return question;}
    public static String getAnswer(){return answer;}

    public void setQuestion2(String question2) {this.question2 = question2;}

    public void setAnswer2(String answer2){ this.answer2 = answer2;}

    public String getQuestion2() {return question2;}
    public static String getAnswer2(){return answer2;}

    public static String getCurrentUserAnswer() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            return authentication.getName();
        }
        return null;
    }



}

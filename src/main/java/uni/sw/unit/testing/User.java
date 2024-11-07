package uni.sw.unit.testing;

//import java.lang.Math;

public class User {
    private int id;
    private String name;
    private String password;
    //private double academicAverage;

    String getUserName() {
        return this.name;
    }

    String getPassword() {
        return this.password;
    }

    int getId() {
        return this.id;
    }

    boolean isLoggedIn() {
        throw new UnsupportedOperationException("not implemented");
    }

    double getAcademicAverage(int semester) {
        throw new UnsupportedOperationException("not implemented");
    }

    boolean update(String newPassword, boolean isLoggedIn){
        throw new UnsupportedOperationException("not implemented");
    }
}
abstract class Person {
    //email should be unique
    String email;
    String password;

    boolean createNewPassword(String newpassword) {
        if(newpassword.equals(this.password)) {
            return false;
        } else {
            this.password = newpassword;
        }
        return true;
    }

    abstract createAccount();
}
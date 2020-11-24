package app.exeptions;

public class AccountPresenceException extends RuntimeException{
    String mail;

    public String getMail() {
        return mail;
    }
    public AccountPresenceException(String msg, String mail){
        super(msg);
        this.mail = mail;
    }
}

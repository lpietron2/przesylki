package pl.edu.wszib.model;

import javax.persistence.*;

@Entity(name = "tpackage")
public class Package {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private User sendFrom;
    private User sendTo;
    private String  date;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String code;


    public Package(int id, User sendFrom, User sendTo, String date, Status status, String code) {
        this.id = id;
        this.sendFrom = sendFrom;
        this.sendTo = sendTo;
        this.date = date;
        this.status = status;
        this.code = code;
    }

    public Package() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getSendFrom() {
        return sendFrom;
    }

    public void setSendFrom(User sendFrom) {
        this.sendFrom = sendFrom;
    }

    public User getSendTo() {
        return sendTo;
    }

    public void setSendTo(User sendTo) {
        this.sendTo = sendTo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public enum Status{
        NADANY,
        W_TRANSPORCIE,
        W_DORECZENIU,
        DORECZONY
    }
}

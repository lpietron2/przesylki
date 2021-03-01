package pl.edu.wszib.przesylki.model;

import pl.edu.wszib.przesylki.model.User;

import javax.persistence.*;

@Entity(name = "tpackage")
public class Package {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //@OneToOne(fetch = FetchType.EAGER)
    private int sendFrom;
    //@OneToOne(fetch = FetchType.EAGER)
    private int sendTo;
    private String  date;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String code;


    public Package(int id, int sendFrom, int sendTo, String date, Status status, String code) {
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

    public int getSendFrom() {
        return sendFrom;
    }

    public void setSendFrom(int sendFrom) {
        this.sendFrom = sendFrom;
    }

    public int getSendTo() {
        return sendTo;
    }

    public void setSendTo(int sendTo) {
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

    @Override
    public String toString() {
        return "Package{" +
                "id=" + id +
                ", sendFrom=" + sendFrom +
                ", sendTo=" + sendTo +
                ", date='" + date + '\'' +
                ", status=" + status +
                ", code='" + code + '\'' +
                '}';
    }
}

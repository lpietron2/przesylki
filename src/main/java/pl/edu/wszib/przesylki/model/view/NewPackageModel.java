package pl.edu.wszib.przesylki.model.view;

public class NewPackageModel {
    private int sendFrom;
    private int sendTo;
    private String  date;
    private Status status;
    private String code;

    public NewPackageModel(int sendFrom, int sendTo, String date, Status status, String code) {
        this.sendFrom = sendFrom;
        this.sendTo = sendTo;
        this.date = date;
        this.status = status;
        this.code = code;
    }

    public NewPackageModel() {
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
}

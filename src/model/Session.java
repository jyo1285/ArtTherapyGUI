package model;

public class Session {

    private int id;
    private int patientId;
    private int therapistId;
    private String sessionDate;
    private String sessionTime;
    private String status;

    public Session() {
    }

    public Session(
            int patientId,
            int therapistId,
            String sessionDate,
            String sessionTime,
            String status
    ) {

        this.patientId = patientId;
        this.therapistId = therapistId;
        this.sessionDate = sessionDate;
        this.sessionTime = sessionTime;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getTherapistId() {
        return therapistId;
    }

    public void setTherapistId(int therapistId) {
        this.therapistId = therapistId;
    }

    public String getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(String sessionDate) {
        this.sessionDate = sessionDate;
    }

    public String getSessionTime() {
        return sessionTime;
    }

    public void setSessionTime(String sessionTime) {
        this.sessionTime = sessionTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
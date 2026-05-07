package model;

public class Patient {

    private int id;
    private String name;
    private int age;
    private String gender;
    private String contact;
    private String diagnosis;

    public Patient() {
    }

    public Patient(
            String name,
            int age,
            String gender,
            String contact,
            String diagnosis
    ) {

        this.name = name;
        this.age = age;
        this.gender = gender;
        this.contact = contact;
        this.diagnosis = diagnosis;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
}
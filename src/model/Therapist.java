package model;

public class Therapist {

    private int id;

    private String name;

    private String specialization;

    private int experience;

    private String contact;

    public Therapist() {
    }

    public Therapist(
            String name,
            String specialization,
            int experience,
            String contact
    ) {

        this.name = name;

        this.specialization =
                specialization;

        this.experience =
                experience;

        this.contact =
                contact;
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

    public void setName(
            String name
    ) {

        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(
            String specialization
    ) {

        this.specialization =
                specialization;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(
            int experience
    ) {

        this.experience =
                experience;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(
            String contact
    ) {

        this.contact = contact;
    }
}
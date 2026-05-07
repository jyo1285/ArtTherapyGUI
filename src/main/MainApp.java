package main;

import dao.PatientDAO;
import dao.SessionDAO;
import dao.TherapistDAO;
import database.DatabaseInitializer;
import model.Patient;
import model.Session;
import model.Therapist;
import service.AuthService;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        DatabaseInitializer.initialize();

        Scanner sc =
                new Scanner(System.in);

        AuthService auth =
                new AuthService();

        System.out.println(
                "===== ART THERAPY MANAGEMENT SYSTEM ====="
        );

        // LOGIN

        System.out.print(
                "\nEnter Username: "
        );

        String username =
                sc.nextLine();

        System.out.print(
                "Enter Password: "
        );

        String password =
                sc.nextLine();

        boolean login =
                auth.login(
                        username,
                        password
                );

        if (!login) {

            System.out.println(
                    "\nInvalid Credentials"
            );

            return;
        }

        System.out.println(
                "\nLogin Successful"
        );

        int choice;

        do {

            System.out.println(
                    "\n===== MAIN MENU ====="
            );

            System.out.println(
                    "1. Add Patient"
            );

            System.out.println(
                    "2. View Patients"
            );

            System.out.println(
                    "3. Add Therapist"
            );

            System.out.println(
                    "4. View Therapists"
            );

            System.out.println(
                    "5. Book Session"
            );

            System.out.println(
                    "6. View Sessions"
            );

            System.out.println(
                    "7. Exit"
            );

            System.out.print(
                    "\nEnter Choice: "
            );

            choice =
                    Integer.parseInt(
                            sc.nextLine()
                    );

            switch (choice) {

                // ADD PATIENT

                case 1:

                    System.out.print(
                            "Patient Name: "
                    );

                    String pname =
                            sc.nextLine();

                    System.out.print(
                            "Age: "
                    );

                    int age =
                            Integer.parseInt(
                                    sc.nextLine()
                            );

                    System.out.print(
                            "Gender: "
                    );

                    String gender =
                            sc.nextLine();

                    System.out.print(
                            "Contact: "
                    );

                    String contact =
                            sc.nextLine();

                    System.out.print(
                            "Diagnosis: "
                    );

                    String diagnosis =
                            sc.nextLine();

                    Patient patient =
                            new Patient(
                                    pname,
                                    age,
                                    gender,
                                    contact,
                                    diagnosis
                            );

                    boolean patientSaved =
                            new PatientDAO()
                                    .addPatient(
                                            patient
                                    );

                    if (patientSaved) {

                        System.out.println(
                                "\nPatient Added Successfully"
                        );
                    }

                    break;

                // VIEW PATIENTS

                case 2:

                    new PatientDAO()
                            .viewPatients();

                    break;

                // ADD THERAPIST

                case 3:

                    System.out.print(
                            "Therapist Name: "
                    );

                    String tname =
                            sc.nextLine();

                    System.out.print(
                            "Specialization: "
                    );

                    String specialization =
                            sc.nextLine();

                    System.out.print(
                            "Experience: "
                    );

                    int experience =
                            Integer.parseInt(
                                    sc.nextLine()
                            );

                    System.out.print(
                            "Contact: "
                    );

                    String tcontact =
                            sc.nextLine();

                    Therapist therapist =
                            new Therapist(
                                    tname,
                                    specialization,
                                    experience,
                                    tcontact
                            );

                    boolean therapistSaved =
                            new TherapistDAO()
                                    .addTherapist(
                                            therapist
                                    );

                    if (therapistSaved) {

                        System.out.println(
                                "\nTherapist Added Successfully"
                        );
                    }

                    break;

                // VIEW THERAPISTS

                case 4:

                    new TherapistDAO()
                            .viewTherapists();

                    break;

                // BOOK SESSION

                case 5:

                    System.out.print(
                            "Patient ID: "
                    );

                    int patientId =
                            Integer.parseInt(
                                    sc.nextLine()
                            );

                    System.out.print(
                            "Therapist ID: "
                    );

                    int therapistId =
                            Integer.parseInt(
                                    sc.nextLine()
                            );

                    System.out.print(
                            "Session Date: "
                    );

                    String date =
                            sc.nextLine();

                    System.out.print(
                            "Session Time: "
                    );

                    String time =
                            sc.nextLine();

                    System.out.print(
                            "Status: "
                    );

                    String status =
                            sc.nextLine();

                    Session session =
                            new Session(
                                    patientId,
                                    therapistId,
                                    date,
                                    time,
                                    status
                            );

                    boolean sessionSaved =
                            new SessionDAO()
                                    .addSession(
                                            session
                                    );

                    if (sessionSaved) {

                        System.out.println(
                                "\nSession Booked Successfully"
                        );
                    }

                    break;

                // VIEW SESSIONS

                case 6:

                    new SessionDAO()
                            .viewSessions();

                    break;

                case 7:

                    System.out.println(
                            "\nThank You"
                    );

                    break;

                default:

                    System.out.println(
                            "\nInvalid Choice"
                    );
            }

        } while (choice != 7);
    }
}
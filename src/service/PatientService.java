package service;

import dao.PatientDAO;
import model.Patient;

public class PatientService {

    PatientDAO dao =
            new PatientDAO();

    public boolean addPatient(
            Patient patient
    ) {

        return dao.addPatient(patient);
    }
}
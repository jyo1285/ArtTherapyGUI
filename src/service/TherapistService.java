package service;

import dao.TherapistDAO;
import model.Therapist;

public class TherapistService {

    TherapistDAO dao =
            new TherapistDAO();

    public boolean addTherapist(
            Therapist therapist
    ) {

        return dao.addTherapist(
                therapist
        );
    }

    public void viewTherapists() {

        dao.viewTherapists();
    }
}
package service;

import dao.SessionDAO;
import model.Session;

public class SessionService {

    SessionDAO dao =
            new SessionDAO();

    public boolean addSession(
            Session session
    ) {

        return dao.addSession(
                session
        );
    }

    public void viewSessions() {

        dao.viewSessions();
    }
}
package ru.progwards.java1.lessons.datetime;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

public class SessionManager {
    private int sessionValid;
    private Map<Integer, UserSession> sessionMap;

    public SessionManager(int sessionValid) {
        this.sessionValid = sessionValid;
        sessionMap = new HashMap<>();
    }

    public void add(UserSession userSession) {
        sessionMap.put(userSession.getSessionHandle(), userSession);
    }

    public UserSession find(String userName) {
        for (UserSession s : sessionMap.values()) {
            if (s.getUserName().equals(userName)) {
                return get(s.getSessionHandle());
            }
        }
        return null;
    }

    public UserSession get(int sessionHandle) {
        UserSession session = sessionMap.get(sessionHandle);
        if (session == null || Duration.between(session.getLastAccess(), LocalDateTime.now()).toSeconds() > sessionValid) {
            return null;
        }
        session.updateLastAccess();
        return session;
    }

    public void delete(int sessionHandle) {
        sessionMap.remove(sessionHandle);
    }

    public void deleteExpired() {
        LocalDateTime now = LocalDateTime.now();
        Collection<UserSession> currentSessions = new ArrayList<>(sessionMap.values());
        for (UserSession s : currentSessions) {
            if (Duration.between(s.getLastAccess(), now).toSeconds() >= sessionValid) {
                sessionMap.remove(s.getSessionHandle());
            }
        }
    }
}

class UserSession {
    private int sessionHandle;
    private String userName;
    private LocalDateTime lastAccess;//<дата-время>

    private static Random random = new Random();

    public int getSessionHandle() {
        return sessionHandle;
    }

    public String getUserName() {
        return userName;
    }

    public LocalDateTime getLastAccess() {
        return lastAccess;
    }

    public void updateLastAccess() {
        lastAccess = LocalDateTime.now();
    }

    public UserSession(String userName) {
        this.userName = userName;
        sessionHandle = random.nextInt();
        lastAccess = LocalDateTime.now();
    }
}
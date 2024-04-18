package ru.progwards.java1.lessons.datetime;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

public class SessionManager {
    private Map<Integer, UserSession> sessions; // Хранение сессий по userName
    private int sessionValid; // Время валидности сессии в секундах

    public SessionManager(int sessionValid) {
        this.sessions = new HashMap<>();
        this.sessionValid = sessionValid;
    }

    public void add(UserSession userSession) {
        sessions.put(userSession.getSessionHandle(), userSession);
    }
    public UserSession find(String userName) {
        for (UserSession session : sessions.values()) {
            if (session.getUserName().equals(userName)) {
                session.updateLastAccess();
                return session;
            }
        }
        return null;
    }

    public UserSession get(int sessionHandle) {
        for (UserSession session : sessions.values()) {
            if (session.getSessionHandle() == sessionHandle) {
                session.updateLastAccess(); // Обновить время доступа
                return session;
            }
        }
        return null;
    }

    public void delete(int sessionHandle) {
        sessions.remove(sessionHandle);
    }

    public void deleteExpired() {
        LocalDateTime now = LocalDateTime.now();
        Collection<UserSession> currentSessions = new ArrayList<>(sessions.values());
        for (UserSession s : currentSessions) {
            if (Duration.between(s.getLastAccess(), now).toSeconds() >= sessionValid) {
                sessions.remove(s.getSessionHandle());
            }
        }
    }
}

class UserSession {
    private int sessionHandle;
    private String userName;
    private LocalDateTime lastAccess;

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
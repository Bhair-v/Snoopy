package model;

import java.time.LocalDateTime;

public abstract class UserActivity {
    protected LocalDateTime timestamp;

    public UserActivity() {
        this.timestamp = LocalDateTime.now();
    }

    public abstract String getSummary();
}
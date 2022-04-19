package entity;

import java.time.LocalDateTime;

public class ClientEntity extends PersonEntity{
private LocalDateTime timestamp;

    public ClientEntity(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}

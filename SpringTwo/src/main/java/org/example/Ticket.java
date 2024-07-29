package org.example;
import java.time.LocalDateTime;
public class Ticket {
    private String number;
    private LocalDateTime createdAt;

    public Ticket(String number, LocalDateTime createdAt) {
        this.number = number;
        this.createdAt = createdAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getNumber() {
        return number;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}

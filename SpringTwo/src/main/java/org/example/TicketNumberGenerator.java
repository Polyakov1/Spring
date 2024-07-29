package org.example;
import java.util.UUID;
class TicketNumberGenerator {

    public String createNewNumber() {
        return "Ticket #" + UUID.randomUUID().toString();
    }
}

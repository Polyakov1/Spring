package org.example;
import java.time.LocalDateTime;


class Tablo {
    private final TicketNumberGenerator ticketNumberGenerator;

    public Tablo(TicketNumberGenerator ticketNumberGenerator) {
        this.ticketNumberGenerator = ticketNumberGenerator;
    }

    public Ticket newTicket() {
        String number = ticketNumberGenerator.createNewNumber();
        LocalDateTime createdAt = LocalDateTime.now();
        return new Ticket(number, createdAt);
    }
}
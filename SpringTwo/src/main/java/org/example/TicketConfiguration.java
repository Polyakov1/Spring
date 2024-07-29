package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
class TicketConfiguration {

    @Bean
    public TicketNumberGenerator ticketNumberGenerator() {
        return new TicketNumberGenerator();
    }

    @Bean
    public Tablo tablo(TicketNumberGenerator ticketNumberGenerator) {
        return new Tablo(ticketNumberGenerator);
    }
}
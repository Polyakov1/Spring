package org.example;

public class Main {
    public static void main(String[] args) {
        // Создаем экземпляр TicketConfiguration (в реальности это делает Spring)
        TicketConfiguration configuration = new TicketConfiguration();

        // Получаем bean Tablo
        Tablo tablo = configuration.tablo(configuration.ticketNumberGenerator());

        // Создаем новый билет
        Ticket ticket = tablo.newTicket();

        // Выводим информацию о билете
        System.out.println(ticket);

    }
}
package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketRepositoryTest {
    TicketRepository repository = new TicketRepository();
    Ticket ticketZero = new Ticket();
    Ticket ticketUfaMoscow = new Ticket(1, 3400, "UFA", "DME", 110);
    Ticket ticketUfaKrasnoyarsk = new Ticket(2, 6350, "UFA", "KJA", 250);
    Ticket ticketUfaNovosibirsk = new Ticket(3, 5400, "UFA", "OVB", 170);
    Ticket ticketMoscowYekaterinburg = new Ticket(4, 4200, "DME", "SVX", 160);
    Ticket ticketMoscowSpb = new Ticket(5, 1800, "DME", "LED", 60);
    Ticket ticketUfaMsc = new Ticket(6, 5200, "UFA", "DME", 90);
    Ticket ticketSpbSochi = new Ticket(7, 2300, "LED", "AER", 120);
    Ticket ticketMoscowSochi = new Ticket(8, 3200, "DME", "AER", 140);

    @BeforeEach
    void setUp() {
        repository.save(ticketUfaMoscow);
        repository.save(ticketUfaKrasnoyarsk);
        repository.save(ticketUfaNovosibirsk);
        repository.save(ticketMoscowYekaterinburg);
        repository.save(ticketMoscowSpb);
        repository.save(ticketUfaMsc);
        repository.save(ticketSpbSochi);
        repository.save(ticketMoscowSochi);
    }

    @Test
    void shouldSave() {
        Ticket[] actual = repository.findAll();
        Ticket[] expected = new Ticket[]{ticketUfaMoscow, ticketUfaKrasnoyarsk, ticketUfaNovosibirsk,
                ticketMoscowYekaterinburg, ticketMoscowSpb, ticketUfaMsc, ticketSpbSochi, ticketMoscowSochi};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveById() {
        repository.removeById(4);
        Ticket[] actual = repository.findAll();
        Ticket[] expected = new Ticket[]{ticketUfaMoscow, ticketUfaKrasnoyarsk, ticketUfaNovosibirsk,
                ticketMoscowSpb, ticketUfaMsc, ticketSpbSochi, ticketMoscowSochi};
        assertArrayEquals(expected, actual);
    }
}
package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);
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
        manager.add(ticketUfaMoscow);
        manager.add(ticketUfaKrasnoyarsk);
        manager.add(ticketUfaNovosibirsk);
        manager.add(ticketMoscowYekaterinburg);
        manager.add(ticketMoscowSpb);
        manager.add(ticketUfaMsc);
        manager.add(ticketSpbSochi);
        manager.add(ticketMoscowSochi);
    }

    @Test
    void shouldAdd() {
        Ticket[] actual = manager.findAllTicket();
        Ticket[] expected = new Ticket[]{ticketUfaMoscow, ticketUfaKrasnoyarsk, ticketUfaNovosibirsk,
                ticketMoscowYekaterinburg, ticketMoscowSpb, ticketUfaMsc, ticketSpbSochi, ticketMoscowSochi};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindUfaMsc() {
        Ticket[] actual = manager.findAll("UFA", "DME");
        Ticket[] expected = new Ticket[]{ticketUfaMoscow, ticketUfaMsc};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveById() {
        manager.removeById(4);
        Ticket[] actual = manager.findAllTicket();
        Ticket[] expected = new Ticket[]{ticketUfaMoscow, ticketUfaKrasnoyarsk, ticketUfaNovosibirsk,
                ticketMoscowSpb, ticketUfaMsc, ticketSpbSochi, ticketMoscowSochi};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchSpb() {
        Ticket[] actual = manager.searchBy("LED");
        Ticket[] expected = new Ticket[]{ticketMoscowSpb, ticketSpbSochi};
        assertArrayEquals(expected, actual);
    }
}
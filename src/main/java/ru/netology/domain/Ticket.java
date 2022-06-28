package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Ticket implements Comparable<Ticket> {
    private int id;
    private int amount;
    private String departureAirport;
    private String arrivalAirport;
    private int timeMinute;

    public int getId() {
        return id;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public int compareTo(Ticket o) {
        return amount - o.amount;
    }
}

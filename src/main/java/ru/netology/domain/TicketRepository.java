package ru.netology.domain;

public class TicketRepository {
    private Ticket[] items = new Ticket[0];

    public void save(Ticket ticket) {
        int length = items.length + 1;
        Ticket[] tmp = new Ticket[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = ticket;
        items = tmp;
    }

    public Ticket[] findAll() {
        return items;
    }

    public void removeById(int id) {
        int length = items.length - 1;
        Ticket[] tmp = new Ticket[length];
        int index = 0;
        for (Ticket item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }

}

package ex01;

import ex01.ticketApp001.*;

import java.util.ArrayList;
import java.util.List;

public class App001 {

    public static void main(String[] args) {

        // 티켓을 발행한다.
        List<Ticket> tickets = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            tickets.add(new Ticket(5000L));
        }

        // 티켓을 오피스에 비치한다.
        TicketOffice ticketOffice = new TicketOffice(0L, tickets);

        // 티켓 판매자를 고용한다.
        TicketSeller tickerSeller = new TicketSeller(ticketOffice);

        // 극장에 티켓 판매자를 배치한다.
        Theater theater = new Theater(tickerSeller);

        // 관람객 방문
        theater.enter(new Audience(new Bag(10000L)));
        theater.enter(new Audience(new Bag(5000L)));
        theater.enter(new Audience(new Bag(1000L)));
        theater.enter(new Audience(new Bag(0L, new Invitation())));

        System.out.println(String.format("수익 : %s", ticketOffice.getAmount()));

    }
}












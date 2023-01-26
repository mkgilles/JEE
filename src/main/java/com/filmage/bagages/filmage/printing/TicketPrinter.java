package com.filmage.bagages.filmage.printing;

import com.filmage.bagages.filmage.entities.BaggageWrappingMachine;
import com.filmage.bagages.filmage.payment.PaymentContext;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Entity
public class TicketPrinter {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void printTicket(BaggageWrappingMachine machine, PaymentContext payment) {
        System.out.println("==================================");
        System.out.println(" BAGGAGE WRAPPING TICKET ");
        System.out.println("==================================");
        System.out.println("Machine Manufacturer: " + machine.getManufacturer());
        System.out.println("Machine Position: " + machine.getPosition());
        System.out.println("Payment Amount: " + payment.getAmount());
        System.out.println("Date and Time: " + LocalDateTime.now());
        System.out.println("==================================");
    }
}

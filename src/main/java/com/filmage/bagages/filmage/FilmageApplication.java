package com.filmage.bagages.filmage;

import com.filmage.bagages.filmage.entities.Available;
import com.filmage.bagages.filmage.entities.BaggageWrappingMachine;
import com.filmage.bagages.filmage.entities.Unavailable;
import com.filmage.bagages.filmage.payment.PaymentContext;
import com.filmage.bagages.filmage.printing.TicketPrinter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class FilmageApplication {

    public static void main(String[] args) {
        SpringApplication.run(FilmageApplication.class, args);
        //BaggageWrappingMachine machine = new BaggageWrappingMachine();
        BaggageWrappingMachine machine = new BaggageWrappingMachine("ABC Co.", 1);
        machine.setState(new Available());
        machine.getState().available();
        // **********************TEST************************
        // Create a new instance of the machine


// Create a new instance of the payment context with the machine and amount
        PaymentContext payment = new PaymentContext(machine, new BigDecimal(5));

// Process the payment and change the state of the machine
        payment.processPayment();

// Create a new instance of the ticket printer and print the ticket
        TicketPrinter printer = new TicketPrinter();
        printer.printTicket(machine, payment);

// Use the wrap baggage method to start wrapping the baggage
        machine.wrapbaggage();

        //and also for making the machine unavailable :

// Create a new instance of the machine
        //BaggageWrappingMachine machine = new BaggageWrappingMachine("ABC Co.", 1);

// Make the machine unavailable
        machine.setState(new Unavailable());

// Check if the machine is available
        if (!machine.getState().isAvailable()) {
            System.out.println("Machine is not available for use.");
        } else {
            System.out.println("Machine is available for use.");
        }

    }

}

package com.filmage.bagages.filmage.payment;

import com.filmage.bagages.filmage.entities.BaggageWrappingMachine;
import com.filmage.bagages.filmage.entities.Inuse;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class PaymentContext {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_payment", nullable = false)
    private Long id_payment;

    @ManyToOne
    @JoinColumn(name = "machine_id")
    private BaggageWrappingMachine machine;
    private BigDecimal amount;

    public Long getId_payment() {
        return id_payment;
    }

    public void setId_payment(Long id_payment) {
        this.id_payment = id_payment;
    }

    public BaggageWrappingMachine getMachine() {
        return machine;
    }

    public void setMachine(BaggageWrappingMachine machine) {
        this.machine = machine;
    }

    public PaymentContext() {

    }

    public BigDecimal getAmount() {
        return amount;
    }

    public PaymentContext(BaggageWrappingMachine machine, BigDecimal amount) {
        this.machine = machine;
        this.amount = amount;
    }

    public void processPayment() {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0.");
        }
        if (!machine.getState().isAvailable()) {
            throw new IllegalStateException("Machine is not available for use.");
        }
        machine.setState(new Inuse());
    }


}

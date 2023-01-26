package com.filmage.bagages.filmage.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class BaggageWrappingMachine implements Serializable {
    /***
     * Hauteur:
     * 1150 millimètres
     * Longueur:
     * 1550 millimètres
     * Largeur:
     * 600 millimètres
     * Hauteur avec palette :
     * 1200 millimètres
     * Longueur avec palette :
     * 1650 millimètres
     * Largeur avec palette :
     * 650 millimètres
     * Hauteur du boîtier :
     * 1250 millimètres
     * Longueur du boîtier :
     * 1700 millimètres
     * Largeur du boîtier :
     * 700 millimètres
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private MachineState state;
    @Column
    private String manufacturer;
    @Column
    private int position;
    @Column
    private int height;
    @Column
    private int length;
    @Column
    private int width;
    @Column
    private int caseHeight;
    @Column
    private int caseLength;
    @Column
    private int caseWidth;


    public BaggageWrappingMachine(String manufacturer, int position) {
        this.manufacturer = manufacturer;
        this.position = position;
        this.state = new Available();
    }

    public BaggageWrappingMachine(String manufacturer, int position, int height, int length, int width, int caseHeight, int caseLength, int caseWidth) {
        this.manufacturer = manufacturer;
        this.position = position;
        this.height = height;
        this.length = length;
        this.width = width;
        this.caseHeight = caseHeight;
        this.caseLength = caseLength;
        this.caseWidth = caseWidth;
        this.state = new Available();
    }

    public BaggageWrappingMachine() {
        this.state = new Available();
    }

    /***
     * Methode pour changer l'etat de disponibilité d'un machine
     */
    public void makeUnalaible(){
        this.state = new Unavailable();
    }
    /**
     * La methode necessaire pour savoir si la machine est en cours d'utilisation ou pas
     */

    public void wrapbaggage(){
        this.state.inuse();
    }

    // **********************Getters and setters*************************
    public Long getId() {
        return id;
    }

    public MachineState getState() {
        return state;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getPosition() {
        return position;
    }

    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getCaseHeight() {
        return caseHeight;
    }

    public int getCaseLength() {
        return caseLength;
    }

    public int getCaseWidth() {
        return caseWidth;
    }

    public void setState(MachineState state) {
        this.state = state;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setCaseHeight(int caseHeight) {
        this.caseHeight = caseHeight;
    }

    public void setCaseLength(int caseLength) {
        this.caseLength = caseLength;
    }

    public void setCaseWidth(int caseWidth) {
        this.caseWidth = caseWidth;
    }


    public void setId(Long id) {
    }
}

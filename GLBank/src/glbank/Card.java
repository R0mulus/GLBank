/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glbank;

/**
 *
 * @author Joseph
 */
public class Card {
    private long idacc;
    private int idCard;
    private long cardNumber;
    private int pin;
    private boolean blocked;

    public Card(long idacc, int idCard, long cardNumber, int pin, boolean blocked) {
        this.idacc = idacc;
        this.idCard = idCard;
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.blocked = blocked;
    }

    public Card(long idacc, int idCard, long cardNumber, int pin) {
        this.idacc = idacc;
        this.idCard = idCard;
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.blocked = false;
    }

    public long getIdacc() {
        return idacc;
    }

    public int getIdCard() {
        return idCard;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public int getPin() {
        return pin;
    }

    public boolean isBlocked() {
        return blocked;
    }
    
    
}

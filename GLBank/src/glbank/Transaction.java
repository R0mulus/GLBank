/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glbank;

import java.util.Date;

/**
 *
 * @author Joseph
 */
public class Transaction {
    private int idbt;
    private float amount;
    private Date transDateTime;
    private String description;
    private int idemp;
    private long sourceAcc;
    private long destAcc;
    private int srcBank;
    private int destBank;

    public Transaction(int idbt, float amount, Date transDateTime, String description, int idemp, long sourceAcc, long destAcc, int srcBank, int destBank) {
        this.idbt = idbt;
        this.amount = amount;
        this.transDateTime = transDateTime;
        this.description = description;
        this.idemp = idemp;
        this.sourceAcc = sourceAcc;
        this.destAcc = destAcc;
        this.srcBank = srcBank;
        this.destBank = destBank;
    }

    public Transaction() {
    }

    public Transaction(int idbt, float amount, Date transDateTime, int idemp, long sourceAcc, long destAcc, int srcBank, int destBank) {
        this.idbt = idbt;
        this.amount = amount;
        this.transDateTime = transDateTime;
        this.idemp = idemp;
        this.sourceAcc = sourceAcc;
        this.destAcc = destAcc;
        this.srcBank = srcBank;
        this.destBank = destBank;
    }
    
    

    public int getIdbt() {
        return idbt;
    }

    public void setIdbt(int idbt) {
        this.idbt = idbt;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Date getTransDateTime() {
        return transDateTime;
    }

    public void setTransDateTime(Date transDateTime) {
        this.transDateTime = transDateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdemp() {
        return idemp;
    }

    public void setIdemp(int idemp) {
        this.idemp = idemp;
    }

    public long getSourceAcc() {
        return sourceAcc;
    }

    public void setSourceAcc(long sourceAcc) {
        this.sourceAcc = sourceAcc;
    }

    public long getDestAcc() {
        return destAcc;
    }

    public void setDestAcc(long destAcc) {
        this.destAcc = destAcc;
    }

    public int getSrcBank() {
        return srcBank;
    }

    public void setSrcBank(int srcBank) {
        this.srcBank = srcBank;
    }

    public int getDestBank() {
        return destBank;
    }

    public void setDestBank(int destBank) {
        this.destBank = destBank;
    }
    
    
}

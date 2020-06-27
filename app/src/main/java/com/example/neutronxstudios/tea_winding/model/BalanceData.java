package com.example.neutronxstudios.tea_winding.model;

public class BalanceData {
    private int machine;
    private int current_balance;

    public BalanceData(int machine, int current_balance) {
        this.machine = machine;
        this.current_balance = current_balance;
    }

    public int getMachine() {
        return machine;
    }

    public void setMachine(int machine) {
        this.machine = machine;
    }

    public int getCurrent_balance() {
        return current_balance;
    }

    public void setCurrent_balance(int current_balance) {
        this.current_balance = current_balance;
    }
}

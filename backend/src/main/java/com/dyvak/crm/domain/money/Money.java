package com.dyvak.crm.domain.money;

import java.math.BigDecimal;

public class Money {

    private long amount;
    private Currency currency;

    public Money(double amount, Currency currency) {
        this.currency = currency;
        this.amount = Math.round(amount * centFactor());
    }

    public Money(long amount, Currency currency) {
        this.currency = currency;
        this.amount = amount * centFactor();
    }

    private static final int[] cents = new int[]{1, 10, 100, 1000};

    private int centFactor() {
        return cents[currency.getDefaultFractionDigits()];
    }

    public BigDecimal amount() {
        return BigDecimal.valueOf(amount, currency.getDefaultFractionDigits());
    }

    public Currency currency() {
        return currency;
    }

    public static Money dollars(double amount) {
        return new Money(amount, Currency.USD);
    }

    public boolean equals(Object other) {
        return (other instanceof Money) && equals((Money) other);
    }

    public boolean equals(Money other) {
        return currency.equals(other.currency) && (amount == other.amount);
    }

    public int hashCode() {
        return (int) (amount ^ (amount >>> 32));
    }

    public Money add(Money other) {
        if (this.currency.equals(other.currency)) {
            return newMoney(amount + other.amount);
        } else {
            throw new RuntimeException("money math mismatch");
        }
    }

    private Money newMoney(long amount) {
        return new Money(amount, this.currency);
    }
}

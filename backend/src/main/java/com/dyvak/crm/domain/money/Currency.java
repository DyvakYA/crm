package com.dyvak.crm.domain.money;

import com.dyvak.crm.service.notification.MessengerType;

public enum Currency {

    UAH (2),
    USD (2),
    EUR (2);

    private int defaultFractionDigit;

    Currency(int defaultFractionDigit){
        this.defaultFractionDigit = defaultFractionDigit;
    }

    public int getDefaultFractionDigits() {
        return defaultFractionDigit;
    }
}

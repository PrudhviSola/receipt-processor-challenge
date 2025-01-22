package com.fetch.receipt.processor.challenge.rule;

import com.fetch.receipt.processor.challenge.dto.ReceiptDTO;
import org.springframework.stereotype.Component;

@Component
public class RetailerNameRule implements PointRule{
    private static final String NON_ALPHANUMERIC_PATTERN = "[^A-Za-z0-9]";

    /**
     * @param receipt The receipt for which the reward points are to be calculated
     * @return The calculated reward points based on the receipt name.
     */
    @Override
    public int calculatePoints(ReceiptDTO receipt) {
        return receipt.getRetailer().replaceAll(NON_ALPHANUMERIC_PATTERN, "").length();
    }
}
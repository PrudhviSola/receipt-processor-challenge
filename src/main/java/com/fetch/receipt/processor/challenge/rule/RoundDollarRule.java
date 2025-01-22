package com.fetch.receipt.processor.challenge.rule;

import com.fetch.receipt.processor.challenge.dto.ReceiptDTO;
import org.springframework.stereotype.Component;

@Component
public class RoundDollarRule implements PointRule{
    private static final int POINTS_FOR_ROUND_DOLLAR = 50;
    private static final int ZERO_POINTS = 0;

    /**
     * @param receipt The receipt for which the reward points are to be calculated
     * @return The calculated reward points based on the total .
     */
    @Override
    public int calculatePoints(ReceiptDTO receipt) {
        double totalAmount = Double.parseDouble(receipt.getTotal());
        return totalAmount % 1.0 == 0 ? POINTS_FOR_ROUND_DOLLAR : ZERO_POINTS;
    }
}
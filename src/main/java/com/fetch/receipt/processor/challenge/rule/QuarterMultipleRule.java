package com.fetch.receipt.processor.challenge.rule;

import com.fetch.receipt.processor.challenge.dto.ReceiptDTO;
import org.springframework.stereotype.Component;

@Component
public class QuarterMultipleRule implements PointRule {

    private static final double QUARTER = 0.25;
    private static final int POINTS_FOR_QUARTER_MULTIPLE = 25;
    private static final int NO_POINTS = 0;

    /**
     * @param receipt The receipt for which the reward points are to be calculated
     * @return The calculated reward points based on the receipt points.
     */
    @Override
    public int calculatePoints(ReceiptDTO receipt) {
        if (receipt == null || receipt.getTotal() == null) {
            return NO_POINTS;
        }

        try {
            double totalAmount = Double.parseDouble(receipt.getTotal());
            return isMultipleOfQuarter(totalAmount) ? POINTS_FOR_QUARTER_MULTIPLE : NO_POINTS;
        } catch (NumberFormatException e) {
            return NO_POINTS;
        }
    }

    private boolean isMultipleOfQuarter(double amount) {
        return amount % QUARTER == 0;
    }
}

package com.fetch.receipt.processor.challenge.rule;

import com.fetch.receipt.processor.challenge.dto.ReceiptDTO;
import org.springframework.stereotype.Component;

@Component
public class OddDayRule implements PointRule {

    private static final int POINTS_FOR_ODD_DAY = 6;
    private static final int NO_POINTS = 0;
    private static final int DIVISOR = 2;
    private static final int ODD_REMAINDER = 1;

    /**
     * @param receipt The receipt for which the reward points are to be calculated
     * @return The calculated reward points based on the receipt purchase date.
     */
    @Override
    public int calculatePoints(ReceiptDTO receipt) {
        if (receipt == null || receipt.getPurchaseDate() == null) {
            return NO_POINTS;
        }

        return isOddDay(receipt.getPurchaseDate().getDayOfMonth())
                ? POINTS_FOR_ODD_DAY
                : NO_POINTS;
    }

    private boolean isOddDay(int day) {
        return day % DIVISOR == ODD_REMAINDER;
    }
}

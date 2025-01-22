package com.fetch.receipt.processor.challenge.rule;

import com.fetch.receipt.processor.challenge.dto.ReceiptDTO;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class TimeRangeRule implements PointRule {

    private static final int POINTS_AWARDED = 10;
    private static final int ZERO_POINTS = 0;
    private static final LocalTime START_TIME = LocalTime.of(14, 0);
    private static final LocalTime END_TIME = LocalTime.of(16, 0);

    /**
     * @param receipt The receipt for which the reward points are to be calculated
     * @return The calculated reward points based on the purchased time.
     */
    @Override
    public int calculatePoints(ReceiptDTO receipt) {
        if (receipt == null || receipt.getPurchaseTime() == null) {
            return ZERO_POINTS;
        }

        LocalTime purchaseTime = receipt.getPurchaseTime();
        return isWithinTimeRange(purchaseTime) ? POINTS_AWARDED : ZERO_POINTS;
    }

    private boolean isWithinTimeRange(LocalTime time) {
        return time.isAfter(START_TIME) && time.isBefore(END_TIME);
    }
}
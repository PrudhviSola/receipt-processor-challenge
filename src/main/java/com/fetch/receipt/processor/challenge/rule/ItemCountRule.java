package com.fetch.receipt.processor.challenge.rule;

import com.fetch.receipt.processor.challenge.dto.ReceiptDTO;
import org.springframework.stereotype.Component;

@Component
public class ItemCountRule implements PointRule {

    private static final int POINTS_PER_PAIR = 5;
    private static final int ITEMS_PER_GROUP = 2;

    /**
     * @param receipt The receipt to be processed, which contains a list of items.
     * @return The total points awarded for the receipt based on the number of items
     */
    @Override
    public int calculatePoints(ReceiptDTO receipt) {
        if (receipt == null || receipt.getItems() == null) {
            return 0;
        }

        int itemCount = receipt.getItems().size();
        return (itemCount / ITEMS_PER_GROUP) * POINTS_PER_PAIR;
    }
}

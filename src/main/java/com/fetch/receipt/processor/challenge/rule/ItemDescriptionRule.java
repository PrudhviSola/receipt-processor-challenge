package com.fetch.receipt.processor.challenge.rule;

import com.fetch.receipt.processor.challenge.dto.ItemDTO;
import com.fetch.receipt.processor.challenge.dto.ReceiptDTO;
import org.springframework.stereotype.Component;

@Component
public class ItemDescriptionRule implements PointRule{
    private static final double PRICE_MULTIPLIER = 0.2;
    private static final int DESCRIPTION_LENGTH_DIVISOR = 3;

    /**
     * @param receipt The receipt items for which the reward points are to be calculated
     * @return The calculated reward points based on the item's description length.
     */
    @Override
    public int calculatePoints(ReceiptDTO receipt) {
        if (receipt == null || receipt.getItems() == null) {
            return 0;
        }

        return receipt.getItems().stream()
                .filter(item -> item != null && item.getShortDescription() != null)
                .mapToInt(this::calculatePointsForItem)
                .sum();
    }

    private int calculatePointsForItem(ItemDTO item) {
        try{
            String description = item.getShortDescription().trim();
            double price = Double.parseDouble(item.getPrice());
            return (description.length() % DESCRIPTION_LENGTH_DIVISOR == 0) ? (int) Math.ceil(price * PRICE_MULTIPLIER) : 0;
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
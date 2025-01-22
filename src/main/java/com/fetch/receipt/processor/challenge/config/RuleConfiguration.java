package com.fetch.receipt.processor.challenge.config;

import com.fetch.receipt.processor.challenge.rule.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class RuleConfiguration {

    @Bean
    public List<PointRule> pointRules(
            RetailerNameRule retailerNameRule,
            RoundDollarRule roundDollarRule,
            QuarterMultipleRule quarterMultipleRule,
            ItemCountRule itemCountRule,
            ItemDescriptionRule itemDescriptionRule,
            OddDayRule oddDayRule,
            TimeRangeRule timeRangeRule
    ) {
        return List.of(
                retailerNameRule,
                roundDollarRule,
                quarterMultipleRule,
                itemCountRule,
                itemDescriptionRule,
                oddDayRule,
                timeRangeRule
        );
    }
}

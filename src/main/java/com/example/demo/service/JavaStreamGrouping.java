package com.example.demo.service;

import com.example.demo.domain.TradePf;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@Component
public class JavaStreamGrouping {
    public  void groupByTradeId() {

        //3 apple, 2 banana, others 1
        List<TradePf> items = Arrays.asList(
                new TradePf(101,10),
                new TradePf(101,11),
                new TradePf(101,12),

                new TradePf(201,30),
                new TradePf(201,31),
                new TradePf(201,32),

                new TradePf(301,40),
                new TradePf(301,41),
                new TradePf(301,42)
        );

        Map<Integer, Long> counting = items.stream().collect(
                groupingBy(TradePf::getTradeId, Collectors.counting()));

        //System.out.println(counting);

        Map<Integer, List<Integer>> newMap = items.stream().collect(groupingBy(TradePf::getTradeId
        ,mapping(TradePf::getPfId, toList())));
        System.out.println(newMap);


        /**
        Map<String, Integer> sum = items.stream().collect(
                Collectors.groupingBy(Item::getName, Collectors.summingInt(Item::getQty)));

        System.out.println(sum);
         */

    }




}

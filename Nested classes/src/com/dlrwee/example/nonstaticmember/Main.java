package com.dlrwee.example.nonstaticmember;

import java.util.ArrayList;
import java.util.List;

import static com.dlrwee.example.nonstaticmember.Order.Item;

class Main
{
    static void main(String[] args)
    {
        Item item = Item.newInstance("Chair", 25);

        List<Order.Item> items = new ArrayList<>();
        items.add(item);
        items.add(Order.Item.newInstance("Block", 67));
        items.add(Order.Item.newInstance("Backpack", 100));

        Order order = Order.newInstance(items);
        order.addItem(Item.newInstance("Dexter", 999));
        
        Order.Discount discount = order.new Discount();

        System.out.println("---Order---\n" + order);
        System.out.println("\nTotal:" + String.format("%9d", order.totalAmount()));
        System.out.println("Discount: " + String.format("%7.2f", discount.calculate()));
    }
}
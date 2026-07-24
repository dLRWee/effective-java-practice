package com.dlrwee.example.staticmember;

import java.util.ArrayList;
import java.util.List;

class Main 
{
    static void main(String[] args)
    {
        List<Item> items = new ArrayList<>();
        items.add(Item.newInstance("Hammer", 25));
        items.add(Item.newInstance("Ballon", 29));
        items.add(Item.newInstance("Chair", 67));
        
        DeliveryOrder deliveryOrder = DeliveryOrder.newInstance("Miami", items);

        items.remove(0);

        System.out.println(deliveryOrder);
    }    
}
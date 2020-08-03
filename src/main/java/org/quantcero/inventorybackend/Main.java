package org.quantcero.inventorybackend;

import org.quantcero.inventorybackend.json.Converter;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello Lukas");
        System.out.println(Converter.getConverter().parseRawCommand("{'action': 'helloworld', 'objects': {'a': 1, 'b': 42} }"));
    }

}

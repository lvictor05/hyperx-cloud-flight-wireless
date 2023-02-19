package org.luizvictortinini;

import org.luizvictortinini.services.HidService;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        HidService hidService = new HidService();
        hidService.run();

    }
}

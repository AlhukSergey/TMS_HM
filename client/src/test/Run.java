package test;

import tmspaymentsystem.MerchantService;

public class Run {
    public static void main(String[] args) {
        AppMenu.start(new MerchantService());
    }
}
package com.devdowns.restaurant.enums;

import java.util.Random;

public enum MenuItems {
    CHEESEBURGER,
    CRAB_RANGOON,
    STEAK,
    CHICKEN_FRIED_STEAK,
    PANCAKES,
    WAFFLES,
    MEAT_LOAF,
    RIBS,
    SWEET_AND_SOUR_CHICKEN,
    FRIED_PICKLES;

    public static MenuItems getRandomItem() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}

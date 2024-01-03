package ru.geekbrains.junior.lesson1.task2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Корзина
 *
 * @param <T> Еда
 */
public class Cart<T extends Food> {

    //region Поля

    /**
     * Товары в магазине
     */
    private final ArrayList<T> foodstuffs;
    private final UMarket market;
    private final Class<T> clazz;

    //endregion

    //region Конструкторы

    /**
     * Создание нового экземпляра корзины
     *
     * @param market принадлежность к магазину
     */
    public Cart(Class<T> clazz, UMarket market) {
        this.clazz = clazz;
        this.market = market;
        foodstuffs = new ArrayList<>();
    }

    public void cardBalancing() {
        AtomicBoolean proteins = new AtomicBoolean(false);
        AtomicBoolean fats = new AtomicBoolean(false);
        AtomicBoolean carbohydrates = new AtomicBoolean(false);
        int[] index = {1};

        foodstuffs.stream()
                .filter(clazz::isInstance)
                .forEach(food -> {
                    Food.class.isAssignableFrom(food.getClass());

// почему то в таком  виде выдает ошибку  , но если развернуть  то все рабтает??
//                        food.getProteins() && !proteins.get() ? proteins.set(true) : food.getFats() ? fats.set(true) : food.getCarbohydrates() ? carbohydrates.set(true) : fats.set(false);

                    if (food.getProteins() && !proteins.get()) {
                        proteins.set(true);
                    } else {
                        if (food.getFats()) {
                            fats.set(true);
                        } else {
                            if (food.getCarbohydrates()) {
                                carbohydrates.set(true);
                            } else {
                                fats.set(false);
                            }
                        }
                    }
                });
//        for (var food : foodstuffs)
//        {
//            if (!proteins && food.getProteins())
//                proteins = true;
//            else
//            if (!fats && food.getFats())
//                fats = true;
//            else
//            if (!carbohydrates && food.getCarbohydrates())
//                carbohydrates = true;
//            if (proteins && fats && carbohydrates)
//                break;
//        }

        if (proteins.get() && fats.get() && carbohydrates.get()) {
            System.out.println("Корзина уже сбалансирована по БЖУ.");
            return;
        }

        market.getThings(clazz).stream()
                .forEach(thing -> {
                    if (!proteins.get() && thing.getProteins()) {
                        proteins.set(true);
                        foodstuffs.add(thing);
                    } else if (!fats.get() && thing.getFats()) {
                        fats.set(true);
                        foodstuffs.add(thing);
                    } else if (!carbohydrates.get() && thing.getCarbohydrates()) {
                        carbohydrates.set(true);
                        foodstuffs.add(thing);
                    }
                    if (proteins.get() && fats.get() && carbohydrates.get()) ;
                });
//        for (var thing : market.getThings(clazz)) {
//            if (!proteins.get() && thing.getProteins()) {
//                proteins.set(true);
//                foodstuffs.add(thing);
//            } else if (!fats.get() && thing.getFats()) {
//                fats.set(true);
//                foodstuffs.add(thing);
//            } else if (!carbohydrates.get() && thing.getCarbohydrates()) {
//                carbohydrates.set(true);
//                foodstuffs.add(thing);
//            }
//            if (proteins.get() && fats.get() && carbohydrates.get())
//                break;
//        }

                            if (proteins.get() && fats.get() && carbohydrates.get())
                                System.out.println("Корзина сбалансирована по БЖУ.");
                            else
                                System.out.println("Невозможно сбалансировать корзину по БЖУ.");

                        }

                        //endregion

        public Collection<T> getFoodstuffs () {
            return foodstuffs;
        }


        public void printFoodstuffs () {
        /*int index = 1;
        for (var food : foodstuffs)
            System.out.printf("[%d] %s (Белки: %s Жиры: %s Углеводы: %s)\n", index++, food.getName(), food.getProteins() ? "Да" : "Нет",
                    food.getFats() ? "Да" : "Нет", food.getCarbohydrates() ? "Да" : "Нет");*/


            AtomicInteger index = new AtomicInteger(1);
            foodstuffs.forEach(food -> System.out.printf("[%d] %s (Белки: %s Жиры: %s Углеводы: %s)\n",
                    index.getAndIncrement(), food.getName(),
                    food.getProteins() ? "Да" : "Нет",
                    food.getFats() ? "Да" : "Нет",
                    food.getCarbohydrates() ? "Да" : "Нет"));
        }
    }

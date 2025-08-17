package ru.netology.data.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int shift) {
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
    //Генерация даты

    public static String generateCity() {
        String[] cities = new String[]{"Москва", "Екатеринбург", "Уфа"};
        // генерацию городов можно выполнить с помощью Faker, либо используя массив валидных городов и класс Random
        return cities[new Random().nextInt(cities.length)];
    }

    public static String generateName(Faker faker) {
        return faker.name().lastName() + " " + faker.name().firstName();
           //  генерация Имени через Faker
    }

    public static String generatePhone(Faker faker) {
        return faker.phoneNumber().phoneNumber();
        // генерация телефона через Faker
    }

    public static class Registration {
        private static Faker faker;

        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            faker = new Faker(new Locale(locale));
            return new UserInfo(generateCity(), generateName(faker), generatePhone(faker));
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;


        // дата класс - шаблон для создания объекта
    }
}

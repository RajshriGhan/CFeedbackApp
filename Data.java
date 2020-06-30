package com.example.savedata;

public class Data {


        String key;

        String name;
    String age;

        public Data(String key, String name, String age) {
            this.key = key;
            this.name = name;

            this.age = age;
        }

        public Data() {
        }



        public String getKey() {
            return key;
        }

        public String getName() {
            return name;
        }



        public String getAge() {
            return age;
        }
    }


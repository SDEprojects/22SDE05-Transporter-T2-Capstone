package com.tlglearning.model;

public enum State {
    IL("Illinois", "Chicago", "Enjoy the windy city!"),
    KY("Kentucky", "Louisville", "Get some KFC where you are there"),
    OH("Ohio", "Columbus", "Go Buckeyes!"),
    SC("South Carolina", "Charleston", "Time to relax in Myrtle beach"),
    TN("Tennessee", "Memphis", "You may see Elvis!"),
    MS("Mississippi", "Biloxi", "It sure is hot!"),
    AL("Mississippi", "Biloxi", "It sure is hot!"),
    GA("Mississippi", "Biloxi", "It sure is hot!");

    private String name;
    private String city;

    private String saying;




    State(String name, String city, String saying){
        this.name = name;
        this.city = city;
        this.saying = saying;
    }


    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getSaying() {
        return saying;
    }

}

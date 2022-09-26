package com.tlglearning.model;

public enum State {
    IL("Illinois", "Chicago", "Enjoy the windy city!"),
    KY("Kentucky", "Louisville", "Get some KFC while you're are there!"),
    OH("Ohio", "Columbus", "Go Buckeyes!"),
    SC("South Carolina", "Myrtle Beach", "Go relax in Myrtle Beach!"),
    TN("Tennessee", "Memphis", "Go check out the Great Smoky Mountains!"),
    MS("Mississippi", "Biloxi", "Go checkout the Gulf Coast!"),
    AL("Alabama", "Montgomery", "Enjoy the southern hospitality!"),
    GA("Georgia", "Atlanta", "Go enjoy Piedmont Park!"),
    IN("Indiana", "Indianapolis", "Stop and watch the Indy 500!"),
    WV("West Virginia", "Charleston", "Some of the prettiest wilderness!"),
    MD("Maryland", "Baltimore", "Go enjoy the inner harbor!"),
    NC("North Carolina", "Raleigh", "Go checkout the Wright Brothers Memorial!"),
    VA("Virginia", "Roanoke", "Virginia achieved statehood in 1788!");


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

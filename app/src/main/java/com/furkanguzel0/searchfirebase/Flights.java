package com.furkanguzel0.searchfirebase;

public class Flights {
        private String CheckOutDate;
        private String arrival_airport;
        private String arrival_city;
        private String arrival_time;
        private String checkInDate;
        private String departure_airport;
        private String departure_city;
        private String departure_time;
        private String flight_company;
        private String flight_id;
        private String flight_img;
        private String price;
        private String link_adress;


    public Flights() {
    }

    public Flights(String checkOutDate, String arrival_airport, String arrival_city, String arrival_time, String checkInDate, String departure_airport, String departure_city, String departure_time, String flight_company, String flight_id, String flight_img, String price, String link_adress) {
        CheckOutDate = checkOutDate;
        this.arrival_airport = arrival_airport;
        this.arrival_city = arrival_city;
        this.arrival_time = arrival_time;
        this.checkInDate = checkInDate;
        this.departure_airport = departure_airport;
        this.departure_city = departure_city;
        this.departure_time = departure_time;
        this.flight_company = flight_company;
        this.flight_id = flight_id;
        this.flight_img = flight_img;
        this.price = price;
        this.link_adress = link_adress;
    }

    public String getCheckOutDate() {
        return CheckOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        CheckOutDate = checkOutDate;
    }

    public String getArrival_airport() {
        return arrival_airport;
    }

    public void setArrival_airport(String arrival_airport) {
        this.arrival_airport = arrival_airport;
    }

    public String getArrival_city() {
        return arrival_city;
    }

    public void setArrival_city(String arrival_city) {
        this.arrival_city = arrival_city;
    }

    public String getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(String arrival_time) {
        this.arrival_time = arrival_time;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getDeparture_airport() {
        return departure_airport;
    }

    public void setDeparture_airport(String departure_airport) {
        this.departure_airport = departure_airport;
    }

    public String getDeparture_city() {
        return departure_city;
    }

    public void setDeparture_city(String departure_city) {
        this.departure_city = departure_city;
    }

    public String getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(String departure_time) {
        this.departure_time = departure_time;
    }

    public String getFlight_company() {
        return flight_company;
    }

    public void setFlight_company(String flight_company) {
        this.flight_company = flight_company;
    }

    public String getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(String flight_id) {
        this.flight_id = flight_id;
    }

    public String getFlight_img() {
        return flight_img;
    }

    public void setFlight_img(String flight_img) {
        this.flight_img = flight_img;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getLink_adress() {
        return link_adress;
    }

    public void setLink_adress(String link_adress) {
        this.link_adress = link_adress;
    }
}

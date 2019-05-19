package com.furkanguzel0.searchfirebase;

public class Hotels {
    private String CheckOutDate;
    private String checkInDate;
    private String hotel_id;
    private String hotel_img;
    private String hotel_location;
    private String hotel_name;
    private String price;
    private String link_adress;

    public Hotels() {
    }

    public Hotels(String checkOutDate, String checkInDate, String hotel_id, String hotel_img, String hotel_location, String hotel_name, String price, String link_adress) {
        CheckOutDate = checkOutDate;
        this.checkInDate = checkInDate;
        this.hotel_id = hotel_id;
        this.hotel_img = hotel_img;
        this.hotel_location = hotel_location;
        this.hotel_name = hotel_name;
        this.price = price;
        this.link_adress = link_adress;
    }

    public String getCheckOutDate() {
        return CheckOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        CheckOutDate = checkOutDate;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(String hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String getHotel_img() {
        return hotel_img;
    }

    public void setHotel_img(String hotel_img) {
        this.hotel_img = hotel_img;
    }

    public String getHotel_location() {
        return hotel_location;
    }

    public void setHotel_location(String hotel_location) {
        this.hotel_location = hotel_location;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
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

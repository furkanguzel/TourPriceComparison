package com.furkanguzel0.searchfirebase;

public class Tours {
    private String CheckOutDate;
    private String checkInDate;
    private String location;
    private String price;
    private String tour_id;
    private String tour_img;
    private String tour_name;

    public Tours() {
    }

    public Tours(String checkOutDate, String checkInDate, String location, String price, String tour_id, String tour_img, String tour_name) {
        CheckOutDate = checkOutDate;
        this.checkInDate = checkInDate;
        this.location = location;
        this.price = price;
        this.tour_id = tour_id;
        this.tour_img = tour_img;
        this.tour_name = tour_name;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTour_id() {
        return tour_id;
    }

    public void setTour_id(String tour_id) {
        this.tour_id = tour_id;
    }

    public String getTour_img() {
        return tour_img;
    }

    public void setTour_img(String tour_img) {
        this.tour_img = tour_img;
    }

    public String getTour_name() {
        return tour_name;
    }

    public void setTour_name(String tour_name) {
        this.tour_name = tour_name;
    }
}

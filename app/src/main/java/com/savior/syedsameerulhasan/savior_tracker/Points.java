package com.savior.syedsameerulhasan.savior_tracker;

public class Points {

    private int _id;
    private String _latitude;
    private String _longitude;
    private String _phoneNumber;

    public Points(){
    }

    public Points(String _latitude, String _longitude, String PhoneNumber) {
        this._latitude = _latitude;
        this._longitude = _longitude;
        this._phoneNumber= PhoneNumber;
    }

    public String get_latitude() {
        return _latitude;
    }

    public String get_longitude() {
        return _longitude;
    }
    public String get_PhoneNumber() {
        return _phoneNumber;
    }
}

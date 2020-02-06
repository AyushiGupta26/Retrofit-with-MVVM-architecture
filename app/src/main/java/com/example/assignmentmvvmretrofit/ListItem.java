package com.example.assignmentmvvmretrofit;

import org.json.JSONArray;

public class ListItem {
    private String modelName;
    private String color;
    private int quantity;
    private int lowest;
    private int totalBids;
    private int expectedPrice;
    private String endsOn;

    private JSONArray bidders;

    public ListItem(String modelName, String color, int quantity, int lowest, int totalBids, int expectedPrice, String endsOn, JSONArray bidders) {
        this.modelName = modelName;
        this.color = color;
        this.quantity = quantity;
        this.lowest = lowest;
        this.totalBids = totalBids;
        this.expectedPrice = expectedPrice;
        this.endsOn = endsOn;
        this.bidders = bidders;
    }

    public String getModelName() {
        return modelName;
    }

    public String getColor() {
        return color;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getLowest() {
        return lowest;
    }

    public int getTotalBids() {
        return totalBids;
    }

    public int getExpectedPrice() {
        return expectedPrice;
    }

    public String getEndsOn() {
        return endsOn;
    }

    public JSONArray getBidders() {
        return bidders;
    }
}

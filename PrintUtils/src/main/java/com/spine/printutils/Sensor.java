package com.spine.printutils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;


public class Sensor implements Serializable {



    ArrayList<Map<String, Object>> KOTS=new ArrayList<>();
    ArrayList<String> Kitchens=new ArrayList<>();
      String Floor,OrderID,OrderType,TableNumber,SubTable,Orderer,CustomText;
     ArrayList<String> Floors=new ArrayList<>();
     String Sum;
    ArrayList<String> KitchenNames=new ArrayList<>();

    public Sensor(ArrayList<Map<String, Object>> KOTS, String floor, String orderID, String orderType, String tableNumber, String subTable, String orderer, String customText, ArrayList<String> floors, String sum, ArrayList<String> kitchenNames, ArrayList<String> Kitchens) {

        this.KOTS = KOTS;
        this.Kitchens = Kitchens;
        this.Floor = floor;
        this.OrderID = orderID;
        this. OrderType = orderType;
        this.TableNumber = tableNumber;
        this.SubTable = subTable;
        this.Orderer = orderer;
        this.CustomText = customText;
        this.Floors = floors;
        this.Sum = sum;
        this.KitchenNames = kitchenNames;
    }


    public ArrayList<Map<String, Object>> getKOTS() {
        return KOTS;
    }

    public ArrayList<String> getKitchens() {
        return Kitchens;
    }

    public String getFloor() {
        return Floor;
    }

    public String getOrderID() {
        return OrderID;
    }

    public String getOrderType() {
        return OrderType;
    }

    public String getTableNumber() {
        return TableNumber;
    }

    public String getSubTable() {
        return SubTable;
    }

    public String getOrderer() {
        return Orderer;
    }

    public String getCustomText() {
        return CustomText;
    }

    public ArrayList<String> getFloors() {
        return Floors;
    }

    public String getSum() {
        return Sum;
    }

    public ArrayList<String> getKitchenNames() {
        return KitchenNames;
    }
}
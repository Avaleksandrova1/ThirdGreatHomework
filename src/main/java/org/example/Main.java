package org.example;


import lombok.extern.slf4j.Slf4j;
import org.example.helpers.FileLoader;
import org.example.classes.*;
import org.example.loaders.*;
import org.json.JSONObject;


import java.util.Map;

@Slf4j
public class Main {
    public static void main(String[] args) {
        String pathToFile = "C:\\Users\\Nastya\\kpoGreatHomeworks\\homework_3\\src\\main\\resources\\start_files.txt";
        JSONObject jsonData = FileLoader.getJSON(pathToFile);

        CardLoaderJson cardLoaderJson = new CardLoaderJson(jsonData.getString("CardLoaderFile"));
        CookerLoaderJson cookerLoaderJson = new CookerLoaderJson(jsonData.getString("CookerLoaderFile"));
        EquipmentLoaderJson equipmentLoaderJson = new EquipmentLoaderJson(jsonData.getString("EquipmentLoaderFile"));
        EquipmentTypeLoaderJson equipmentTypeLoaderJson = new EquipmentTypeLoaderJson(jsonData.getString("EquipmentTypeLoaderFile"));
        MenuDishLoaderJson menuDishLoaderJson = new MenuDishLoaderJson(jsonData.getString("MenuDishLoaderFile"));
        OperationTypeLoaderJson operationTypeLoaderJson = new OperationTypeLoaderJson(jsonData.getString("OperationTypeLoaderFile"));
        ProductLoaderJson productLoaderJson = new ProductLoaderJson(jsonData.getString("ProductLoaderFile"));
        ProductTypeLoaderJson productTypeLoaderJson = new ProductTypeLoaderJson(jsonData.getString("ProductTypeLoaderFile"));
        VisitorLoaderJson visitorLoaderJson = new VisitorLoaderJson(jsonData.getString("VisitorLoaderFile"));

        Map<Integer, Card> cardMap = cardLoaderJson.load();
        Map<Integer, Cooker> cookerMap = cookerLoaderJson.load();
        Map<Integer, Equipment> equipmentMap = equipmentLoaderJson.load();
        Map<Integer, EquipmentType> equipmentTypeMap = equipmentTypeLoaderJson.load();
        Map<Integer, Dish> menuDishMap = menuDishLoaderJson.load();
        Map<Integer, OperationType> operationTypeMap = operationTypeLoaderJson.load();
        Map<Integer, Product> productMap = productLoaderJson.load();
        Map<Integer, ProductType> productTypeMap = productTypeLoaderJson.load();
        Map<String, Visitor> visitorMap = visitorLoaderJson.load();

        if (cardMap == null || cookerMap == null || equipmentMap == null || equipmentTypeMap == null || menuDishMap == null || operationTypeMap == null || productMap == null || productTypeMap == null || visitorMap == null) {
            log.error("Error in loading data");
            return;
        }

        log.info("Data loaded successfully");
    }
}
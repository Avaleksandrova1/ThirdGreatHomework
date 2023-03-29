package org.example.constants;

public class MessageOntologyConstants {
    private MessageOntologyConstants() {
        throw new RuntimeException("MessageStatusConstants class cannot be instantiated");
    }

    public static final String GET_MENU_DISHES = "/get_menu_dishes";
    public static final String GET_AVAILABLE_DISHES = "/get_available_dishes";
    public static final String GET_MENU_CARDS = "/get_menu_cards";
    public static final String GET_CARDS = "/get_cards";
    public static final String PREPARE_GOODS = "/prepare_goods";
    public static final String RESERVE_PRODUCTS_FOR_ORDER = "/reserve_products_for_order";
    public static final String ORDER_DISHES = "/order_dishes";


    public static final String DEACTIVATE_PROCESS_START = "/deactivate_process_";
    public static final String DEACTIVATE_OPERATION_START = "/deactivate_operation_";
    public static final String DEACTIVATE_PRODUCT_START = "/deactivate_product_";
}

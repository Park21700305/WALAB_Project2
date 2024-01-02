package service;

import domain.Menu;
import domain.MenuOrder;
import domain.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MenuService {
    private List<Menu> menus;

    public MenuService() {
        menus = new ArrayList<>();
        loadMenusFromJson("src/fileIO/menuData.json");
    }

    private void loadMenusFromJson(String filePath) {
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader(filePath)) {
            JSONArray menuArray = (JSONArray) parser.parse(reader);

            for (Object o : menuArray) {
                JSONObject menuObject = (JSONObject) o;
                String menuName = (String) menuObject.get("menuName");
                Long priceLong = (Long) menuObject.get("price");
                int price = priceLong.intValue();

                menus.add(new Menu(menuName, price));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void addMenuOrderToUser(User user, Menu menu, int quantity) {
        MenuOrder menuOrder = new MenuOrder(menu, quantity);
        user.getMenuOrders().add(menuOrder);
        Pattern pattern = Pattern.compile("^[0-9]");
        Matcher matcher = pattern.matcher(menu.getMenuName());

        int totalPrice = user.getTotalPrice() + menu.getPrice() * quantity;
        user.setTotalPrice(totalPrice);

        if (matcher.find()) {
            String timeString = menu.getMenuName();

            int additionalTime = Integer.parseInt(timeString.replaceAll("[^0-9]", "")) * quantity;
            int newChargingTime = user.getChargingTime() + additionalTime;
            user.setChargingTime(newChargingTime);
        }

    }

    public List<Menu> getMenus() {
        return menus;
    }
}

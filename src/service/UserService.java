package service;

import domain.Menu;
import domain.MenuOrder;
import domain.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private final List<User> users = new ArrayList<>();

    public void createUser(Long id, String email, String password, String name) {
        if (isEmailExist(email)) {
            throw new IllegalStateException("이미 존재하는 이메일입니다.");
        }

        User newUser = User.builder()
                .id(id++)
                .email(email)
                .password(password)
                .name(name)
                .build();

        users.add(newUser);
    }

    // 이메일 중복 체크
    public boolean isEmailExist(String email) {
        return users.stream().anyMatch(user -> user.getEmail().equals(email));
    }

    // 유저 삭제
    public void removeUser(String email, String password) {
        users.removeIf(user -> user.getEmail().equals(email) && user.getPassword().equals(password));
    }

    // 유저 목록 조회
    public List<User> listAllUsers() {
        return new ArrayList<>(users);
    }

    // 유저 찾기
    public User findUser(String email, String password) {
        return users.stream()
                .filter(user -> user.getEmail().equals(email) && user.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }

    // 유저 정보 수정
    public void updateUser(User user, String email, String password, String name) {
        if (user != null) {
            if (email != null && !email.isEmpty()) user.setEmail(email);
            if (password != null && !password.isEmpty()) user.setPassword(password);
            if (name != null && !name.isEmpty()) user.setName(name);
        }
    }

    // 주문한 메뉴 취소
    public void removeOrder(User user, MenuOrder orderToRemove) {
        Menu menu = orderToRemove.getMenu();
        int quantity = orderToRemove.getQuantity();

        // 주문 목록에서 삭제
        user.getMenuOrders().removeIf(order -> order.equals(orderToRemove));

        // 총 가격 업데이트
        int priceReduction = menu.getPrice() * quantity;
        user.setTotalPrice(Math.max(user.getTotalPrice() - priceReduction, 0)); // 가격은 음수가 되지 않도록

        // 만약 시간 관련 메뉴인 경우, 시간도 업데이트
        if (menu.getMenuName().startsWith("TIME")) {
            String timeString = menu.getMenuName();
            int timeReduction = Integer.parseInt(timeString.replaceAll("[^0-9]", "")) * quantity;
            user.setChargingTime(Math.max(user.getChargingTime() - timeReduction, 0)); // 시간은 음수가 되지 않도록
        }
    }

    // 모든 유저 정보 JSON 파일로 저장
    public void saveUsersToJson(String filePath) {
        JSONArray usersArray = new JSONArray();
        for (User user : users) {
            JSONObject userJson = new JSONObject();
            userJson.put("이메일", user.getEmail());
            userJson.put("이름", user.getName());
            userJson.put("등록날짜", user.getRegDate());
            userJson.put("충전시간", user.getChargingTime());
            userJson.put("총 지불 금액", user.getTotalPrice());

            JSONArray ordersArray = new JSONArray();
            for (MenuOrder order : user.getMenuOrders()) {
                JSONObject orderJson = new JSONObject();
                orderJson.put("메뉴명", order.getMenu().getMenuName());
                orderJson.put("수량", order.getQuantity());
                ordersArray.add(orderJson);
            }

            userJson.put("주문내역", ordersArray);
            usersArray.add(userJson);
        }

        try (FileWriter file = new FileWriter(filePath)) {
            file.write(usersArray.toJSONString());
            System.out.println("---------모든 유저 정보가 저장되었습니다.---------");
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

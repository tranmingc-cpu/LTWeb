package DAO;
import java.util.List;

import model.Food;
public interface FoodDAO {
public void insert (Food food);
public void update(Food food);
public void delete(Food food);
public List<Food> findByName(String name);
public  List<Food> findByCategory(String category);
public List<Food> findALL();
}

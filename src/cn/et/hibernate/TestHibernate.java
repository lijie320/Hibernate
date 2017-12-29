package cn.et.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import cn.et.hibernate.dao.Food;

public class TestHibernate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//deleteFood();
		queryFood();
	}

	public static void saveFood() {
		Session session = HibernateSessionFactory.getSession();
		Food food = new Food();
		food.setFoodname("Éµ");
		food.setMoney(20);
		session.getTransaction().begin();
		session.save(food);
		session.getTransaction().commit();
	}
	
	
	public static void deleteFood(){
		Session session = HibernateSessionFactory.getSession();
		Food food = new Food();
		food.setFoodid(Integer.parseInt("14"));
		session.beginTransaction().begin();
		session.delete(food);
		session.beginTransaction().commit();
	}
	
	
	public static void updateFood(){
		Session session = HibernateSessionFactory.getSession();
		Food food = new Food();
		food.setFoodname("À±½·³´¼¦µ°");
		food.setMoney(Integer.parseInt("30"));
		food.setFoodid(Integer.parseInt("13"));
		session.beginTransaction().begin();
		session.update(food);
		session.beginTransaction().commit();
	}
	
	public static void queryFood(){
		Session session = HibernateSessionFactory.getSession();
		Food foodList = (Food) session.load(Food.class, 7);
		System.out.println(foodList.getFoodname());
//		Criteria c = session.createCriteria(Food.class).add(Restrictions.like("foodname", "%À±%"));
//		List<Food> food = c.list();
//		for(Food f:food){
//			System.out.println(f.getFoodname());
//		}
		
		Query query = session.createQuery("from Food where foodname like '%À±%'");
		List<Food> food = query.list();
		for(Food f:food){
		System.out.println(f.getFoodname());
	}
	}
}

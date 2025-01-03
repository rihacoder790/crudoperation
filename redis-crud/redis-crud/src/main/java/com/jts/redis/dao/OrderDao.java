package com.jts.redis.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.jts.redis.entity.Order;

@Repository
public class OrderDao {
	private  static final String HASH_KEY = "Order";
	
	@Autowired
	private RedisTemplate template;
	
	
	public Order save(Order order) {
		template.opsForHash().put(HASH_KEY,order.getId(),order);
		return order;
	}
	
	public List<Order>findAll(){
		template.opsForHash().values(HASH_KEY);
		List<Order> order = null;
		return order;
	}
	public Order findProductById(int id){
		return (Order) template.opsForHash().get(HASH_KEY,id);
		
	}
	public String deleteOrder(int id){
            template.opsForHash().delete(HASH_KEY,id); 
            return "Order deleted successfully!";
	
	}

	public List<Order> findOrderById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}

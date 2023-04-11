package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import enumsJava.OrderStatus;

public class Order {

	private Date moment;
	private OrderStatus status;

	private Product product;
	private Client client;
	private List<OrderItem> orders = new ArrayList<>();
	private Double sum;
	private OrderItem orderItem;

	public Order() {
	}

	public Order(Date moment, OrderStatus status, Client client, Product product) {
		this.moment = moment;
		this.status = status;
		this.client = client;
		this.product = product;
	}

	public Order(Date moment, OrderStatus status, Client client) {

		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Order(Double sum) {
		this.sum = sum;
	}

	public Double getSum() {
		return sum;
	}

	public Double setSum() {
		return sum;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<OrderItem> getOrder() {
		return orders;
	}

	public void addItem(OrderItem order) {
		orders.add(order);
	}

	public void removeItem(OrderItem order) {
		orders.remove(order);
	}

	public Double total() {
		return sum;

	}

}

package Threads;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*Write a program that simulates a simple online shopping cart. Implement the following functionalities:

Create a Product class that represents a product with a name, price, and quantity.

Create a ShoppingCart class that maintains a collection of products. It should have methods to add a product to the cart, 
remove a product from the cart, and calculate the total price of all products in the cart.

Create a Customer class that represents a customer. Each customer has a name and a shopping cart.

Create a Shop class that simulates an online shop. It should have a collection of customers. Implement a method in the Shop
 class called processOrders that iterates over the customers and processes their shopping carts concurrently using threads. 
 The method should print the total price for each customer's cart.

Your program should demonstrate the usage of threads and collections by creating multiple customers, adding products to their 
shopping carts, and processing the orders concurrently.

Feel free to implement this program, and I'm here to assist you further if needed!*/

class Product {
	String name;
	double price;
	int quantity;

	public Product(String name, double price, int quantity) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}
}

class ShoppingCart {
	ArrayList<Product> P;

	public ArrayList<Product> getP() {
		return P;
	}

	public void setP(ArrayList<Product> p) {
		P = p;
	}

	public void addToCart(Product p) {
		P.add(p);
	}

	public void RemoveFromCart(Product p) {
		int i = 0;
		for (int j = 0; j < P.size(); j++) {
			if (p.getName().equals(P.get(j).getName())) {
				i = j;
			}
		}
		if (i == -1) {
			System.out.println("No such product available");
		} else {
			P.remove(i);
		}
	}

	public double CalculatePriceOfAll() {
		double res = 0;
		for (int j = 0; j < P.size(); j++) {
			res += P.get(j).getPrice() * P.get(j).getQuantity();
		}
		return res;
	}
}

class Customer implements Runnable {
	String name;
	ShoppingCart sc;

	public Customer(String name, ShoppingCart sc) {
		super();
		this.name = name;
		this.sc = sc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ShoppingCart getSc() {
		return sc;
	}

	public void setSc(ShoppingCart sc) {
		this.sc = sc;
	}

	@Override
	public synchronized void run() {
		// TODO Auto-generated method stub
		System.out.println("Order Statics Of " + this.getName() + " Cart List :  \n"+"Total Price :" + this.getSc().CalculatePriceOfAll() + "\n");
	}
}


public class Shop {
	public static void main(String args[]) {
		Product p1 = new Product("Pens", 5, 9);
		Product p2 = new Product("white books", 40, 7);
		ShoppingCart Pc1 = new ShoppingCart();
		Pc1.setP(new ArrayList<>());
		Pc1.addToCart(p1);
		Pc1.addToCart(p2);
		Customer C1 = new Customer("Madhu", Pc1);

		p1 = new Product("Lunch Box", 250, 2);
		p2 = new Product("Soaps", 20, 10);
		Product p3 = new Product("All Out", 70, 1);
		ShoppingCart Pc2 = new ShoppingCart();
		Pc2.setP(new ArrayList<>());
		Pc2.addToCart(p1);
		Pc2.addToCart(p2);
		Pc2.addToCart(p3);
		Customer C2 = new Customer("Pavani", Pc2);

		ArrayList<Customer> Clist = new ArrayList<>();
		Clist.add(C1);
		Clist.add(C2);

		ExecutorService E = Executors.newFixedThreadPool(2);
		for(int i=0;i<Clist.size();i++) {
			E.execute((Clist.get(i)));
		}
		E.shutdown();
	}
}

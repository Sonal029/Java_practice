package practice;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Product {

	private int productId;
	private String productName;
	private double productPrice;
	private int quantity;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public int getQuantity() {
		return quantity;

	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "functionalInterface [productId=" + productId + ", productName=" + productName + ", productPrice="
				+ productPrice + ", quantity=" + quantity + "]";
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int productId, String productName, double productPrice, int quantity) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.quantity = quantity;
	}

	public static void main(String[] args) {
		Function<String, Product> f1 = str -> {
			String[] prod = str.split(", ");
			int productId = Integer.parseInt(prod[0].trim());
			String productName = prod[1].trim();
			double productPrice = Double.parseDouble(prod[2].trim());
			int quantity = Integer.parseInt(prod[3].trim());

			return new Product(productId, productName, productPrice, quantity);

		};

		Supplier<Product> sup = () -> new Product(1, "Pen", 20.00, 100);

		Consumer<Product> con = str -> System.out.println("productId: " + str.getProductId() + ", productName:"
				+ str.getProductName() + ", productPrice:" + str.getProductPrice() + ", quantity:" + str.getQuantity());

		Predicate<Product> pre = prod -> prod.getQuantity() > 5;

		String prod = "1, Pen, 20.00, 100";
		Product p1 = f1.apply(prod);

		System.out.println(sup.get());
		con.accept(p1);
		System.out.println(pre.test(p1));

	}
}

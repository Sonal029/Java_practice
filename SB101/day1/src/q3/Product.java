package q3;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Product {
	int productId;
	String productName;
	int quantity;
	double price;

	public Product(int productId, String productName, double price,int quantity) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
	}

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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [ProductId=" + productId + ", ProductName=" + productName + ", Quantity=" + quantity
				+ ", Price=" + price + "]";
	}

	public static void main(String[] args) {
		Function<String, Product> stringToProduct = str -> {
			String[] details = str.split(",");
			int productId = Integer.parseInt(details[0].trim());
			String productName = details[1].trim();
			double price = Double.parseDouble(details[2].trim());
			int quantity = Integer.parseInt(details[3].trim());
			return new Product(productId, productName,  price,quantity);
		};

		Supplier<Product> sup = () -> new Product(1, "Pen", 20.00, 100);

		Consumer<Product> con = prod -> System.out.println(
				prod.getProductId() + "," + prod.getProductName() + "," + prod.getPrice() + "," + prod.getQuantity());

		Predicate<Product> pre = prod -> prod.getQuantity() > 5;

		String prod = "1, Pen, 20.00,100";
		Product p1 = stringToProduct.apply(prod);
//		System.out.println(stringToProduct.apply(prod));
		System.out.println(sup.get());
		con.accept(p1);
		System.out.println(pre.test(p1));
	}

}
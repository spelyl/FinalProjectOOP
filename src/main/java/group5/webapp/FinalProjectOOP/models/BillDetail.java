package group5.webapp.FinalProjectOOP.models;

import group5.webapp.FinalProjectOOP.models.keys.BillDetailKey;

import javax.persistence.*;

@Entity
@Table(name = "BillDetail")
@IdClass(BillDetailKey.class)
public class BillDetail {

	private int quantity;

	@Id
	@ManyToOne(optional = false)
	@JoinColumn(name = "product_id", nullable = false)
	private Product productId;

	@Id
	@ManyToOne(optional = false)
	@JoinColumn(name = "bill_id", nullable = false)
	private Bill billId;

	public BillDetail() {
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return productId;
	}

	public void setProduct(Product product) {
		this.productId = product;
	}

	public Bill getBill() {
		return billId;
	}

	public void setBill(Bill bill) {
		this.billId = bill;
	}
}

package group5.webapp.FinalProjectOOP.models.keys;

import java.io.Serializable;

public class BillDetailKey implements Serializable {
    private Integer productId;
    private Integer billId;

    public BillDetailKey(){}

    public BillDetailKey(Integer productId, Integer billId) {
        this.productId = productId;
        this.billId = billId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }
}

package Model;

public class Cart {
	private int cid,pid,cusid,qty;
	private double total_price;
	
	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getTotal_price() {
		return total_price;
	}

	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getCusid() {
		return cusid;
	}

	public void setCusid(int cusid) {
		this.cusid = cusid;
	}

	@Override
	public String toString() {
		return "Cart [cid=" + cid + ", pid=" + pid + ", cusid=" + cusid + ", qty=" + qty + ", total_price="
				+ total_price + "]";
	}

	
}

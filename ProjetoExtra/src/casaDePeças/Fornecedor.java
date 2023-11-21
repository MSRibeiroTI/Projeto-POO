package casaDePeças;

public class Fornecedor extends Base{
		private String phone;
		private String address;
		
	public Fornecedor(String Name, int id, String Phone, String address) {
		super(Name, id);
		this.phone = Phone;
		this.address = address;
		
	}

	public String getPhone() {
		return this.phone;
	}
	public void setPhone(String Phone) {
		this.phone = Phone;
	}
	public String getAddress() {
		return this.address;
	}
	public void setAdsress(String address) {
		this.address = address;
	}
}

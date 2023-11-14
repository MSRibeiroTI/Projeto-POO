package casaDePeças;

public class Fornecedor extends Base{
		private String phone;
		
	public Fornecedor(String Name, String Phone) {
		super(Name);
		this.phone = Phone;
		
	}

	public String getPhone() {
		return this.phone;
	}
	public void setPhone(String Phone) {
		this.phone = Phone;
	}
	
}

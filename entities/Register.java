package entities;

public abstract class Register {

	private String name;
	private Double income;

	public Register() {
	}

	public Register(String name, Double income) {
		this.name = name;
		this.income = income;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		this.income = income;
	}

	public abstract Double tax();

	public String toString() {
		return getName() + ": $ " + String.format("%.2f", tax());
	}

}

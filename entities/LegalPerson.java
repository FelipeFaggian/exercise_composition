package entities;

public class LegalPerson extends Register {

	private Integer numberOfEmployees;

	public LegalPerson() {
		super();
	}

	public LegalPerson(String name, Double income, Integer numberOfEmployees) {
		super(name, income);
		this.numberOfEmployees = numberOfEmployees;
	}

	public Integer getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public void setNumberOfEmployees(Integer numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}

	@Override
	public Double tax() {
		if (getNumberOfEmployees() <= 10) {

			return getIncome() * 0.16;
		} else {

			return getIncome() * 0.14;
		}
	}
}

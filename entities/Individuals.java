package entities;

public class Individuals extends Register {

	private Double healthExpenditures;

	public Individuals() {
		super();
	}

	public Individuals(String name, Double income, Double healthExpenditures) {
		super(name, income);
		this.healthExpenditures = healthExpenditures;
	}

	@Override
	public Double tax() {
		if (getIncome() < 20000) {

			return (getIncome() * 0.15) - (healthExpenditures * 0.5);
		} else {

			return (getIncome() * 0.25) - (healthExpenditures * 0.5);
		}
	}
}

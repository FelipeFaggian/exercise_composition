package model.services;

public class PaypalService implements OnlinePaymentService{

	
	@Override
	public Double interest(Double amount, Integer months) {
		amount += (0.01 * months) * amount;
		return amount;
	}
	
	@Override
	public Double paymentFee(Double amount) {
		amount += 0.02 * amount;
		return amount;
	}

}

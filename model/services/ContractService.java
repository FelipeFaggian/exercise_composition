package model.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {

	private OnlinePaymentService ops;
	private Integer months;

	List<String> list = new ArrayList<>();
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public ContractService(OnlinePaymentService ops, Integer months) {
		this.ops = ops;
		this.months = months;
	}

	public Integer getMonths() {
		return months;
	}
	
	public List<String> getList() {
		return list;
	}

	public void processContract(Contract contract, Integer months) {
		for (int i = 1; i <= months; i++) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(contract.getDate());
			cal.add(Calendar.MONTH, i);
			Date newDate = cal.getTime();
			Double basicPayment = contract.getTotalValue() / months;
			Double amount = basicPayment;
			contract.setInstallment(new Installment(newDate, amount));
			amount = ops.interest(contract.getInstallment().getAmount(), i);
			amount = ops.paymentFee(amount);
			contract.setInstallment(new Installment(newDate, amount));
			list.add(sdf.format(newDate) + " - " + String.format("%.2f", amount));
		}
	}
}

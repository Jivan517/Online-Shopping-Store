package cs544.project.onlineshoppingstore.service;

import java.util.Date;
import java.util.List;

import cs544.project.onlineshoppingstore.model.Payment;

public interface PaymentService {
	
	Payment get(long paymentId);
	List<Payment> getAll();
	void create(Payment payment);
	void update(long id, Payment updatedPayment);
	void delete(long paymentId);

	List<Payment> findByPaymentDate(Date date);
}

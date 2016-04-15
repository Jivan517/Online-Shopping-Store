package cs544.project.onlineshoppingstore.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cs544.project.onlineshoppingstore.dao.PaymentDao;
import cs544.project.onlineshoppingstore.model.Payment;

@Transactional(propagation = Propagation.REQUIRED)
@Component
public class PaymentServiceImpl implements PaymentService {

	private PaymentDao paymentDao;
	
	@Autowired
	public void setPaymentDao(PaymentDao paymentDao){
		this.paymentDao = paymentDao;
	}
	
	@Override
	public Payment get(long paymentId) {
		return paymentDao.findOne(paymentId);
	}

	@Override
	public List<Payment> getAll() {
		return paymentDao.findAll();
	}

	@Override
	public void create(Payment payment) {
		paymentDao.save(payment);
		
	}

	@Override
	public void update(long id, Payment updatedPayment) {
		paymentDao.save(updatedPayment);
		
	}

	@Override
	public void delete(long paymentId) {
		paymentDao.delete(paymentId);
		
	}

	@Override
	public List<Payment> findByPaymentDate(Date date) {
		return paymentDao.findByPaymentDate(date);
	}

}

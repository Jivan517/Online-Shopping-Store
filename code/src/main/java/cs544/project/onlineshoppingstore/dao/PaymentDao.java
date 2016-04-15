package cs544.project.onlineshoppingstore.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import cs544.project.onlineshoppingstore.model.Payment;

public interface PaymentDao extends JpaRepository<Payment, Long>{

	List<Payment> findByPaymentDate(Date date);
}

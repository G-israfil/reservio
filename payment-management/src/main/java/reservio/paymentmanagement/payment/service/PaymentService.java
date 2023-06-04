package reservio.paymentmanagement.payment.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import reservio.paymentmanagement.payment.dao.PaymentRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentService {
    private final PaymentRepository paymentRepository;

    public void createPayment(@NonNull String requestBody){

    }

    public void updatePayment(@NonNull String id, @NonNull String requestBody){

    }


    public void getPayment(@NonNull String id){

    }

    public void listPayments( String name, String value){

    }


    public void deletePayment(@NonNull String id){

    }

    public void refundPayment(){

    }
}

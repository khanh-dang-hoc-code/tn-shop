package com.tech.tnshop.service.serviceImpl;

import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.model.checkout.Session;
import com.stripe.net.RequestOptions;
import com.stripe.param.checkout.SessionCreateParams;
import com.tech.tnshop.dto.response.AbstractResponse;
import com.tech.tnshop.entity.Order;
import com.tech.tnshop.entity.OrderItems;
import com.tech.tnshop.entity.Profile;
import com.tech.tnshop.exception.InternalServerException;
import com.tech.tnshop.repository.IPaymentRepository;
import com.tech.tnshop.service.IPaymentService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PaymentServiceImpl implements IPaymentService {
    private final IPaymentRepository paymentRepository;
    private final AuthenticateService authenticateService;

    @Value("${stripe.api.key}")
    private String stripeApiKey;

    @Value("${client.domain.sucess}")
    private String successUrl;

    @Value("${client.domain.cancel}")
    private String cancelUrl;

    @Override
    public ResponseEntity<Object> checkoutToPaymentPage(HttpServletRequest request, Order order) {
        Profile userProfile  =  authenticateService.getUserFromToken(request).getProfile();

        Order order1 = new Order();
        List<OrderItems> list = new ArrayList<>();
        list.add(new OrderItems());
        list.add(new OrderItems());
        list.add(new OrderItems());
        list.add(new OrderItems());
        order1.setOrderItemsList(list);

        SessionCreateParams params = SessionCreateParams.builder()
                .setMode(SessionCreateParams.Mode.PAYMENT)
                .putExtraParam("payment_method_options[wechat_pay][client]", "web")
                .addAllPaymentMethodType(Arrays.asList(
                        SessionCreateParams.PaymentMethodType.CARD))
                .setAllowPromotionCodes(false)
                .setCurrency("USD")
                .setPaymentIntentData(SessionCreateParams.PaymentIntentData.builder()
                        .setCaptureMethod(SessionCreateParams.PaymentIntentData.CaptureMethod.AUTOMATIC)
                        .build())
                .addAllLineItem(createListLineItem(order1))
                .setCustomerEmail(userProfile.getEmail())
                .setClientReferenceId(order.getId())
                .setSuccessUrl(successUrl)
                .setCancelUrl(cancelUrl)
                .build();

        RequestOptions requestOptions = RequestOptions.builder()
                .setApiKey(stripeApiKey)
                .build();

        try {
            Session session = Session.create(params, requestOptions);
            return ResponseEntity.ok(session.getUrl());

        } catch (StripeException e) {
            throw new InternalServerException("Can not handle payment progress now cause " + e.getCause());
        }
    }

    public ResponseEntity<Object> updatePaymentAction(String paymentSessionId) {
        RequestOptions requestOptions = RequestOptions.builder()
                .setApiKey(stripeApiKey)
                .build();
        try {
            Session session = Session.retrieve(paymentSessionId, requestOptions);
            return ResponseEntity.ok(new AbstractResponse(session.getUrl()));
        } catch (StripeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResponseEntity<Object> refund(String orderId) {

        return null;
    }

    private List<SessionCreateParams.LineItem> createListLineItem(Order order) {
        return  order.getOrderItemsList().stream().map(s ->
            SessionCreateParams.LineItem.builder()
                    .setQuantity(2L)
                    .setPriceData(SessionCreateParams.LineItem.PriceData.builder()
                            .setCurrency("USD")
                            .setUnitAmountDecimal(new BigDecimal("30000"))
                            .setProductData(
                                    SessionCreateParams.LineItem.PriceData.ProductData.builder()
                                            .setName("snake")
                                            .build()
                            )
                            .build())
                    .build()
        ).collect(Collectors.toList());
    }
}

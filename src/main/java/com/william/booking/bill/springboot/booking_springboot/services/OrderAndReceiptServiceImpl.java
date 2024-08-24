package com.william.booking.bill.springboot.booking_springboot.services;

import java.math.BigDecimal;

import java.util.Optional;
import java.util.List;

import org.springframework.stereotype.Service;

import com.william.booking.bill.springboot.booking_springboot.dtos.OrderAndReceiptDTO;
import com.william.booking.bill.springboot.booking_springboot.dtos.OrderDetailAndQuantityDTO;
import com.william.booking.bill.springboot.booking_springboot.entities.Dish;
import com.william.booking.bill.springboot.booking_springboot.entities.Order;
import com.william.booking.bill.springboot.booking_springboot.entities.OrderDetail;
import com.william.booking.bill.springboot.booking_springboot.entities.Receipt;

@Service
public class OrderAndReceiptServiceImpl implements OrderAndReceiptService{

    private final OrderService orderService;

    private final DishService dishService;

    private final OrderDetailService orderDetailService;

    private final ReceiptService receiptService;

    private final SharedService sharedService;

    public OrderAndReceiptServiceImpl(OrderService orderService, DishService dishService, OrderDetailService orderDetailService, ReceiptService receiptService, SharedService sharedService){
        this.orderService = orderService;
        this.dishService = dishService;        
        this.orderDetailService = orderDetailService;
        this.receiptService = receiptService;
        this.sharedService = sharedService;
    }


    @Override
    public int createOrderAndReceipt(OrderAndReceiptDTO orderAndReceiptDTO){

        int areSaved = 0;
        Optional<Order> orderOptional = orderService.getOrderById(sharedService.getOrderId());

        if(orderOptional.isPresent()){
            
            Order order = orderOptional.get();
            List<OrderDetail> orderDetailListFromOrder = order.getOrderDetailList();

            BigDecimal totalAmount = BigDecimal.ZERO;

            for(OrderDetailAndQuantityDTO orderDetailAndQuantityDTO : orderAndReceiptDTO.getOrdersAndQuantity() ){

                Optional<Dish> dishOptional = dishService.getDishById(orderDetailAndQuantityDTO.getDishId());
                Integer orderQuantity = orderDetailAndQuantityDTO.getQuantityOrdered();

                if(dishOptional.isPresent() && orderQuantity > 0){

                    totalAmount = totalAmount.add(dishOptional.get().getPrice().multiply(new BigDecimal(orderQuantity)));

                    OrderDetail orderDetail = new OrderDetail();
                    orderDetail.setOrder(orderOptional.get());    //check
                    orderDetail.setDish(dishOptional.get());
                    orderDetail.setQuantity(orderQuantity);

                    Optional<OrderDetail> orderDetailSavedOptional = orderDetailService.createOrderDetail(orderDetail);
                    if(orderDetailSavedOptional.isPresent())
                        areSaved++;

                    orderDetailListFromOrder.add(orderDetail);

                }
            }

            order.setOrderDetailList(orderDetailListFromOrder);

            Receipt receipt = new Receipt();
            receipt.setId(System.currentTimeMillis());
            receipt.setOrder(orderOptional.get());
            receipt.setTotalAmount(totalAmount);
            receipt.setTip(orderAndReceiptDTO.getTip());
            receipt.setPaymentAmount(totalAmount.add(orderAndReceiptDTO.getTip()));

            Optional<Receipt> receiptSavedOptional = receiptService.createReceipt(receipt);
            if(receiptSavedOptional.isPresent())
                areSaved++;

        }

        return areSaved;
    }

}

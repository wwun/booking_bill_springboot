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

        //{"clientEmail":"jfarfan17@gmail.com","orderHour":"11:32","tip":6,"paymentAmount":66,"table":3,"orders":[{"id":12,"quantity":1},{"id":11,"quantity":1}]}

        //OrderDetail
        // Long id;
        // Order order;
        // Dish dish;
        // Integer quantity

        //Receipt
        // Long id;
        // Order order;
        // BigDecimal totalAmount;
        // BigDecimal tip;
        // BigDecimal paymentAmount

        //Order
        // Long id;
        // LocalDateTime dateTime;
        // Integer reservedTable;
        // Client client;
        // List<OrderDetail> orderDetailList

        int areSaved = 0;
        Optional<Order> orderOptional = orderService.getOrderById(sharedService.getOrderId());

        System.out.println("startiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiing: "+orderOptional.get());

        if(orderOptional.isPresent()){
            
            Order order = orderOptional.get();
            List<OrderDetail> orderDetailListFromOrder = order.getOrderDetailList();

            BigDecimal totalAmount = BigDecimal.ZERO;
            System.out.println("1111111111111111111111111111111111111");

            for(OrderDetailAndQuantityDTO orderDetailAndQuantityDTO : orderAndReceiptDTO.getOrdersAndQuantity() ){

                System.out.println("222222222222222222222222222222222222");
            
                Optional<Dish> dishOptional = dishService.getDishById(orderDetailAndQuantityDTO.getDishId());
                Integer orderQuantity = orderDetailAndQuantityDTO.getQuantityOrdered();

                if(dishOptional.isPresent() && orderQuantity > 0){

                    System.out.println("3333333333333333333333333333333333");

                    totalAmount = totalAmount.add(dishOptional.get().getPrice().multiply(new BigDecimal(orderQuantity)));

                    OrderDetail orderDetail = new OrderDetail();
                    //orderDetail.setId(System.currentTimeMillis() + ThreadLocalRandom.current().nextInt(1, 1000));
                    orderDetail.setOrder(orderOptional.get());    //check
                    orderDetail.setDish(dishOptional.get());
                    orderDetail.setQuantity(orderQuantity);

                    Optional<OrderDetail> orderDetailSavedOptional = orderDetailService.createOrderDetail(orderDetail);
                    System.out.println("orderDet saveeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeed: "+orderDetailSavedOptional.get());
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

            System.out.println("receipt to saaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaave");
            Optional<Receipt> receiptSavedOptional = receiptService.createReceipt(receipt);
            System.out.println("receipt saveeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeed: "+receiptSavedOptional.get());
            if(receiptSavedOptional.isPresent())
                areSaved++;

        }

        return areSaved;
    }

}

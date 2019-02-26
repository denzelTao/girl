package com.imooc.server;

import com.imooc.dao.OrderRepositity;
import com.imooc.dao.OrderServiceImpl;

import javax.xml.ws.Endpoint;

public class OrderServer {

    public static void main(String[] args) {
        OrderServiceImpl orderService = new OrderServiceImpl();

        Endpoint.publish("http://localhost:8082/api",orderService);

        System.out.println("**********webservice startup!");

    }
}

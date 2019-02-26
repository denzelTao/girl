package com.imooc.service;

import com.imooc.dao.OrderRepositity;
import com.imooc.domain.Torder;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface OrderService {

    Torder create(Torder order);

    Torder findById(Integer id);

    void delete(Integer id);

    void delete(Torder order);

    List<Torder> list();

    Torder update(Torder order);

    Torder findByName(String name);






}

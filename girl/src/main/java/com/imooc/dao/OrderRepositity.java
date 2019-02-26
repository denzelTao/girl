package com.imooc.dao;

import com.imooc.domain.Torder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepositity extends JpaRepository<Torder, Integer> {


    Torder findByName(String name);

}

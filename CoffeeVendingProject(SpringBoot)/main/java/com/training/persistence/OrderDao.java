package com.training.persistence;

import com.training.beans.Orders2;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface OrderDao extends CrudRepository<Orders2, Integer> {

    @Query("select max(orderId) from Orders2 ")
    int getMaxOrderId();
}

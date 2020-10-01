package com.training.persistence;

import com.training.beans.AddOn;
import com.training.beans.DiscountCoupon;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface DiscountDao extends CrudRepository<DiscountCoupon, String> {
    @Query("from DiscountCoupon where couponCode = :name")
    DiscountCoupon getDiscountCouponByCouponCode(@Param("name") String name);
}

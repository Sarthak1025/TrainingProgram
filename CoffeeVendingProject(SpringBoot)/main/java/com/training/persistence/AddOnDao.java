package com.training.persistence;

import com.training.beans.AddOn;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface AddOnDao extends CrudRepository<AddOn, Integer> {
    @Query("from AddOn where addOnName = :name")
    AddOn getAddOnByAddOnName(@Param("name") String name);
}

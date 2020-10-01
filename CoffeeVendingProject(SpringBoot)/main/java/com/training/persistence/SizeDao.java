package com.training.persistence;

import com.training.beans.AddOn;
import com.training.beans.Size;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface SizeDao extends CrudRepository<Size, Integer> {
    @Query("from Size where sizeName = :name")
    Size getSizeBySizeName(@Param("name") String name);
}

package com.blins.app.Repositories;

import com.blins.app.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository< Customer, Integer> {

}

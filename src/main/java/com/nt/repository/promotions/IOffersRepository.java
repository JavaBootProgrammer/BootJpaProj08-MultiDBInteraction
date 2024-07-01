package com.nt.repository.promotions;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.model.promotions.Offers;

public interface IOffersRepository extends JpaRepository<Offers, Integer> {

}

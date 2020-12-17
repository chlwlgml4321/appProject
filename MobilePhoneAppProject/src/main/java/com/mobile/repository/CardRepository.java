package com.mobile.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mobile.domain.Card;
import com.mobile.domain.Members;
import com.mobile.domain.Review;
import com.mobile.domain.WiredGoods;

public interface CardRepository extends JpaRepository<Card, Long> {



}

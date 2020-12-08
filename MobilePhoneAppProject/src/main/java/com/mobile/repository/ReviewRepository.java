package com.mobile.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mobile.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}

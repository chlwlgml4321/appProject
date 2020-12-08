package com.mobile.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mobile.domain.Recommendation;

public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {

}

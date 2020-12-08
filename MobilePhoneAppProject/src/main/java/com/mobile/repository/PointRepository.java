package com.mobile.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mobile.domain.Point;

public interface PointRepository extends JpaRepository<Point, Long> {

}

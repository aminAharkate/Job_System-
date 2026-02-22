package com.amineaharkate.review_api.review;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewsRepository extends JpaRepository<Review,Long> {
   List<Review> findByCompany_Id(Long companyId);
   Review findByIdAndCompany_Id(Long reviewId, Long companyId);

}

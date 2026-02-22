package com.amineaharkate.review_api.review;

import java.util.List;

public interface ReviewsService {
    List<Review> getAllReviews(Long companyId);
    Review getReviewById(Long companyId, Long reviewId);
    Review addReview(Long companyId, Review review);
    Review updateReview(Long companyId, Long reviewId, Review updatedReview); void deleteReview(Long companyId, Long reviewId);

}

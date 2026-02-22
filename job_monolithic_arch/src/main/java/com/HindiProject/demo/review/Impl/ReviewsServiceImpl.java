package com.HindiProject.demo.review.Impl;

import com.HindiProject.demo.company.Company;
import com.HindiProject.demo.company.CompanyRepository; // <-- fix typo: not "JpaReposotiry"
import com.HindiProject.demo.review.Review;
import com.HindiProject.demo.review.ReviewsRepository;
import com.HindiProject.demo.review.ReviewsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewsServiceImpl implements ReviewsService {

    private final ReviewsRepository reviewsRepository;
    private final CompanyRepository companyRepository;

    public ReviewsServiceImpl(ReviewsRepository reviewsRepository, CompanyRepository companyRepository) {
        this.reviewsRepository = reviewsRepository;
        this.companyRepository = companyRepository;
    }
    @Override
    public Review updateReview(Long companyId, Long reviewId, Review updatedReview) {
        Review existing = reviewsRepository.findByIdAndCompany_Id(reviewId, companyId);
        if (existing == null) {
            throw new RuntimeException("Review not found for company");
        }
        existing.setTitle(updatedReview.getTitle());
        existing.setDescription(updatedReview.getDescription());
        existing.setRating(updatedReview.getRating());
        return reviewsRepository.save(existing);
    }


    @Override
    public List<Review> getAllReviews(Long companyId) {
        return reviewsRepository.findByCompany_Id(companyId);
    }

    @Override
    public Review getReviewById(Long companyId, Long reviewId) {
        return reviewsRepository.findByIdAndCompany_Id(reviewId, companyId);
    }

    @Override
    public Review addReview(Long companyId, Review review) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new RuntimeException("Company not found"));

        review.setCompany(company);
        return reviewsRepository.save(review);
    }



    @Override
    public void deleteReview(Long companyId, Long reviewId) {
        Review existing = reviewsRepository.findByIdAndCompany_Id(reviewId, companyId);
        if (existing == null) {
            throw new RuntimeException("Review not found for company");
        }
        reviewsRepository.delete(existing);
    }
}


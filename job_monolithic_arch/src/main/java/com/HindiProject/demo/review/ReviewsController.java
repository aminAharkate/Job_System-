
package com.HindiProject.demo.review;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}/reviews")
public class ReviewsController {

    private final ReviewsService reviewsService;

    public ReviewsController(ReviewsService reviewsService) {
        this.reviewsService = reviewsService;
    }



    // Update an existing review for a company
    @PutMapping("/{reviewId}")
    public ResponseEntity<Review> updateReview(@PathVariable Long companyId,
                                               @PathVariable Long reviewId,
                                               @RequestBody Review updatedReview) {
        Review updated = reviewsService.updateReview(companyId, reviewId, updatedReview);
        return ResponseEntity.ok(updated);
    }

    // Get all reviews for a company
    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId) {
        return ResponseEntity.ok(reviewsService.getAllReviews(companyId));
    }

    // Get a single review by ID for a company
    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long companyId,
                                                @PathVariable Long reviewId) {
        Review review = reviewsService.getReviewById(companyId, reviewId);
        if (review == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(review);
    }


    // Add a new review to a company
    @PostMapping
    public ResponseEntity<Review> addReview(@PathVariable Long companyId,
                                            @RequestBody Review review) {
        Review created = reviewsService.addReview(companyId, review);
        return ResponseEntity.status(201).body(created);
    }



    // Delete a review for a company
    @DeleteMapping("/{reviewId}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long companyId,
                                             @PathVariable Long reviewId) {
        reviewsService.deleteReview(companyId, reviewId);
        return ResponseEntity.noContent().build();
    }
}


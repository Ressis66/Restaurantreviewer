package com.restorauntreviewer.service;

import com.restorauntreviewer.model.Vote;

import javax.servlet.http.HttpServletRequest;

public interface VoteService {
    Vote voteFor(Long restaurantId, Double rate);
}

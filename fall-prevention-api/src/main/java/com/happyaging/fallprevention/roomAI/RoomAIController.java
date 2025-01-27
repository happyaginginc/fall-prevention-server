package com.happyaging.fallprevention.roomAI;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.happyaging.fallprevention.annotation.LoggedInUser;
import com.happyaging.fallprevention.roomAI.dto.RoomAIRequest;
import com.happyaging.fallprevention.roomAI.dto.RoomAIResponse;
import com.happyaging.fallprevention.roomAI.usecase.RoomAIUseCase;
import com.happyaging.fallprevention.security.details.PrincipalDetails;
import com.happyaging.fallprevention.util.api.ApiResponse;
import com.happyaging.fallprevention.util.api.ApiSuccessResult;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/roomAI")
@RequiredArgsConstructor
public class RoomAIController {
	private final RoomAIUseCase roomAIUseCase;


	@PostMapping
	@PreAuthorize("hasRole('USER') and isAuthenticated()")
	public ResponseEntity<ApiSuccessResult<RoomAIResponse>> analyzeRoom(
		@Valid @RequestBody List<RoomAIRequest> requestDto,
		@LoggedInUser PrincipalDetails principalDetails
	) {
		RoomAIResponse responseBody = roomAIUseCase.analyzeRoom(principalDetails.account(), requestDto);

		return ResponseEntity
			.status(HttpStatus.CREATED)
			.body(ApiResponse.success(HttpStatus.CREATED, responseBody));
	}
}

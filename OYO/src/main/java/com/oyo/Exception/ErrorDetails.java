package com.oyo.Exception;

import java.time.LocalDateTime;

import jakarta.annotation.Generated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {

	private LocalDateTime timeStamp;
	private String message;
	private String description;
	
}

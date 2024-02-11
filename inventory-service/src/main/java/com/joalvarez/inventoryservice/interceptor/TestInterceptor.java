package com.joalvarez.inventoryservice.interceptor;

import com.joalvarez.inventoryservice.shared.HasLogger;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class TestInterceptor implements HandlerInterceptor, HasLogger {

	// TODO overriding preHandle() and postHandle
}
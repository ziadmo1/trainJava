package com.trainJava.demo.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trainJava.demo.abstracts.LeaveRequestService;
import com.trainJava.demo.dtos.CreateLeaveRequestDto;
import com.trainJava.demo.entities.GlobalRes;
import com.trainJava.demo.entities.LeaveRequest;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/v1/leave-requests")
public class LeaveRequestController {

    @Autowired
    LeaveRequestService leaveRequestService;

    @PostMapping("/create/{employeeId}")
    public ResponseEntity<GlobalRes<LeaveRequest>> createLeaveRequest(@Valid @RequestBody CreateLeaveRequestDto dto, @PathVariable UUID employeeId) {
        var leaveRequest = leaveRequestService.createLeaveRequest(dto, employeeId);
        return ResponseEntity.status(HttpStatus.CREATED).body(new GlobalRes<>(leaveRequest));
    }

    @GetMapping("/get-all/{employeeId}")
    public ResponseEntity<GlobalRes<List<LeaveRequest>>> getAllLeaveRequests(@Valid @PathVariable UUID employeeId) {
        var leaveRequests = leaveRequestService.getAllLeaveRequests();
        return ResponseEntity.ok(new GlobalRes<>(leaveRequests));
    }
    

}

package com.trainJava.demo.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trainJava.demo.abstracts.LeaveRequestService;
import com.trainJava.demo.dtos.CreateLeaveRequestDto;
import com.trainJava.demo.entities.LeaveRequest;
import com.trainJava.demo.repositories.EmployeeRepo;
import com.trainJava.demo.repositories.LeaveRequestRepo;
import com.trainJava.demo.shared.CustomResponseExc;

@Service
public class LeaveRequestServiceImpl implements LeaveRequestService {

    @Autowired
    private LeaveRequestRepo leaveRequestRepo;
    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public LeaveRequest createLeaveRequest(CreateLeaveRequestDto dto, UUID employeeId) {
        LeaveRequest leaveRequest = new LeaveRequest();
        leaveRequest.setStartDate(dto.getStartDate());
        leaveRequest.setEndDate(dto.getEndDate());
        leaveRequest.setReason(dto.getReason());
        leaveRequest.setStatus(dto.getStatus());
        var employee = employeeRepo.findById(employeeId).orElseThrow(() -> CustomResponseExc.errorRes(("Employee not found")));
        leaveRequest.setEmployee(employee);
        leaveRequestRepo.save(leaveRequest);
        return leaveRequest;
    }

    @Override
    public List<LeaveRequest> getAllLeaveRequests() {
        return leaveRequestRepo.findAll();
    }
}

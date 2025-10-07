package com.trainJava.demo.abstracts;

import java.util.List;
import java.util.UUID;

import com.trainJava.demo.dtos.CreateLeaveRequestDto;
import com.trainJava.demo.entities.LeaveRequest;

public interface LeaveRequestService {

    LeaveRequest createLeaveRequest(CreateLeaveRequestDto dto, UUID employeeId);

    List<LeaveRequest> getAllLeaveRequests();
}

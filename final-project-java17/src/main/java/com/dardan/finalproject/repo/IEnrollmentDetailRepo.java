package com.dardan.finalproject.repo;

import com.dardan.finalproject.model.EnrollmentDetail;

import java.util.List;

public interface IEnrollmentDetailRepo extends IGenericRepo<EnrollmentDetail, Integer> {
    List<EnrollmentDetail> findByIdEnrollment(Integer name);
}

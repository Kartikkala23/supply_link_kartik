package com.edutech.progressive.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.progressive.entity.Insurance;
import com.edutech.progressive.repository.InsuranceRepository;
import com.edutech.progressive.service.InsuranceService;

@Service
public class InsuranceServiceImpl implements InsuranceService {

    @Autowired
    InsuranceRepository insuranceRepository;

    @Override
    public int addInsurance(Insurance insurance) throws SQLException {
        return insuranceRepository.save(insurance).getInsuranceId();

    }

    @Override
    public void deleteInsurance(int insuranceId) throws SQLException {
        insuranceRepository.deleteById(insuranceId);
    }

    @Override
    public List<Insurance> getAllInsurances() throws SQLException {
        return insuranceRepository.findAll();
    }

    @Override
    public Insurance getInsuranceById(int insuranceId) throws SQLException {
        return insuranceRepository.findByInsuranceId(insuranceId);
    }

    @Override
    public void updateInsurance(Insurance insurance) throws SQLException {
        insuranceRepository.save(insurance);
    }

}
package com.app.ekaly.service;

import com.app.ekaly.model.Admin;
import com.app.ekaly.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public Admin getAdminById(Long id){
        return adminRepository.findById(id).get();
    }

    public Admin getAdminByUsername(String username){
        return adminRepository.findByUsername(username);
    }
}

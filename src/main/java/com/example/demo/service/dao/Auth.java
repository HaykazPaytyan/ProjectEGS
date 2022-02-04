package com.example.demo.service.dao;

import com.example.demo.domain.User;
import com.example.demo.dto.auth.Credential;

public interface Auth {
      public User attempt(Credential credential);
}

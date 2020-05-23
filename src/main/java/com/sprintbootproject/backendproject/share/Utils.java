package com.sprintbootproject.backendproject.share;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class Utils {
 public String generateUserID(){
  return UUID.randomUUID().toString();
 }
}
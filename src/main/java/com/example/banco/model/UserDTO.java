package com.example.banco.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class UserDTO {
  private Long id;
  private String name;
  private String accountNumber;
  private String agency;
  private BigDecimal balance;
  private BigDecimal limit;


}

package com.springBoot.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "orders")
public class Order {
  @Id
  private Integer id;
  private LocalDateTime date;
  private BigDecimal cost;
  @OneToMany(cascade = {CascadeType.ALL})
  @JoinColumn(name = "order_id")
  private List<Product> products;
}

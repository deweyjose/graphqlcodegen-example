package io.github.deweyjose.graphqlcodegen.example.model;

import lombok.Data;

@Data
public class Theater {
  private String name;
  private String location;
  private int capacity;

  public Theater() {}

  public Theater(String name, String location, int capacity) {
    this.name = name;
    this.location = location;
    this.capacity = capacity;
  }
}

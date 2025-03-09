package io.github.deweyjose;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;
import lombok.extern.slf4j.Slf4j;

@Data
@Builder
@Jacksonized
@Slf4j
public class Show {
  private int id;
  private int releaseYear;

  public Show(int id, int releaseYear) {
    if (id < 0) {
      throw new IllegalArgumentException("ID must be non-negative");
    }
    this.id = id;
    this.releaseYear = releaseYear;
  }
}

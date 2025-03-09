package io.github.deweyjose.graphqlcodegen.services;

import com.acme.types.Show;
import com.acme.types.ShowInput;
import java.util.List;

public interface ShowsService {
  List<Show> shows();

  Show add(ShowInput input);
}

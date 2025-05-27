package io.github.deweyjose.graphqlcodegen.example.datafetchers;

import com.acme.types.ShowInput;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;
import io.github.deweyjose.graphqlcodegen.example.common.Show;
import io.github.deweyjose.graphqlcodegen.example.services.ShowsService;
import java.util.List;
import java.util.stream.Collectors;

@DgsComponent
public class ShowsDatafetcher {
  private final ShowsService showsService;

  public ShowsDatafetcher(ShowsService showsService) {
    this.showsService = showsService;
  }

  /**
   * This datafetcher resolves the shows field on Query. It uses an @InputArgument to get the
   * titleFilter from the Query if one is defined.
   */
  @DgsData(parentType = "Query", field = "shows")
  public List<Show> shows(@InputArgument("titleFilter") String titleFilter) {
    if (titleFilter == null) {
      return showsService.shows();
    }

    return showsService.shows().stream()
        .filter(s -> s.getTitle().contains(titleFilter))
        .collect(Collectors.toList());
  }

  @DgsData(parentType = "Mutation", field = "createShow")
  public Show createShow(@InputArgument("showInput") ShowInput showInput) {
    return showsService.add(showInput);
  }
}

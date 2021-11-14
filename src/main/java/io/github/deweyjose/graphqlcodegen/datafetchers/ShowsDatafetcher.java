package io.github.deweyjose.graphqlcodegen.datafetchers;

import com.acme.DgsConstants;
import com.acme.types.Show;
import com.acme.types.ShowInput;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;
import io.github.deweyjose.graphqlcodegen.services.ShowsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

@DgsComponent
public class ShowsDatafetcher {

    private final static Logger log = LoggerFactory.getLogger(ShowsDatafetcher.class);


    private final ShowsService showsService;


    public ShowsDatafetcher(ShowsService showsService) {
        this.showsService = showsService;
    }

    /**
     * This datafetcher resolves the shows field on Query.
     * It uses an @InputArgument to get the titleFilter from the Query if one is defined.
     */
    @DgsData(parentType = DgsConstants.QUERY_TYPE, field = DgsConstants.QUERY.Shows)
    public List<Show> shows(@InputArgument("titleFilter") String titleFilter) {
        if (titleFilter == null) {
            return showsService.shows();
        }

        return showsService.shows().stream().filter(s -> s.getTitle().contains(titleFilter)).collect(Collectors.toList());
    }

    @DgsData(parentType = DgsConstants.MUTATION.TYPE_NAME, field = DgsConstants.MUTATION.CreateShow)
    public Show createShow(@InputArgument("showInput") ShowInput showInput) {
        return showsService.add(showInput);
    }
}
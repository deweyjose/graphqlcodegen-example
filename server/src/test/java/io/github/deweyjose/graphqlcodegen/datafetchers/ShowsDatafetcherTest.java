package io.github.deweyjose.graphqlcodegen.datafetchers;

import com.acme.types.Show;
import com.netflix.graphql.dgs.DgsQueryExecutor;
import com.netflix.graphql.dgs.autoconfig.DgsAutoConfiguration;
import io.github.deweyjose.graphqlcodegen.services.ShowsServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = {
        ShowsDatafetcher.class,
        ShowsServiceImpl.class,
        DgsAutoConfiguration.class
})
class ShowsDatafetcherTest {
    @Autowired DgsQueryExecutor dgsQueryExecutor;

    @Test
    public void testShows() {
        List<String> titles = dgsQueryExecutor.executeAndExtractJsonPath(
                " { shows { title releaseYear }}",
                "data.shows[*].title");

        assertThat(titles).contains("Ozark");
    }

    @Test
    public void testCreateShow() {
        Show show = dgsQueryExecutor.executeAndExtractJsonPathAsObject(
                "mutation { " +
                        "  createShow(showInput:{title:\"foo\", releaseYear:1980}) {" +
                        "    id title releaseYear" +
                        "  }" +
                        "}",
                "data.createShow",
                Show.class
        );
        Assertions.assertThat(show.getTitle()).isEqualTo("foo");
        Assertions.assertThat(show.getReleaseYear()).isEqualTo(1980);
        Assertions.assertThat(show.getId()).isNotNull();
    }
}
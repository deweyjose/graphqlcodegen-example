package io.github.deweyjose.graphqlcodegen.datafetchers;

import com.netflix.graphql.dgs.DgsQueryExecutor;
import com.netflix.graphql.dgs.autoconfig.DgsAutoConfiguration;
import io.github.deweyjose.Foo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {FooDatafetcher.class, DgsAutoConfiguration.class})
class FooDatafetcherTest {
  @Autowired DgsQueryExecutor dgsQueryExecutor;

  @Test
  public void test() {
    Foo foo =
        dgsQueryExecutor.executeAndExtractJsonPathAsObject(
            "query { " + "  bars(foo:123) {" + "    id" + "  }" + "}", "data.bars", Foo.class);
    Assertions.assertThat(foo.getId()).isEqualTo(123);
  }
}

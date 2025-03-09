package io.github.deweyjose.graphqlcodegen.datafetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import io.github.deweyjose.Foo;

@DgsComponent
public class FooDatafetcher {
  @DgsQuery(field = "bars")
  public Foo foos(@InputArgument("foo") Integer fooId) {
    return Foo.builder().id(fooId).build();
  }
}

package io.github.deweyjose.graphqlcodegen.datafetchers;

import com.acme.DgsConstants;
import com.acme.types.Foo;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;

@DgsComponent
public class FooDatafetcher {
    @DgsData(parentType = DgsConstants.QUERY_TYPE, field = DgsConstants.QUERY.Bars)
    public Foo foos(@InputArgument("foo") Integer fooId) {
        return Foo.newBuilder().id(fooId).build();
    }
}

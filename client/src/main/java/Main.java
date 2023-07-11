import com.acme.client.ShowsGraphQLQuery;
import com.acme.client.ShowsProjectionRoot;
import com.netflix.graphql.dgs.client.GraphQLResponse;
import com.netflix.graphql.dgs.client.MonoGraphQLClient;
import com.netflix.graphql.dgs.client.WebClientGraphQLClient;
import com.netflix.graphql.dgs.client.codegen.GraphQLQueryRequest;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

public class Main {
    public static void main(String args[]) {
        //Configure a WebClient for your needs, e.g. including authentication headers and TLS.
        WebClient webClient = WebClient.create("http://localhost:8080/graphql");
        WebClientGraphQLClient client = MonoGraphQLClient.createWithWebClient(webClient);

        //The GraphQLResponse contains data and errors.
        String query = new GraphQLQueryRequest(
                ShowsGraphQLQuery.newRequest()
                        .queryName("shows")
                        .build(),
                new ShowsProjectionRoot<>()
                        .id()
                        .title()

        ).serialize();

        Mono<GraphQLResponse> graphQLResponseMono = client.reactiveExecuteQuery(query);

        //GraphQLResponse has convenience methods to extract fields using JsonPath.
        Mono<Map> response = graphQLResponseMono.map(r -> r.dataAsObject(Map.class));

        //Don't forget to subscribe! The request won't be executed otherwise.
        response.subscribe();
        System.out.println(response.block());
    }
}

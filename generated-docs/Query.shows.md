# Query.shows: [Show!]
                 
## Arguments
| Name | Description | Required | Type |
| :--- | :---------- | :------: | :--: |
| titleFilter |  | Optional | String |
            
## Example
```graphql
{
  shows(titleFilter: "randomString") {
    comments
    id
    releaseYear
    title
  }
}

```
# Query.doNotCodeGen: [Show!]
                 
## Arguments
| Name | Description | Required | Type |
| :--- | :---------- | :------: | :--: |
| titleFilter |  | Optional | String |
            
## Example
```graphql
{
  doNotCodeGen(titleFilter: "randomString") {
    id
    title
    releaseYear
    comments
  }
}

```
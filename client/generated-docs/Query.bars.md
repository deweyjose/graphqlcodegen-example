# Query.bars: Foo
                 
## Arguments
| Name | Description | Required | Type |
| :--- | :---------- | :------: | :--: |
| foo |  | Optional | Int |
            
## Example
```graphql
{
  bars(foo: 123456789) {
    id
    bar
  }
}

```
package com.myapp.models

import com.amazonaws.services.dynamodbv2.datamodeling.*
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor


@Data
@DynamoDBTable(tableName = "level")
@Builder
@NoArgsConstructor
@AllArgsConstructor
class Level() {
    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    public var id: String? = null

    @DynamoDBAttribute
    public  var name: String? = null


}
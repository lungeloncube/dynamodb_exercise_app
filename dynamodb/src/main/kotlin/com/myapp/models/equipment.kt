package com.myapp.models

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor

@Data
@DynamoDBTable(tableName = "equipment")
@Builder
@NoArgsConstructor
@AllArgsConstructor
class Equipment {
    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    private val id: String? = null

    @DynamoDBAttribute
    private val exerciseId: String? = null

    @DynamoDBAttribute
    private val name: String? = null



}
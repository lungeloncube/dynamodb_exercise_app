package com.myapp.models
import com.amazonaws.services.dynamodbv2.datamodeling.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@DynamoDBTable(tableName = "exercise")
@Builder
@NoArgsConstructor
@AllArgsConstructor
class Exercise() {
    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    public var id: String? = null

    @DynamoDBAttribute
    public  var levelId: String? = null

    @DynamoDBAttribute
    public var modalityId: String? = null

    @DynamoDBAttribute
    public var name: String? = null

    @DynamoDBAttribute
    public var exerciseType: String? = null

    @DynamoDBAttribute
    public var exerciseClass: String? = null

    @DynamoDBAttribute
    public var mechanics: String? = null

    @DynamoDBAttribute
    public var altEquipment: String? = null

    @DynamoDBAttribute
    public var altExercise: String? = null

    @DynamoDBAttribute
    public var link: String? = null


}
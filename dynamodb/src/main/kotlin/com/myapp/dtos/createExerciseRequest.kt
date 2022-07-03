package com.myapp.dtos

import com.fasterxml.jackson.annotation.JsonProperty

typealias Root = List<CreateExerciseRequest>;

data class CreateExerciseRequest(
    @JsonProperty("Id")
    val id: String,
    @JsonProperty("Name")
    val name: String,
    @JsonProperty("Level")
    val level: String,
    @JsonProperty("Type")
    val type: Any?,
    @JsonProperty("Class")
    val class_field: String,
    @JsonProperty("Mechanics")
    val mechanics: Any?,
    @JsonProperty("Modality")
    val modality: String,
    @JsonProperty("Equipment")
    val equipment: List<String>,
    @JsonProperty("Alt Equipment")
    val altEquipment: Any?,
    @JsonProperty("Muscles")
    val muscles: List<String>,
    @JsonProperty("Aux Muscles")
    val auxMuscles: List<String>,
    @JsonProperty("Min Muscles")
    val minMuscles: List<String>,
    @JsonProperty("Alt Exercise")
    val altExercise: Any?,
    @JsonProperty("Link")
    val link: String,
)

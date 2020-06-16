package com.example.week9_geolocation.models.geolocation_request_json_parsing_models

data class Prediction(
    val description: String,
    val id: String,
    val matched_substrings: List<MatchedSubstring>,
    val place_id: String,
    val reference: String,
    val structured_formatting: StructuredFormatting,
    val terms: List<Term>,
    val types: List<String>
)
package com.example.week9_geolocation.models.geolocation_request_json_parsing_models

import com.example.week9_geolocation.models.geolocation_request_json_parsing_models.MainTextMatchedSubstring

data class StructuredFormatting(
    val main_text: String,
    val main_text_matched_substrings: List<MainTextMatchedSubstring>,
    val secondary_text: String
)
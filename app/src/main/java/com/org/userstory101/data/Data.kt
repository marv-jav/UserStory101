package com.org.userstory101.data

val Q1 = listOf(
    Triple(0.5f, 0.2f, "Jan"),
    Triple(0.6f, 0.3f, "Feb"),
    Triple(0.2f, 0.5f, "Mar"),
    Triple(0.7f, 0.4f, "Apr"),
)

val Q2 = listOf(
    Triple(0.5f, 0.2f, "May"),
    Triple(0.6f, 0.3f, "Jun"),
    Triple(0.2f, 0.5f, "July"),
    Triple(0.7f, 0.4f, "Aug"),
)

val Q3 = listOf(
    Triple(0.5f, 0.2f, "Sep"),
    Triple(0.6f, 0.3f, "Oct"),
    Triple(0.2f, 0.5f, "Nov"),
    Triple(0.7f, 0.4f, "Dec"),
)

fun updateFilters(
    filter: String,
    isSelected: Boolean,
    currentFilters: List<String>,
    onUpdate: (List<String>) -> Unit
) {
    val updatedFilters = if (isSelected) {
        currentFilters + filter
    } else {
        currentFilters - filter
    }
    onUpdate(updatedFilters)
}
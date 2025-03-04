package com.example.demo

data class Hero(val name: String, val age: Int, val type: HeroType?)
enum class HeroType {
    MALE,
    FEMALE
}
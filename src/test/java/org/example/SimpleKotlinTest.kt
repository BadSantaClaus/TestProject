package org.example

import org.assertj.core.api.Assertions
import org.example.reflection.Employee
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SimpleKotlinTest {

    @Test
    fun test1() {
        val map1 = mutableMapOf("name" to "John", "age" to 21)
        val map2= mutableMapOf("name" to "Bob", "age" to 21)
        val map3= mutableMapOf("name" to "Bob", "age" to 21)
        val map4= mutableMapOf("name" to "Bob", "age" to 21)
        val list = mutableListOf(map1, map2)
        val list2 = listOf(map3, map4)
        Assertions.assertThat(map1)
            .usingRecursiveComparison()
            .ignoringFields("name")
            .isEqualTo(map2)

        Assertions.assertThat(list)
            .usingRecursiveComparison()
            .ignoringFields("name")
            .isEqualTo(list2)

    }
}
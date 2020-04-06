package ru.skillbranch.devintensive.utils

import ru.skillbranch.devintensive.extensions.translitChar

object Utils {

    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val parts: List<String>? = fullName?.split(" ")

        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)

        return Pair(firstName, lastName)
    }

    fun toInitials(firstName: String? = null, lastName: String? = ""): String? {

        val firstIn = if (firstName != null) {
            if (firstName.trim().isNotEmpty()) {
                firstName.substring(0,1).toUpperCase()
            } else {
                ""
            }
        } else {
            ""
        }

        val secondIn = if (lastName != null) {
            if (lastName.trim().isNotEmpty()) {
                lastName.substring(0,1).toUpperCase()
            } else {
                ""
            }
        } else {
            ""
        }

        return firstIn+secondIn
    }

    fun transliteration(payload: String, divider: String = " "): String {

        val (firstName, lastName) = parseFullName(payload)

        var firstNameTranlite = ""
        var lastNameTranlite = ""

        if (firstName != null) {
            for (char in firstName) {
                firstNameTranlite += translitChar(char)
            }
        }

        if (lastName != null) {
            for (char in lastName) {
                lastNameTranlite += translitChar(char)
            }
        }

        return firstNameTranlite.capitalize() + divider + lastNameTranlite.capitalize()
    }
}
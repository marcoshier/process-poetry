package lib

import java.util.Calendar

class Time {
    val calendar = Calendar.getInstance()

    val daysOfTheWeek = listOf("MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY")
    val workHours: Double = 8.0

    val today
        get() = daysOfTheWeek[calendar.get(Calendar.DAY_OF_WEEK)]

}
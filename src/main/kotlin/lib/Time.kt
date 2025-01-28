package lib

import Visualizable
import org.openrndr.events.Event
import visualizer.Colors
import visualizer.Properties
import java.util.Calendar

@Properties(
    Colors.LIGHT_GREEN,
    0.5
)
class Time: Visualizable() {
    val calendar = Calendar.getInstance()

    val daysOfTheWeek = listOf("MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY")
    val workHours: Double = 8.0

    val today
        get() = daysOfTheWeek[calendar.get(Calendar.DAY_OF_WEEK)]

    val nextDay = Event<Unit>()
}

package lib

import Visualizable
import lib.Void
import visualizer.Colors
import visualizer.Properties

@Properties(
    Colors.LIGHT_GREEN,
    0.5
)
class Void: List<Any>, Visualizable() {
    override val size: Int
        get() = TODO("Not yet implemented")

    override fun contains(element: Any): Boolean {
        TODO("Not yet implemented")
    }

    override fun containsAll(elements: Collection<Any>): Boolean {
        TODO("Not yet implemented")
    }

    override fun get(index: Int): Any {
        TODO("Not yet implemented")
    }

    override fun indexOf(element: Any): Int {
        TODO("Not yet implemented")
    }

    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }

    override fun iterator(): Iterator<Any> {
        TODO("Not yet implemented")
    }

    override fun lastIndexOf(element: Any): Int {
        TODO("Not yet implemented")
    }

    override fun listIterator(): ListIterator<Any> {
        TODO("Not yet implemented")
    }

    override fun listIterator(index: Int): ListIterator<Any> {
        TODO("Not yet implemented")
    }

    override fun subList(fromIndex: Int, toIndex: Int): List<Any> {
        TODO("Not yet implemented")
    }
}

val void: Void = Void()
val gone = ""

interface Present
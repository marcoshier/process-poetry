package io

class Input {
    fun build(block: () -> Unit) {
        block()
    }
}
package kdx.backend.glfw

import kdx.*

class GLFWApplicationLogger : ApplicationLogger
{
    override fun log(tag: String, message: String)
    {
        println("$tag: $message")
    }

    override fun log(tag: String, message: String, exception: Throwable)
    {
        println("$tag: $message")
        println(exception)
    }

    override fun error(tag: String, message: String)
    {
        println("$tag: $message")
    }

    override fun error(tag: String, message: String, exception: Throwable)
    {
        println("$tag: $message")
        println(exception)
    }

    override fun debug(tag: String, message: String)
    {
        println("$tag: $message")
    }

    override fun debug(tag: String, message: String, exception: Throwable)
    {
        println("$tag: $message")
        println(exception)
    }

}
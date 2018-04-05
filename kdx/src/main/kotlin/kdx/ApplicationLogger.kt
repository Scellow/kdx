package kdx

interface ApplicationLogger
{
    fun log(tag: String, message: String)
    fun log(tag: String, message: String, exception: Throwable)
    fun error(tag: String, message: String)
    fun error(tag: String, message: String, exception: Throwable)
    fun debug(tag: String, message: String)
    fun debug(tag: String, message: String, exception: Throwable)
}
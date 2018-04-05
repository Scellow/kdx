package kdx

interface ApplicationListener
{
    fun create()
    fun resize(width: Int, height: Int)
    fun render()
    fun pause()
    fun resume()
    fun dispose()
}

abstract class ApplicationAdapter : ApplicationListener
{
    override fun create()
    {
    }

    override fun resize(width: Int, height: Int)
    {
    }

    override fun render()
    {
    }

    override fun pause()
    {
    }

    override fun resume()
    {
    }

    override fun dispose()
    {
    }
}

interface Application
{
    enum class ApplicationType
    {
        Android, Desktop, HeadlessDesktop, Applet, WebGL, iOS
    }

    companion object
    {
        const val LOG_NONE: Int = 0
        const val LOG_DEBUG: Int = 3
        const val LOG_INFO: Int = 2
        const val LOG_ERROR: Int = 1
    }

    fun getApplicationListener(): ApplicationListener

    fun getGraphics(): Graphics

    fun getInput(): Input

    fun getFiles(): Files


    fun log(tag: String, message: String)

    fun log(tag: String, message: String, exception: Throwable)

    fun error(tag: String, message: String)

    fun error(tag: String, message: String, exception: Throwable)

    fun debug(tag: String, message: String)

    fun debug(tag: String, message: String, exception: Throwable)

    fun setLogLevel(logLevel: Int)

    fun getLogLevel(): Int

    fun setApplicationLogger(applicationLogger: ApplicationLogger)

    fun getApplicationLogger(): ApplicationLogger

    fun getType(): ApplicationType

    fun getVersion(): Int

    fun exit()

    fun addLifecycleListener(listener: LifecycleListener)

    fun removeLifecycleListener(listener: LifecycleListener)
}



package kdx.backend.glfw

import kdx.*

import konan.worker.*
import libglfw.*


class GLFWApplication (listener: ApplicationListener, config: GLFWApplicationConfiguration): Application
{

    private val config: GLFWApplicationConfiguration
    private val windows: MutableList<GLFWWindow> = mutableListOf()
    private var currentWindow:GLFWWindow? = null
    // audio
    private val files: Files
    // net
    // pref
    // clipboard
    private var logLevel: Int = LOG_INFO
    private var applicationLogger: ApplicationLogger? = null
    private var running: Boolean = true

    // runnables
    // executedRunnables

    val lifecycleListeners: MutableList<LifecycleListener> = mutableListOf()
    // error callback
    // glversion
    // debug callback

    init
    {
        initialiseGlfw()
        setApplicationLogger(GLFWApplicationLogger())
        this.config = GLFWApplicationConfiguration.copy(config)
        // set title
        Kdx.app = this
        // audio
        files = GLFWFiles()
        Kdx.files = files
        // net
        //clipboard

        val window = createWindow(config, listener, 0)
        windows.add(window)

        loop()
        cleanupWindows()
        cleanup()
    }

    private fun loop()
    {}

    private fun cleanupWindows()
    {
        for (licecycleListener in lifecycleListeners)
        {
            licecycleListener.pause()
            licecycleListener.dispose()
        }

        for (window in windows)
            window.dispose()

        windows.clear()
    }

    private fun cleanup()
    {
        // dispose cursors
        // dispose audio

        glfwTerminate()
    }

    override fun getApplicationListener(): ApplicationListener
    {
        currentWindow?.getListener()
    }

    override fun getGraphics(): Graphics
    {
        currentWindow?.getGraphics()
    }

    override fun getInput(): Input
    {
        currentWindow?.getInput()
    }

    override fun getFiles(): Files
    {
        files
    }

    override fun log(tag: String, message: String)
    {

    }

    override fun log(tag: String, message: String, exception: Throwable)
    {

    }

    override fun error(tag: String, message: String)
    {

    }

    override fun error(tag: String, message: String, exception: Throwable)
    {

    }

    override fun debug(tag: String, message: String)
    {

        if (logLevel >= LOG_DEBUG) getApplicationLogger().debug(tag, message)
    }

    override fun debug(tag: String, message: String, exception: Throwable)
    {
        if (logLevel >= LOG_DEBUG) getApplicationLogger().debug(tag, message, exception)

    }

    override fun setLogLevel(logLevel: Int)
    {
        this.logLevel = logLevel
    }

    override fun getLogLevel(): Int
    {
        return logLevel
    }

    override fun setApplicationLogger(applicationLogger: ApplicationLogger)
    {
        this.applicationLogger = applicationLogger
    }

    override fun getApplicationLogger(): ApplicationLogger
    {
        return applicationLogger
    }

    override fun getType(): Application.ApplicationType
    {
        return Application.ApplicationType.Desktop
    }

    override fun getVersion(): Int
    {
        return 0
    }

    override fun exit()
    {
        running = false
    }

    override fun addLifecycleListener(listener: LifecycleListener)
    {
        lifecycleListeners.add(listener)
    }

    override fun removeLifecycleListener(listener: LifecycleListener)
    {
        lifecycleListeners.remove(listener)
    }

    fun createWindow(config: GLFWApplicationConfiguration, listener: ApplicationListener, sharedContext: Long): GLFWWindow
    {
        val window = GLFWWindow(listener, config)
        if(sharedContext == 0L)
            createWindow(window, config, sharedContext)

        return window
    }


    fun createWindow(window: GLFWWindow, config: GLFWApplicationConfiguration, sharedContext: Long)
    {

    }

    companion object
    {
        fun createGlfwWindow(config: GLFWApplicationConfiguration, sharedContextWindow: Long)
        {
            glfwDefaultWindowHints()
            glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE)
            glfwWindowHint(GLFW_RESIZABLE, if (config.windowResizable) GLFW_TRUE else GLFW_FALSE)
            glfwWindowHint(GLFW_MAXIMIZED, if (config.windowMaximized) GLFW_TRUE else GLFW_FALSE)

            if (sharedContextWindow == 0L)
            {
                glfwWindowHint(GLFW_RED_BITS, config.r)
                glfwWindowHint(GLFW_GREEN_BITS, config.g)
                glfwWindowHint(GLFW_BLUE_BITS, config.b)
                glfwWindowHint(GLFW_ALPHA_BITS, config.a)
                glfwWindowHint(GLFW_STENCIL_BITS, config.stencil)
                glfwWindowHint(GLFW_DEPTH_BITS, config.depth)
                glfwWindowHint(GLFW_SAMPLES, config.samples)
            }

            if (config.useGL30)
            {
                glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, config.gles30ContextMajorVersion)
                glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, config.gles30ContextMinorVersion)
                if (SharedLibraryLoader.isMac)
                {
                    // hints mandatory on OS X for GL 3.2+ context creation, but fail on Windows if the
                    // WGL_ARB_create_context extension is not available
                    // see: http://www.org/docs/latest/compat.html
                    glfwWindowHint(GLFW_OPENGL_FORWARD_COMPAT, GLFW_TRUE)
                    glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE)
                }
            }

            if (config.debug)
            {
                glfwWindowHint(GLFW_OPENGL_DEBUG_CONTEXT, GLFW_TRUE)
            }

            val pointer = if(config.fullscreenMode != null) g

        }
    }

}
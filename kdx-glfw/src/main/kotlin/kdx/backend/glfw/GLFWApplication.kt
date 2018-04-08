package kdx.backend.glfw

import kdx.*
import kotlinx.cinterop.*
import kotlin.math.*
import konan.worker.*
import libglfw.*


class GLFWApplication (listener: ApplicationListener, config: GLFWApplicationConfiguration): Application
{

    companion object
    {
        fun initialiseGlfw()
        {
            if (glfwInit() == GLFW_FALSE)
                println("Init failed!")
            else
                println("Init good")
        }

        fun createGlfwWindow(config: GLFWApplicationConfiguration, sharedContextWindow: Long) : CPointer<GLFWwindow>
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

                // TODO: use platform project
                //if (SharedLibraryLoader.isMac)
                if(false)
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

            val windowHandle =
                    if (config.fullscreenMode != null)
                        glfwCreateWindow(config.fullscreenMode.width, config.fullscreenMode.height, config.title, config.fullscreenMode.getMonitor(), null) // TODO: shared context?
                    else
                    {
                        glfwWindowHint(GLFW_DECORATED, if (config.windowDecorated) GLFW_TRUE else GLFW_FALSE)
                        glfwCreateWindow(config.windowWidth, config.windowHeight, config.title, null, null)
                    }

            if(windowHandle == null) throw Exception("unable to create window")


            GLFWWindow.setSizeLimits(windowHandle, config.windowMinWidth, config.windowMinHeight, config.windowMaxWidth, config.windowMaxHeight)


            if (config.fullscreenMode == null && !config.windowMaximized)
            {
                if (config.windowX === -1 && config.windowY === -1)
                {
                    var windowWidth = max(config.windowWidth, config.windowMinWidth)
                    var windowHeight = max(config.windowHeight, config.windowMinHeight)
                    if (config.windowMaxWidth > -1) windowWidth = min(windowWidth, config.windowMaxWidth)
                    if (config.windowMaxHeight > -1) windowHeight = min(windowHeight, config.windowMaxHeight)

                    // TODO: handle monitor stuff
                    //val vidMode = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor())
                    //GLFW.glfwSetWindowPos(windowHandle, vidMode.width() / 2 - windowWidth / 2, vidMode.height() / 2 - windowHeight / 2)

                } else
                {
                    glfwSetWindowPos(windowHandle, config.windowX, config.windowY)
                }
            }

            glfwMakeContextCurrent(windowHandle)
            glfwSwapInterval(if (config.vSyncEnabled) 1 else 0)

            //initiateGL()

            return windowHandle
        }
    }

    private val config: GLFWApplicationConfiguration
    private val windows: MutableList<GLFWWindow> = mutableListOf()
    private var currentWindow:GLFWWindow? = null
    // audio
    private val files: Files
    // net
    // pref
    // clipboard
    private var logLevel: Int = Application.LOG_INFO
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
        return currentWindow?.getListener()!!
    }

    override fun getGraphics(): Graphics
    {
        return currentWindow?.getGraphics()!!
    }

    override fun getInput(): Input
    {
        return currentWindow?.getInput()!!
    }

    override fun getFiles(): Files
    {
        return files!!
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

        if (logLevel >= Application.LOG_DEBUG) getApplicationLogger().debug(tag, message)
    }

    override fun debug(tag: String, message: String, exception: Throwable)
    {
        if (logLevel >= Application.LOG_DEBUG) getApplicationLogger().debug(tag, message, exception)

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
        val windowHandle = createGlfwWindow(config, sharedContext)
        window.create(windowHandle)
        window.setVisible(config.initialVisible)

        for (i in 0..1)
        {
            glClearColor(config.initialBackgroundColor.r, config.initialBackgroundColor.g, config.initialBackgroundColor.b, config.initialBackgroundColor.a)
            glClear(GL11.GL_COLOR_BUFFER_BIT)
            glfwSwapBuffers(windowHandle)
        }
    }
}
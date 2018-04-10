package kdx.backend.glfw

import kdx.*
import libglfw.*
import sun.security.krb5.internal.tools.Ktab

class GLFWWindow(val listener: ApplicationListener, val config: GLFWConfig)
{
    companion object
    {
        fun setSizeLimits(windowHandle: CPointer<GLFWwindow>, minWidth: Int, minHeight: Int, maxWidth: Int, maxHeight: Int)
        {
            glfwSetWindowSizeLimits(windowHandle,
                    if (minWidth > -1) minWidth else GLFW_DONT_CARE,
                    if (minHeight > -1) minHeight else GLFW_DONT_CARE,
                    if (maxWidth > -1) maxWidth else GLFW_DONT_CARE,
                    if (maxHeight > -1) maxHeight else GLFW_DONT_CARE)
        }
    }
    var windowHandle: CPointer<GLFWwindow>? = null
    var listenerInitialized = false
    var windowListener: GLFWWindowListener? = null
    var graphics: GLFWGraphics? = null
    var input: GLFWInput? = null

    // runables

    private var iconified = false
    private var requestRendering = false

    fun create(handle: CPointer<GLFWwindow>)
    {
        windowHandle = handle
        input = GLFWInput(this)
        graphics = GLFWGraphics(this)

        // callbacks

        windowListener?.created(this)
    }

    private fun windowHandleChanged(handle: CPointer<GLFWwindow>)
    {
        windowHandle = handle
        input?.windowHandleChanged(windowHandle)
    }

    private fun update()
    {
        if (!listenerInitialized)
            initializeListener()

        // run runables

        if (!iconified)
            input?.update()

        val shouldRender = true // should check iconified and requestRendering
        requestRendering = false

        if (shouldRender)
        {
            graphics?.update()
            listener.render()

            glfwSwapBuffers(windowHandle)
        }

        if (!iconified)
            input?.prepareNext()
    }

    private fun requestRendering()
    {
        requestRendering = true
    }

    private fun initializeListener()
    {
        if (!listenerInitialized)
        {
            listener.create()
            listener.resize(graphics?.width, graphics?.height)
            listenerInitialized = true
        }
    }

    private fun makeCurrent()
    {
        Kdx.graphics = graphics
        // gl stuff
        Kdx.input = input

        glfwMakeContextCurrent(windowHandle)
    }

    fun getListener(): ApplicationListener
    {
        return listener
    }

    fun getWindowListener(): Lwjgl3WindowListener?
    {
        return windowListener
    }

    fun setWindowListener(listener: Lwjgl3WindowListener)
    {
        this.windowListener = listener
    }


    internal fun getGraphics(): GLFWGraphics?
    {
        return graphics
    }

    internal fun getInput(): GLFWInput?
    {
        return input
    }

    fun getWindowHandle(): CPointer<GLFWwindow>?
    {
        return windowHandle
    }

    internal fun windowHandleChanged(windowHandle: CPointer<GLFWwindow>)
    {
        this.windowHandle = windowHandle
        input.windowHandleChanged(windowHandle)
    }

    fun setVisible(visible: Boolean)
    {
        if (visible)
        {
            glfwShowWindow(windowHandle)
        } else
        {
            glfwHideWindow(windowHandle)
        }
    }

    fun dispose()
    {
        //todo cleanup
    }
}
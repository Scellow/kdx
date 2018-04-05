package kdx.backend.glfw

import kdx.*
import libglfw.*
import sun.security.krb5.internal.tools.Ktab

class GLFWWindow(val listener: ApplicationListener, val config: GLFWConfig)
{
    var windowHandle: CPointer<GLFWwindow>? = null
    var listenerInitialized = false
    var windowListener: GLFWWindowListener? = null
    var graphics: GLFWGraphics? = null
    var input: GLFWInput? = null

    // runables

    private var iconified = false
    private var requestRendering = false

    fun create(handle: Long)
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

    fun dispose()
    {
        //todo cleanup
    }
}
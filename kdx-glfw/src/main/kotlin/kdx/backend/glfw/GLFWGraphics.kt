package kdx.backend.glfw

import kdx.*
import libglfw.*
import libglew.*
import kotlinx.cinterop.*
import platform.posix.clock


class GLFWDisplayMode(val monitorHandle: CPointer<GLFWmonitor>, val width:Int, val height:Int, val refreshRate:Int, val bitsPerPixel: Int)
    : Monitor(width, height, refreshRate, bitsPerPixel)
{

    fun getMonitor(): CPointer<GLFWmonitor>
    {
        return monitorHandle
    }
}

class GLFWMonitor(val monitorHandle: CPointer<GLFWmonitor>, val virtualX: Int, val virtualY: Int, val name: String)
    : Monitor(virtualX, virtualY, name)
{
    fun getMonitorHandle(): CPointer<GLFWmonitor>
    {
        return monitorHandle
    }
}

class GLFWGraphics(val window: GLFWWindow) : Graphics
{
    @Volatile
    private var backBufferWidth: Int = 0
    @Volatile
    private var backBufferHeight: Int = 0
    @Volatile
    private var logicalWidth: Int = 0
    @Volatile
    private var logicalHeight: Int = 0
    @Volatile
    private var isContinuous = true
    private var bufferFormat: BufferFormat? = null
    private var lastFrameTime: Long = -1
    private var deltaTime: Float = 0f
    private var frameId: Long = 0
    private var frameCounterStart: Long = 0
    private var frames: Int = 0
    private var fps: Int = 0
    private var windowPosXBeforeFullscreen: Int = 0
    private var windowPosYBeforeFullscreen: Int = 0
    private var displayModeBeforeFullscreen: DisplayMode? = null

    init
    {
        updateFramebufferInfo()
        // TODO: properly handle GL2/GL3
        //initiateGL()
        // TODO: handle callbacks
        //GLFW.glfwSetFramebufferSizeCallback(window.getWindowHandle(), resizeCallback)
    }

    private fun updateFramebufferInfo()
    {
        memscoped {
            var buffer1 = alloc<IntVar>()
            var buffer2 = alloc<IntVar>()
            glfwGetFramebufferSize(window.getWindowHandle(), buffer1, buffer2)
            backBufferWidth = buffer1.value
            backBufferHeight = buffer2.value

            glfwGetWindowSize(window.getWindowHandle(), buffer1, buffer2)
            logicalWidth = buffer1.value
            logicalHeight = buffer2.value
        }

        val config = window.getConfig()
        bufferFormat = BufferFormat(config.r, config.g, config.b, config.a, config.depth, config.stencil,
                config.samples, false)
    }

    private fun update()
    {
        val time = clock()
        if (lastFrameTime == -1)
            lastFrameTime = time
        deltaTime = (time - lastFrameTime) / 1000000000.0f
        lastFrameTime = time

        if (time - frameCounterStart >= 1000000000)
        {
            fps = frames
            frames = 0
            frameCounterStart = time
        }
        frames++
        frameId++
    }

    override fun isGL30Available(): Boolean
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getWidth(): Int
    {
        return if (window.getConfig().hdpiMode === HdpiMode.Pixels)
        {
            backBufferWidth
        } else
        {
            logicalWidth
        }
    }

    override fun getHeight(): Int
    {
        return if (window.getConfig().hdpiMode === HdpiMode.Pixels)
        {
            backBufferHeight
        } else
        {
            logicalHeight
        }
    }

    override fun getBackBufferWidth(): Int
    {backBufferWidth}

    override fun getBackBufferHeight(): Int
    {backBufferHeight}

    override fun getFrameId(): Long
    {frameId}

    override fun getDeltaTime(): Float
    {deltaTime}

    override fun getRawDeltaTime(): Float
    {deltaTime}

    override fun getFramesPerSecond(): Int
    {fps }

    override fun getType(): GraphicsType
    {GraphicsType.GLFW;}

    override fun getPpiX(): Float
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getPpiY(): Float
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getPpcX(): Float
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getPpcY(): Float
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getDensity(): Float
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun supportsDisplayModeChange(): Boolean
    {
        true
    }

    override fun getPrimaryMonitor(): Monitor
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getMonitor(): Monitor
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getMonitors(): Array<Monitor>
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getDisplayModes(): Array<DisplayMode>
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getDisplayModes(monitor: Monitor): Array<DisplayMode>
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getDisplayMode(): DisplayMode
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getDisplayMode(monitor: Monitor): DisplayMode
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setFullscreenMode(displayMode: DisplayMode): Boolean
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setWindowedMode(width: Int, height: Int): Boolean
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setTitle(title: String)
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setUndecorated(undecorated: Boolean)
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setResizable(resizable: Boolean)
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setVSync(vsync: Boolean)
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getBufferFormat(): BufferFormat
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun supportsExtension(extension: String): Boolean
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setContinuousRendering(isContinuous: Boolean)
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isContinuousRendering(): Boolean
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun requestRendering()
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isFullscreen(): Boolean
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
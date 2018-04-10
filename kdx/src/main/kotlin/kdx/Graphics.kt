package kdx

enum class GraphicsType
{
    GLFW, Mock
}

open class DisplayMode(val width: Int = 0, val height: Int = 0, val refreshRate: Int = 0, val bitsPerPixel: Int = 0)

open class Monitor(val virtualX: Int = 0, val virtualY: Int = 0, val name: String = "")

open class BufferFormat(val r: Int = 0, val g: Int = 0, val b: Int = 0, val a: Int = 0, val depth: Int = 0, val stencil: Int = 0, val samples: Int = 0, val coverageSampling: Boolean = false)




interface Graphics
{


    fun isGL30Available(): Boolean
    fun getWidth(): Int
    fun getHeight(): Int
    fun getBackBufferWidth(): Int
    fun getBackBufferHeight(): Int
    fun getFrameId(): Long
    fun getDeltaTime(): Float
    fun getRawDeltaTime(): Float
    fun getFramesPerSecond(): Int
    fun getType(): GraphicsType
    fun getPpiX(): Float
    fun getPpiY(): Float
    fun getPpcX(): Float
    fun getPpcY(): Float
    fun getDensity(): Float
    fun supportsDisplayModeChange(): Boolean
    fun getPrimaryMonitor(): Monitor
    fun getMonitor(): Monitor
    fun getMonitors(): Array<Monitor>
    fun getDisplayModes(): Array<DisplayMode>
    fun getDisplayModes(monitor: Monitor): Array<DisplayMode>
    fun getDisplayMode(): DisplayMode
    fun getDisplayMode(monitor: Monitor): DisplayMode
    fun setFullscreenMode(displayMode: DisplayMode): Boolean
    fun setWindowedMode(width: Int, height: Int): Boolean
    fun setTitle(title: String)
    fun setUndecorated(undecorated: Boolean)
    fun setResizable(resizable: Boolean)
    fun setVSync(vsync: Boolean)
    fun getBufferFormat(): BufferFormat
    fun supportsExtension(extension: String): Boolean
    fun setContinuousRendering(isContinuous: Boolean)
    fun isContinuousRendering(): Boolean
    fun requestRendering()
    fun isFullscreen(): Boolean
}
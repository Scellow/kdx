package kdx.backend.glfw

import kdx.*

import platform.posix.clock

class GLFWGraphics(val config: GLFWConfig) : Graphics {

    private var _frameId: Long = -1
    private var _deltaTime = 0f
    private var _frameStart: Long = 0
    private var _frames = 0
    private var _fps: Int = 0
    private var _lastTime = clock() //todo: check if it is the same as System.nanotime()
    private var _vsync = false
    private var _resize = false
    private var _bufferFormat = Graphics.BufferFormat(8, 8, 8, 8, 16, 8, 0, false)
    private var _isContinuous = true
    private var _requestRendering = false
    private var _softwareMode: Boolean = false
    private var _usingGL30: Boolean = false

    override val isGL30Available: Boolean
        get() = true

    override val width: Int
        get() {
            return
        }
    override val height: Int
        get() {
            return 0
        }

    override val backBufferWidth: Int
        get() = width
    override val backBufferHeight: Int
        get() = height

    override val frameId: Long
        get() = _frameId
    override val deltaTime: Float
        get() = _deltaTime
    override val rawDeltaTime: Float
        get() = _deltaTime
    override val framesPerSecond: Int
        get() = _fps
    override val type: Graphics.GraphicsType
        get() = Graphics.GraphicsType.GLFW
    override val ppiX: Float
        get() = 0f
    override val ppiY: Float
        get() = 0f
    override val ppcX: Float
        get() = 0f
    override val ppcY: Float
        get() = 0f
    override val density: Float
        get() = 0f
    override val primaryMonitor: Graphics.Monitor
        get() = Graphics.Monitor(0, 0, "Primary Monitor")
    override val monitor: Graphics.Monitor
        get() = primaryMonitor
    override val monitors: Array<Graphics.Monitor>
        get() = arrayOf(primaryMonitor)
    override val displayModes: Array<Graphics.DisplayMode>
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    override val displayMode: Graphics.DisplayMode
        get() = TODO("not implemented")
    override val bufferFormat: Graphics.BufferFormat
        get() = _bufferFormat
    override var isContinuousRendering: Boolean
        get() = _isContinuous
        set(value) {
            _isContinuous = value
        }
    override val isFullscreen: Boolean
        get() = false


    override fun supportsDisplayModeChange(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getDisplayModes(monitor: Graphics.Monitor): Array<Graphics.DisplayMode> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getDisplayMode(monitor: Graphics.Monitor): Graphics.DisplayMode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setFullscreenMode(displayMode: Graphics.DisplayMode): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setWindowedMode(width: Int, height: Int): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setTitle(title: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setUndecorated(undecorated: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setResizable(resizable: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setVSync(vsync: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun supportsExtension(extension: String): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun requestRendering() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun setupDisplay()
    {

    }
}